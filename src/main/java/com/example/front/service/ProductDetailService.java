package com.example.front.service;

import com.example.front.Model.ShoppingCart;
import com.example.front.repository.ProductEntity;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public interface ProductDetailService {
    void setAddToCartMVC(HttpSession session, Model model, List<ProductEntity> product, List<ShoppingCart> cart,
                         int quantity, int id, String token);

    void setProductDetailMVC(HttpSession session, Model model, List<ProductEntity> product, List<ShoppingCart> cart,
                             Optional<Integer> quantity, int id);

    String setViewToMVC(Model model,HttpSession session, List<ProductEntity> product, List<ShoppingCart> cart, int id);
}
