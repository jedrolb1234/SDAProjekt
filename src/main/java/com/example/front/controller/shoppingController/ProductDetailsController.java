package com.example.front.controller.shoppingController;

import com.example.front.Model.ShoppingCart;
import com.example.front.repository.AppRepository;
import com.example.front.repository.ProductEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/productDetail")
public class ProductDetailsController {

    public List<ProductEntity> product;
    private AppRepository repository;
    private List<ShoppingCart> cart = new ArrayList<>();
    private int sumPrice;
    private int cartQuantity;

    public ProductDetailsController(AppRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String productDetail(HttpSession session, Model model,
                                @RequestParam(name = "quantity", required = false) Optional<Integer> quantity, @RequestParam(name = "product") int id) {
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        System.out.println(cart);
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        }catch(Exception e){
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
        if (cart == null) {
            cart = new ArrayList<>();}
        ShoppingCart productWithQuantity = new ShoppingCart();
        if(quantity.isPresent()) {
            productWithQuantity.setQuantity((int) quantity.get());
            cart.add(productWithQuantity);
        }
        else productWithQuantity.setQuantity(0);
        productWithQuantity.setProduct(id);
        cartQuantity = 0;
        sumPrice = 0;
        if(cart != null) {
            for (ShoppingCart sc : cart) {
                cartQuantity += sc.getQuantity();
                sumPrice += sc.getQuantity() * repository.getProductRepositoryByProductId(sc.getProduct()).get().getPrice();
            }
            model.addAttribute("sumPrice", sumPrice);
            model.addAttribute("cartQuantity", cartQuantity);
        }else {
            model.addAttribute("sumPrice", 0);
            model.addAttribute("cartQuantity", 0);
        }
        Optional<ProductEntity> productOptional = repository.getProductRepositoryByProductId(id);
        if(productOptional.isPresent()) {
            ProductEntity product = productOptional.get();
            model.addAttribute("product", product);
            model.addAttribute("cart", cart);
            System.out.println(product);

            return "/productInfo";
        }
        else return "/index";
        }


    @GetMapping("/addToCart")
    public String addToCart(HttpSession session, Model model, @RequestParam(name = "category") int category,
                            @RequestParam(name = "quantity") int quantity, @RequestParam(name = "product") int id){
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        System.out.println(cart);
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        }catch(Exception e){
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
        if (cart == null) {
            cart = new ArrayList<>();}
        ShoppingCart productWithQuantity = new ShoppingCart();
        productWithQuantity.setQuantity(quantity);
        productWithQuantity.setProduct(id);
        cart.add(productWithQuantity);
        cartQuantity = 0;
        sumPrice = 0;
        if(cart != null) {
            for (ShoppingCart sc : cart) {
                cartQuantity += sc.getQuantity();
                sumPrice += sc.getQuantity() * repository.getProductRepositoryByProductId(sc.getProduct()).get().getPrice();
            }
            model.addAttribute("sumPrice", sumPrice);
            model.addAttribute("cartQuantity", cartQuantity);
        }else {
            model.addAttribute("sumPrice", 0);
            model.addAttribute("cartQuantity", 0);
        }
        Optional<ProductEntity> productOptional = repository.getProductRepositoryByProductId(id);
        if(productOptional.isPresent()) {
            ProductEntity product = productOptional.get();
            model.addAttribute("product", product);
            model.addAttribute("cart", cart);
            System.out.println(product);
        }
        model.addAttribute("category", category);
        session.setAttribute("cart", cart);
        return "/productInfo";
    }

}
