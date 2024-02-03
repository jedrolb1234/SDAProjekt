package com.example.front.service.impl;

import com.example.front.Model.ShoppingCart;
import com.example.front.repository.AppRepository;
import com.example.front.repository.PictureEntity;
import com.example.front.repository.ProductEntity;
import com.example.front.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IndexServiceImpl implements IndexService {

    AppRepository repository;
    private List<ShoppingCart> cart = new ArrayList<>();
    List<ProductEntity> product;
    private int sumPrice;
    private int cartQuantity;

    public IndexServiceImpl(AppRepository repository) {
        this.repository = repository;
    }

    public void setIndexMVC(HttpSession session, Model model, List<ProductEntity> product, List<ShoppingCart> cart, int sumPrice, int cartQuantity){
        product = repository.findAll()
                .stream()
                .filter(p -> !p.getPicture().isEmpty())
                .collect(Collectors.toList());
        cartQuantity = 0;
        sumPrice = 0;
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        }catch(Exception e){
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
        model.addAttribute("sumPrice", 0);
        model.addAttribute("cartQuantity", 0);
        model.addAttribute("productList", product);
    };
}
