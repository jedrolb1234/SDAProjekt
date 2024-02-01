package com.example.front.service;

import com.example.front.Model.ShoppingCart;
import com.example.front.repository.AppRepository;
import com.example.front.repository.ProductEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public interface ShoppingService {
    void setMVC(HttpSession session, Model model, List<ProductEntity> product, List<ShoppingCart> cart, int cartQuantity, int sumPrice, AppRepository repository,int category);
    void setMVCByName(HttpSession session, Model model, List<ProductEntity> product, List<ShoppingCart> cart, int cartQuantity, int sumPrice, AppRepository repository, String name);
    void setMVCFilteredByPrice(HttpSession session, Model model, List<ProductEntity> product, List<ShoppingCart> cart, int cartQuantity, int sumPrice, AppRepository repository, Optional<Integer> category, int price);
    void setCart(HttpSession session, Model model, List<ProductEntity> product, List<ShoppingCart> cart, int cartQuantity, int sumPrice, AppRepository repository, int category, int quantity, int id, Optional<String> name);

}
