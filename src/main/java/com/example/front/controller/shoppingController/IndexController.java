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
    List<ProductEntity> product;
    private AppRepository repository;
    private List<ShoppingCart> cart = new ArrayList<>();

    private int sumPrice;
    private int cartQuantity;
    public IndexController(AppRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/index")
    public String returnToShopping(Model model) {
//        model.addAttribute("productList", list);
        return "/index";
    }

    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        session.invalidate();
        product = repository.findAll();
        cartQuantity = 0;
        sumPrice = 0;
        model.addAttribute("sumPrice", 0);
        model.addAttribute("cartQuantity", 0);
        model.addAttribute("productList", product);
        return "/index";
    }
}
