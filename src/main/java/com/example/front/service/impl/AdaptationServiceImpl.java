package com.example.front.service.impl;

import com.example.front.Model.ShoppingCart;
import com.example.front.repository.AppRepository;
import com.example.front.repository.ProductEntity;
import com.example.front.service.AdaptationService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


//skasować name and category

@Service
public class AdaptationServiceImpl implements AdaptationService {
    AppRepository repository;
    public AdaptationServiceImpl(AppRepository repository) {
        this.repository = repository;
    }
//ok
    public void setMVCByNameAndPrice(HttpSession session, Model model, java.util.List<ProductEntity> product, List<ShoppingCart> cart, int cartQuantity, int sumPrice, String name, int price){
        product = repository.findProductsByNameAndPrice(name, price)
                .stream()
                .filter(p -> !p.getPicture().isEmpty())
                .collect(Collectors.toList());
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();}
        cartQuantity = 0;
        sumPrice = 0;
        for (ShoppingCart sc : cart) {
            cartQuantity += sc.getQuantity();
            sumPrice += sc.getQuantity() * repository.getProductByProductId(sc.getProduct()).get().getPrice();
        }
        model.addAttribute("sumPrice", sumPrice);
        model.addAttribute("cartQuantity", cartQuantity);
        model.addAttribute("productList", product);
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        }catch(Exception e){
            logged = false;
        }
        boolean admin;
        try {
            admin = (boolean) session.getAttribute("admin");
        }catch(Exception e){
            admin = false;
        }
        model.addAttribute("admin", admin);
        model.addAttribute("ifLogged", logged);
    }
    //ok
public void setMVCByCategoryAndPrice(HttpSession session, Model model, java.util.List<ProductEntity> product, List<ShoppingCart> cart, int cartQuantity, int sumPrice, int category, int price){
        product = repository.findProductsByCategoryAndPrice(category, price)
                .stream()
                .filter(p -> !p.getPicture().isEmpty())
                .collect(Collectors.toList());
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();}
        cartQuantity = 0;
        sumPrice = 0;
        for (ShoppingCart sc : cart) {
            cartQuantity += sc.getQuantity();
            sumPrice += sc.getQuantity() * repository.getProductByProductId(sc.getProduct()).get().getPrice();
        }
        model.addAttribute("sumPrice", sumPrice);
        model.addAttribute("cartQuantity", cartQuantity);
        model.addAttribute("productList", product);
        model.addAttribute("category", category);
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        }catch(Exception e){
            logged = false;
        }
        boolean admin;
        try {
             admin = (boolean) session.getAttribute("admin");
        }catch(Exception e){
            admin = false;
        }
        model.addAttribute("admin", admin);
        model.addAttribute("ifLogged", logged);
    }
public void setMVCByNameAndCategory(HttpSession session, Model model, java.util.List<ProductEntity> product, List<ShoppingCart> cart, int cartQuantity, int sumPrice, String name, int category){
        product = repository.findProductsByNameAndCategory(name, category)
                .stream()
                .filter(p -> !p.getPicture().isEmpty())
                .collect(Collectors.toList());
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();}
        cartQuantity = 0;
        sumPrice = 0;
        for (ShoppingCart sc : cart) {
            cartQuantity += sc.getQuantity();
            sumPrice += sc.getQuantity() * repository.getProductByProductId(sc.getProduct()).get().getPrice();
        }
        model.addAttribute("sumPrice", sumPrice);
        model.addAttribute("cartQuantity", cartQuantity);
        model.addAttribute("productList", product);
        model.addAttribute("category", category);
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        }catch(Exception e){
            logged = false;
        }
        boolean admin;
        try {
            admin = (boolean) session.getAttribute("admin");
        }catch(Exception e){
            admin = false;
        }
        model.addAttribute("admin", admin);
        model.addAttribute("ifLogged", logged);
    }
public void setMVCByNameAndPriceAndCategory(HttpSession session, Model model, java.util.List<ProductEntity> product,
                                            List<ShoppingCart> cart, int cartQuantity, int sumPrice, String name, int price,
                                            int category){
        product = repository.findProductsByNameAndPriceAndCategory(name, price, category)
                .stream()
                .filter(p -> !p.getPicture().isEmpty())
                .collect(Collectors.toList());
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();}
        cartQuantity = 0;
        sumPrice = 0;
        for (ShoppingCart sc : cart) {
            cartQuantity += sc.getQuantity();
            sumPrice += sc.getQuantity() * repository.getProductByProductId(sc.getProduct()).get().getPrice();
        }
        model.addAttribute("sumPrice", sumPrice);
        model.addAttribute("cartQuantity", cartQuantity);
        model.addAttribute("productList", product);
        model.addAttribute("category", category);
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        }catch(Exception e){
            logged = false;
        }
        boolean admin;
        try {
            admin = (boolean) session.getAttribute("admin");
        }catch(Exception e){
            admin = false;
        }
        model.addAttribute("admin", admin);
        model.addAttribute("ifLogged", logged);
        model.addAttribute("name", name);
    }

}
