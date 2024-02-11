package com.example.front.service;

import com.example.front.Model.ShoppingCart;
import com.example.front.repository.ProductEntity;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface AdaptationService {


    void setMVCByNameAndPrice(HttpSession session, Model model, java.util.List<ProductEntity> product, List<ShoppingCart> cart, int cartQuantity, int sumPrice, String name, int price);
    void setMVCByCategoryAndPrice(HttpSession session, Model model, java.util.List<ProductEntity> product, List<ShoppingCart> cart, int cartQuantity, int sumPrice, int category, int price);
    void setMVCByNameAndCategory(HttpSession session, Model model, java.util.List<ProductEntity> product, List<ShoppingCart> cart, int cartQuantity, int sumPrice, String name, int category);

    void setMVCByNameAndPriceAndCategory(HttpSession session, Model model, java.util.List<ProductEntity> product, List<ShoppingCart> cart, int cartQuantity, int sumPrice, String name, int price, int category);
}