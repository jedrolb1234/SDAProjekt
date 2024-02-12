package com.example.front.service.impl;

import com.example.front.Model.ShoppingCart;
import com.example.front.repository.AppRepository;
import com.example.front.repository.ProductEntity;
import com.example.front.service.ShoppingService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ShoppingServiceImpl implements ShoppingService {
    AppRepository repository;

    public ShoppingServiceImpl(AppRepository repository) {
        this.repository = repository;
    }

    @Override
    public void setMVC(HttpSession session, Model model, List<ProductEntity> product, List<ShoppingCart> cart,
                       int cartQuantity,int sumPrice, int category){
        product = repository.findProductsByCategory(category)
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
        String token = UUID.randomUUID().toString();
        model.addAttribute("token", token);
    }
    @Override
    public void setMVCByName(HttpSession session, Model model, List<ProductEntity> product, List<ShoppingCart> cart,
                             int cartQuantity, int sumPrice, String name){
        product = repository.findProductsByName(name)
                .stream()
                .filter(p -> !p.getPicture().isEmpty())
                .collect(Collectors.toList());;
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
        model.addAttribute("name", name);
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
        String token = UUID.randomUUID().toString();
        model.addAttribute("token", token);
    }

    public void setMVCFilteredByPrice(HttpSession session, Model model, List<ProductEntity> product, List<ShoppingCart> cart,
                                      int cartQuantity, int sumPrice, Optional<Integer> category, int price){
        if(category.isPresent()) {
            product = repository.findProductsByPriceAndCategory(price, category.get())
                    .stream()
                    .filter(p -> !p.getPicture().isEmpty())
                    .collect(Collectors.toList());
            model.addAttribute("category", category.get());
        }
        else {
            product = repository.findProductsByPrice(price)
                    .stream()
                    .filter(p -> !p.getPicture().isEmpty())
                    .collect(Collectors.toList());
        }
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
        boolean admin = (boolean) session.getAttribute("admin");
        try {
            admin = (boolean) session.getAttribute("admin");
        }catch(Exception e){
            admin = false;
        }model.addAttribute("ifLogged", logged);
        model.addAttribute("admin", admin);
        String token = UUID.randomUUID().toString();
        model.addAttribute("token", token);
    }
    @Override
    public void setCart(HttpSession session, Model model, List<ProductEntity> product, List<ShoppingCart> cart, int cartQuantity, int sumPrice,
                        Optional<Integer> category, int quantity, int id, Optional<String> name, String token){

        List<String> tokens = (List<String>)session.getAttribute("tokens");
        if(tokens == null)
            tokens = new ArrayList<>();
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();}
        ShoppingCart productWithQuantity = new ShoppingCart();
        productWithQuantity.setQuantity(quantity);
        productWithQuantity.setProduct(id);

        if(!tokens.contains(token)){
            System.out.println("tokens \n"+ token);
            tokens.add(token);
            session.setAttribute("tokens", tokens);
            token = UUID.randomUUID().toString();
            model.addAttribute("token", token);
            cart.add(productWithQuantity);
        }

        cartQuantity = 0;
        sumPrice = 0;
        if(cart != null) {
            for (ShoppingCart sc : cart) {
                cartQuantity += sc.getQuantity();
                sumPrice += sc.getQuantity() * repository.getProductByProductId(sc.getProduct()).get().getPrice();
            }
            model.addAttribute("sumPrice", sumPrice);
            model.addAttribute("cartQuantity", cartQuantity);
        }else {
            model.addAttribute("sumPrice", 0);
            model.addAttribute("cartQuantity", 0);
        }
        if(name.isEmpty()) {
            if(category.isEmpty()){
                product = repository.findAll().stream()
                    .filter(p -> !p.getPicture().isEmpty())
                    .collect(Collectors.toList());}
            else {product = repository.findProductsByCategory(category.get()).stream()
                    .filter(p -> !p.getPicture().isEmpty())
                    .collect(Collectors.toList());;}
        }else {
            if(category.isPresent()){
                product = repository.findProductsByNameAndCategory(name.get(), category.get()).stream()
                    .filter(p -> !p.getPicture().isEmpty())
                    .collect(Collectors.toList());;}
            else
            {product = repository.findProductsByName(name.get()).stream()
                        .filter(p -> !p.getPicture().isEmpty())
                        .collect(Collectors.toList());}
        }
        model.addAttribute("productList", product);
        model.addAttribute("category", category);
        session.setAttribute("cart", cart);
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        }catch(Exception e){
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
        boolean admin;
        try {
            admin = (boolean) session.getAttribute("admin");
        }catch(Exception e){
            admin = false;
        }
        model.addAttribute("admin", admin);
    }
}
