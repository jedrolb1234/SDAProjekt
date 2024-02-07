package com.example.front.service;

import com.example.front.Model.ShoppingCart;
import com.example.front.repository.PictureEntity;
import com.example.front.repository.ProductEntity;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IndexService {

    void setIndexMVC(HttpSession session, Model model, List<ProductEntity> product, List<ShoppingCart> cart, int sumPrice, int cartQuantity);
    void setLogOutPage(HttpSession session, Model model, List<ProductEntity> product, List<ShoppingCart> cart, int sumPrice, int cartQuantity);

}
