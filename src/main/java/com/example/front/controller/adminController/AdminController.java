package com.example.front.controller.adminController;

import com.example.front.Model.ShoppingCart;
import com.example.front.repository.AppRepository;
import com.example.front.repository.ProductEntity;
import com.example.front.repository.UserRepository;
import com.example.front.user.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
//@RequestMapping("/basket")
public class AdminController {
    AppRepository repository;
    UserRepository userRepository;
    private List<ShoppingCart> cart = new ArrayList<>();
    List<ProductEntity> product;
    List<UserEntity> users;
    private int sumPrice;
    private int cartQuantity;
    public AdminController(AppRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @GetMapping("/admin")
    String adminPage(HttpSession session, Model model){
        session.invalidate();
        product = repository.findAll();
        cartQuantity = 0;
        sumPrice = 0;
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
//            System.out.println(logged);
        }catch(Exception e){
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
        model.addAttribute("sumPrice", 0);
        model.addAttribute("cartQuantity", 0);
        model.addAttribute("productList", product);
        return "/admin/adminPage";
    }


    @GetMapping("/admin/deleteProduct")
    String removeProductById(HttpSession session, Model model, @RequestParam(name = "id") long id){
        repository.deleteById(id);
        session.invalidate();
        product = repository.findAll();
        cartQuantity = 0;
        sumPrice = 0;
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
//            System.out.println(logged);
        }catch(Exception e){
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
        model.addAttribute("sumPrice", 0);
        model.addAttribute("cartQuantity", 0);
        model.addAttribute("productList", product);
        return "/admin/adminPage";
    }
    @GetMapping("/admin/deleteProductPage")
    String deleteProductPage(HttpSession session, Model model){
        session.invalidate();
        product = repository.findAll();
        cartQuantity = 0;
        sumPrice = 0;
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
//            System.out.println(logged);
        }catch(Exception e){
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
        model.addAttribute("sumPrice", 0);
        model.addAttribute("cartQuantity", 0);
        model.addAttribute("productList", product);
        return "/admin/adminPage";
    }

    @GetMapping("/admin/searchbyname")
    public String searchByName(HttpSession session, Model model, @RequestParam(name = "name") String name) {
        product = repository.findProductsByName(name);
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        System.out.println(cart);
        if (cart == null) {
            cart = new ArrayList<>();
        }
        cartQuantity = 0;
        sumPrice = 0;
        for (ShoppingCart sc : cart) {
            cartQuantity += sc.getQuantity();
            sumPrice += sc.getQuantity() * repository.getProductRepositoryByProductId(sc.getProduct()).get().getPrice();
        }
        model.addAttribute("sumPrice", sumPrice);
        model.addAttribute("cartQuantity", cartQuantity);
        model.addAttribute("productList", product);
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        } catch (Exception e) {
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
        return "/admin/adminPage";
    }


    @GetMapping("/admin/deleteUserPage")
    String removePage(HttpSession session, Model model){
        session.invalidate();
        users = userRepository.findAll();
        cartQuantity = 0;
        sumPrice = 0;
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        }catch(Exception e){
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
        model.addAttribute("sumPrice", 0);
        model.addAttribute("cartQuantity", 0);
        model.addAttribute("usersList", users);
        return "/admin/deleteUser";
        }

    @GetMapping("/admin/deleteUser")
    String deleteUser(HttpSession session, Model model, @RequestParam(name = "userId") long user){
        userRepository.deleteById(user);
        users = userRepository.findAll();
        session.invalidate();
        cartQuantity = 0;
        sumPrice = 0;
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        }catch(Exception e){
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
        model.addAttribute("sumPrice", 0);
        model.addAttribute("cartQuantity", 0);
        model.addAttribute("userList", users);
        return "/admin/deleteUser";
        }


    @GetMapping("/admin/searchbyusername")
    String deleteUser(HttpSession session, Model model, @RequestParam(name = "username") String username){
        System.out.println(username);
        users = userRepository.findByName(username);
        System.out.println(users.get(0).getUsername());
        session.invalidate();
        cartQuantity = 0;
        sumPrice = 0;
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        }catch(Exception e){
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
        model.addAttribute("sumPrice", 0);
        model.addAttribute("cartQuantity", 0);
        model.addAttribute("usersList", users);
        return "/admin/deleteUser";
    }
}
