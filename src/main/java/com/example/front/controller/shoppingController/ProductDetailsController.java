package com.example.front.controller.shoppingController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productDetail")
public class ProductDetailsController {

    @GetMapping("/{productId}")
    public String productDetail(Model model, @PathVariable long productId) {
//        model.addAttribute("productList", list);
        return "/productInfo";
    }
}
