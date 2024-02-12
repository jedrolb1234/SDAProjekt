package com.example.front.service.impl;

import com.example.front.Model.ShoppingCart;
import com.example.front.repository.AppRepository;
import com.example.front.repository.ProductEntity;
import com.example.front.service.ProductDetailService;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    public List<ProductEntity> product;
    private AppRepository repository;
    private List<ShoppingCart> cart = new ArrayList<>();
    private int sumPrice;
    private int cartQuantity;

    public ProductDetailServiceImpl(AppRepository repository) {
        this.repository = repository;
    }

     public void setProductDetailMVC(HttpSession session, Model model, List<ProductEntity> product, List<ShoppingCart> cart,
                                     Optional<Integer> quantity, int id) {
         cart = (List<ShoppingCart>) session.getAttribute("cart");
         boolean logged;
         try {
             logged = (boolean) session.getAttribute("logged");
         }catch(Exception e){
             logged = false;
         }
         model.addAttribute("ifLogged", logged);

         if (cart == null) {
             cart = new ArrayList<>();
         }
         ShoppingCart productWithQuantity = new ShoppingCart();
         if (quantity.isPresent()) {
             productWithQuantity.setQuantity((int) quantity.get());
             cart.add(productWithQuantity);
         } else productWithQuantity.setQuantity(0);
         productWithQuantity.setProduct(id);
         cartQuantity = 0;
         sumPrice = 0;
         if (cart != null) {
             for (ShoppingCart sc : cart) {
                 cartQuantity += sc.getQuantity();
                 sumPrice += sc.getQuantity() * repository.getProductByProductId(sc.getProduct()).get().getPrice();
             }
             model.addAttribute("sumPrice", sumPrice);
             model.addAttribute("cartQuantity", cartQuantity);
         } else {
             model.addAttribute("sumPrice", 0);
             model.addAttribute("cartQuantity", 0);
         }
         boolean admin;
         try {
             admin = (boolean) session.getAttribute("admin");
         }catch(Exception e){
             admin = false;
         }
         model.addAttribute("admin", admin);
     }




    public void setAddToCartMVC(HttpSession session, Model model, List<ProductEntity> product, List<ShoppingCart> cart,
                                     int quantity, int id, String token){
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
        Optional<ProductEntity> productOptional = repository.getProductByProductId(id);
        if(productOptional.isPresent()) {
            ProductEntity productO = productOptional.get();
            model.addAttribute("product", productO);
            model.addAttribute("cart", cart);
        }
        session.setAttribute("cart", cart);
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
        model.addAttribute("ifLogged", logged);
        model.addAttribute("admin", admin);
    }

    public String setViewToMVC(Model model, HttpSession session, List<ProductEntity> product, List<ShoppingCart> cart, int id){
        Optional<ProductEntity> productOptional = repository.getProductByProductId(id);
        boolean admin;
        try {
            admin = (boolean) session.getAttribute("admin");
        }catch(Exception e){
            admin = false;
        }
        model.addAttribute("admin", admin);
        if(productOptional.isPresent()) {
            ProductEntity productO = productOptional.get();
            model.addAttribute("product", productO);
            model.addAttribute("cart", cart);

            return "/productInfo";
        }
        else return "/index";
    }
}
