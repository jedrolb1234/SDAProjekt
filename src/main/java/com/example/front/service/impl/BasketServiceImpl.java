package com.example.front.service.impl;

import com.example.front.Model.ShoppingCart;
import com.example.front.Model.ShoppingSummary;
import com.example.front.repository.AppRepository;
import com.example.front.repository.ProductEntity;
import com.example.front.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
@Service
public class BasketServiceImpl implements BasketService {

    AppRepository repository;
    private List<ShoppingCart> cart = new ArrayList<>();

    BasketServiceImpl(AppRepository repository) {
        this.repository = repository;
    }
    public void setBasketMVC(HttpSession session, Model model){
        List<ShoppingCart> cart = (List<ShoppingCart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }
        List<ShoppingSummary> shop = new ArrayList<>();
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        }catch(Exception e){
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
        ProductEntity p;
        int i = 1;
        int cartQuantity = 0;
        int sumPrice = 0;
        for (ShoppingCart sc : cart) {
            cartQuantity += sc.getQuantity();
            sumPrice += sc.getQuantity() * repository.getProductByProductId(sc.getProduct()).get().getPrice();
            p = repository.getProductByProductId(sc.getProduct()).get();
            ShoppingSummary ss;
            ss = ShoppingSummary.builder()
                    .id(p.getId())
                    .name(p.getName())
                    .price(p.getPrice())
                    .quantity(sc.getQuantity())
                    .sumPrice(sc.getQuantity() * p.getPrice())
                    .index(i)
                    .build();
            shop.add(ss);
            i++;
        }
        model.addAttribute("sumPrice", sumPrice);
        model.addAttribute("cartQuantity", cartQuantity);
        model.addAttribute("productList", shop);
    }

    public void setNullToBasketMVC(HttpSession session, Model model){

        List<ShoppingSummary> shop = new ArrayList<>();
        session.setAttribute("cart", cart);
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        }catch(Exception e){
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
        ProductEntity p;
        int i = 1;
        int cartQuantity = 0;
        int sumPrice = 0;
        model.addAttribute("sumPrice", sumPrice);
        model.addAttribute("cartQuantity", cartQuantity);
    }

}
