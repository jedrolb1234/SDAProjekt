package com.example.front.service;

import com.example.front.Model.ShoppingCart;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface BasketService {
    void setBasketMVC(HttpSession session, Model model);
    void setNullToBasketMVC(HttpSession session, Model model);
}
