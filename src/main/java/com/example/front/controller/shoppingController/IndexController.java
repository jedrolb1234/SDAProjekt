package com.example.front.controller.shoppingController;

import com.example.front.Model.ShoppingCart;
import com.example.front.repository.AppRepository;
import com.example.front.repository.ProductEntity;
import com.example.front.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping
public class IndexController {
    @Autowired
    private IndexService service;
    private List<ShoppingCart> cart = new ArrayList<>();
    List<ProductEntity> product;
    private int sumPrice;
    private int cartQuantity;

    @GetMapping({"/",})
    public String home(HttpSession session, Model model) {
        service.setIndexMVC(session, model, product, cart, sumPrice, cartQuantity);
        return "/index";
    }

    @GetMapping("/index")
    public String paddington(HttpSession session, Model model) {
        service.setIndexMVC(session, model, product, cart, sumPrice, cartQuantity);
        return "/index";
    }
    @GetMapping("/returnToShopping")
    public String returnToShopping(HttpSession session, Model model) {
        service.setIndexMVC(session, model, product, cart, sumPrice, cartQuantity);
        return "/index";
    }


}
