package com.example.front.controller.shoppingController;

import com.example.front.Model.ShoppingCart;
import com.example.front.repository.AppRepository;
import com.example.front.repository.ProductEntity;
import com.example.front.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private ProductDetailService service;
    private List<ShoppingCart> cart = new ArrayList<>();
    private int sumPrice;
    private int cartQuantity;

     @GetMapping
    public String productDetail(HttpSession session, Model model,
                                @RequestParam(name = "quantity", required = false) Optional<Integer> quantity,
                                @RequestParam(name = "product") int id) {
         service.setProductDetailMVC(session, model, product, cart, quantity, id);
         String view = service.setViewToMVC(model, session, product, cart, id);
         return view;
     }


    @GetMapping("/addToCart")
    public String addToCart(HttpSession session, Model model, @RequestParam(name = "category") int category,
                            @RequestParam(name = "quantity") int quantity, @RequestParam(name = "product") int id,
                            @RequestParam(name = "token") String token) {
        service.setAddToCartMVC(session, model, product, cart, quantity, id, token);
        return "/productInfo";
    }
}
