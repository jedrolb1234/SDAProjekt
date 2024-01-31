package com.example.front.controller.shoppingController;

import com.example.front.Model.ShoppingCart;
import com.example.front.repository.AppRepository;
import com.example.front.repository.ProductEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class IndexController {

    private final AppRepository repository;
    private List<ShoppingCart> cart = new ArrayList<>();
    List<ProductEntity> product;
    private int sumPrice;
    private int cartQuantity;
    public IndexController(AppRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/")
    public String home(HttpSession session, Model model) {
//        session.invalidate();
        product = repository.findAll();
        cartQuantity = 0;
        sumPrice = 0;
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
//            System.out.println(logged);
        }catch(Exception e){
            logged = false;
            System.out.println(logged);
        }
        System.out.println(logged);
        model.addAttribute("ifLogged", logged);
        model.addAttribute("sumPrice", 0);
        model.addAttribute("cartQuantity", 0);
        model.addAttribute("productList", product);
        return "/index";
    }

    @GetMapping("/user/logOut")
    public String logOut(HttpSession session, Model model) {
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
            System.out.println(logged);
        }
        model.addAttribute("ifLogged", logged);
        model.addAttribute("sumPrice", 0);
        model.addAttribute("cartQuantity", 0);
        model.addAttribute("productList", product);
        return "/index";
    }
    @GetMapping("/index")
    public String paddington(HttpSession session, Model model) {
        product = repository.findAll();
        cartQuantity = 0;
        sumPrice = 0;
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
//            System.out.println(logged);
        }catch(Exception e){
            logged = false;
            System.out.println(logged);
        }
        System.out.println(logged);
        model.addAttribute("ifLogged", logged);
        model.addAttribute("sumPrice", 0);
        model.addAttribute("cartQuantity", 0);
        model.addAttribute("productList", product);
        return "/index";
    }
    @GetMapping("/returnToShopping")
    public String returnToShopping(HttpSession session, Model model) {
        product = repository.findAll();
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        System.out.println(cart);
        if (cart == null) {
            cart = new ArrayList<>();}
        cartQuantity = 0;
        sumPrice = 0;
        for (ShoppingCart sc : cart) {
            cartQuantity += sc.getQuantity();
            sumPrice += sc.getQuantity() * repository.getProductRepositoryByProductId(sc.getProduct()).get().getPrice();
        }
        model.addAttribute("sumPrice", sumPrice);
        model.addAttribute("cartQuantity", cartQuantity);
        model.addAttribute("productList", product);
        return "/index";
    }
}
