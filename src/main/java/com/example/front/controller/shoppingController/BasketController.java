package com.example.front.controller.shoppingController;

import com.example.front.Model.ShoppingCart;
import com.example.front.Model.ShoppingSummary;
import com.example.front.repository.AppRepository;
import com.example.front.repository.ProductEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    private AppRepository repository;

    public BasketController(AppRepository repository) {
        this.repository = repository;
    }
    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_CLIENT_REGISTER', 'ROLE_ADMINISTRATOR')")
    public String basket(HttpSession session, Model model) {

        List<ShoppingCart> cart = (List<ShoppingCart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();}
        List<ShoppingSummary> shop = new ArrayList<>();

        ProductEntity p;
        int i = 1;
        int cartQuantity = 0;
        int sumPrice = 0;
        for (ShoppingCart sc : cart) {
            cartQuantity += sc.getQuantity();
            sumPrice += sc.getQuantity() * repository.getProductRepositoryByProductId(sc.getProduct()).get().getPrice();
            p = repository.getProductRepositoryByProductId(sc.getProduct()).get();
            ShoppingSummary ss;
            ss = ShoppingSummary.builder()
                    .id(p.getId())
                    .name(p.getName())
                    .price(p.getPrice())
                    .quantity(sc.getQuantity())
                    .sumPrice(sc.getQuantity()*p.getPrice())
                    .index(i)
                    .build();
            shop.add(ss);
            i++;
        }
        model.addAttribute("sumPrice", sumPrice);
        model.addAttribute("cartQuantity", cartQuantity);
        model.addAttribute("productList", shop);
    return "/basket";
    }



}
