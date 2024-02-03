package com.example.front.controller.adminController;

import com.example.front.Model.ShoppingCart;
import com.example.front.repository.AppRepository;
import com.example.front.repository.PictureEntity;
import com.example.front.repository.ProductEntity;
import com.example.front.repository.UserRepository;
import com.example.front.service.AdminService;
import com.example.front.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/basket")
public class AdminController {
    List<ProductEntity> product;
    List<UserEntity> users;
    private int sumPrice;
    private int cartQuantity;
    @Autowired
    AdminService service;
    @GetMapping("/admin")
    String adminPage(HttpSession session, Model model){
        service.setAdminMVC(session, model, product, cartQuantity, sumPrice);
        return "/admin/adminPage";
    }
    @GetMapping("/admin/deleteProductPage")
    String deleteProductPage(HttpSession session, Model model){
        service.setAdminMVC(session, model, product, cartQuantity, sumPrice);
        return "/admin/adminPage";
    }

    @GetMapping("/admin/deleteProduct")
    String removeProductById(HttpSession session, Model model, @RequestParam(name = "product") long id){
        service.setDeleteProduct(session, model, product, id);
        return "/admin/adminPage";
    }


    @GetMapping("/admin/searchbyname")
    public String searchByName(HttpSession session, Model model, @RequestParam(name = "name") String name) {
        service.setSearchProductByName(session, model, product, name);
        return "/admin/adminPage";
    }


    @GetMapping("/admin/productDetail")
    String adminProductInfo(Model model, HttpSession session, @RequestParam(name = "id") long id){
        service.setDetailMVC(session, model, id);
        return "/admin/adminProductInfo";
    }

    @GetMapping("/admin/deleteUserPage")
    String removePage(HttpSession session, Model model){

        service.setDeleteUserPageMVC(session, model);
        return "/admin/deleteUser";
        }

    @GetMapping("/admin/deleteUserById**")
    String deleteUser(HttpSession session, Model model, @RequestParam(name = "userId") long user){
        service.deleteUserByIdMVC(session, model, user);
        return "/admin/deleteUser";
        }


    @GetMapping("/admin/searchbyusername")
    String deleteUser(HttpSession session, Model model, @RequestParam(name = "username") String username){
        service.setDeleteUserByName(session, model, username);
        return "/admin/deleteUser";
    }
    @GetMapping("/admin/addProduct")
    public String addProductPage(HttpSession session, Model model){
        service.setAddProductPageMVC(session, model);
        return "/admin/addProductPage";
    };
    @GetMapping("/admin/addProductToDB")
    public String addProductToDB(@RequestParam(name="name") String name, @RequestParam(name="description") String description ,
                                 @RequestParam(name="price") int price, @RequestParam(name="size") int size, @RequestParam(name="brand") String brand,
                                 @RequestParam(name="numberOfPlayer") int numberOfPlayer, @RequestParam(name="warranty") int warranty,
                                 @RequestParam(name="category") int category, @RequestParam(name="picture0") String picture0,
                                 @RequestParam(name="picture1", required = false) Optional<String> picture1, @RequestParam(name="picture2",  required = false) Optional<String> picture2,
                                 @RequestParam(name="picture3", required = false) Optional<String> picture3 , @RequestParam(name="picture4", required = false) Optional<String> picture4){

        service.setAddProductToDB(name,description, price,size, brand, numberOfPlayer, warranty,
                category, picture0, picture1, picture2, picture3 ,picture4);
return "/admin/addProductPage";
    }
}
