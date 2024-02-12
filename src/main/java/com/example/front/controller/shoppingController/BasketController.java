package com.example.front.controller.shoppingController;

import com.example.front.Model.ShoppingCart;
import com.example.front.Model.ShoppingSummary;
import com.example.front.repository.AppRepository;
import com.example.front.repository.ProductEntity;
import com.example.front.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/basket")
public class BasketController {

    public List<ProductEntity> product;
    @Autowired
    BasketService service;

    @GetMapping
    public String basket(HttpSession session, Model model) {
        service.setBasketMVC(session, model);

        return "/basket";}
    @GetMapping("/emptyBasket")
    public String emptyBasket(HttpSession session, Model model) {
        service.setNullToBasketMVC(session, model);
        return "/basket";

    }



}
