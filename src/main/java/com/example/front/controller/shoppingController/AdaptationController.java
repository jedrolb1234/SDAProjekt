package com.example.front.controller.shoppingController;

import com.example.front.Model.ShoppingCart;
import com.example.front.repository.ProductEntity;
import com.example.front.service.AdaptationService;
import com.example.front.service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class AdaptationController {

    public List<ProductEntity> product;
    private List<ShoppingCart> cart = new ArrayList<>();
    private int sumPrice;
    private int cartQuantity;
    @Autowired
    ShoppingService shoppingService;
    @Autowired
    AdaptationService adaptationService;
    //ok
    @GetMapping("/adaptation/searchbyname")
    public String searchByName(HttpSession session, Model model, @RequestParam(name = "name") String name) {
        shoppingService.setMVCByName(session, model, product, cart, cartQuantity, sumPrice, name);
        return "/indexAdaptation/searchByName";
    }
    //ok
    @GetMapping("/adaptation/searchbynameandcategory")
    public String searchByNameAndCategory(HttpSession session, Model model, @RequestParam(name = "name") String name,
                                          @RequestParam(name ="category") int category) {
        adaptationService.setMVCByNameAndCategory(session, model, product, cart, cartQuantity, sumPrice, name, category);
        return "/indexAdaptation/categoryIndex";
    }
    //ok
    @GetMapping("/adaptation/searchbynameandprice")
    public String searchByNameAndPrice(HttpSession session, Model model, @RequestParam(name = "name") String name,
                                       @RequestParam(name = "price") int price) {
        adaptationService.setMVCByNameAndPrice(session, model, product, cart, cartQuantity, sumPrice, name, price);
        return "/indexAdaptation/searchByName";
    }
//ok
    @GetMapping("/adaptation/searchbycategoryandprice")
    public String searchByCategoryAndPrice(HttpSession session, Model model, @RequestParam(name = "category") int category,
                                       @RequestParam(name = "price") int price) {
        adaptationService.setMVCByCategoryAndPrice(session, model, product, cart, cartQuantity, sumPrice, category, price);
        return "/indexAdaptation/categoryAndPrice";
    }
    @GetMapping("/adaptation/searchby3properties")
    public String searchByNameAndPrice(HttpSession session, Model model, @RequestParam(name = "name") String name,
                                       @RequestParam(name = "price") int price, @RequestParam(name ="category") int category){
        adaptationService.setMVCByNameAndPriceAndCategory(session, model, product, cart, cartQuantity, sumPrice, name, price, category);
        return "/indexAdaptation/searchByName";
    }



}
