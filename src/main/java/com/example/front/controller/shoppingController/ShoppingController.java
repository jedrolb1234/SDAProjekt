package com.example.front.controller.shoppingController;

import com.example.front.Model.ShoppingCart;
import com.example.front.repository.AppRepository;
import com.example.front.repository.ProductEntity;
import com.example.front.service.ShoppingService;
import com.example.front.service.impl.ShoppingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequestMapping("/shopping")
public class ShoppingController {

    public List<ProductEntity> product;
    private List<ShoppingCart> cart = new ArrayList<>();
    private int sumPrice;
    private int cartQuantity;

    @Autowired
    private ShoppingService shoppingService;

    @GetMapping("/schoolarticles")
    public String schoolArticles(HttpSession session, Model model) {
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, 1);
        return "/index";
    }

    @GetMapping("games")
    public String games(HttpSession session, Model model) {
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, 2);

        return "/index";
    }

    @GetMapping("puzzle")
    public String puzzles(HttpSession session, Model model) {
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, 6);

        return "/index";
    }

    @GetMapping("/mascots")
    public String mascots(HttpSession session, Model model) {
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, 4);

        return "/index";
    }

    @GetMapping("/dolls")
    public String dolls(HttpSession session, Model model) {
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, 3);

        return "/index";
    }

    @GetMapping("/cars")
    public String cars(HttpSession session, Model model) {
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, 7);

        return "/index";
    }

    @GetMapping("/plasticstoys")
    public String plasticsToys(HttpSession session, Model model) {
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, 12);

        return "/index";
    }

    @GetMapping("edutoys")
    public String eduToys(HttpSession session, Model model) {
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, 12);

        return "/index";
    }

    @GetMapping("gardentoys")
    public String gardenToys(HttpSession session, Model model) {
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, 11);

        return "/index";
    }

    @GetMapping("bathtoys")
    public String bathToys(HttpSession session, Model model) {
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, 9);

        return "/index";
    }

    @GetMapping("others")
    public String others(HttpSession session, Model model) {
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, 5);

        return "/index";
    }
    @GetMapping("searchbyname")
    public String searchByName(HttpSession session, Model model, @RequestParam(name = "name") String name) {
        shoppingService.setMVCByName(session, model, product, cart, cartQuantity, sumPrice, name);
        return "/index";
    }

    @GetMapping("/productFiltered")
    public String productFilteredByPrice(HttpSession session, Model model, @RequestParam(name = "price") int price,
                         @RequestParam(name = "category", /* defaultValue = "0",*/ required = false) Optional<Integer> category) {
        shoppingService.setMVCFilteredByPrice(session, model, product, cart, cartQuantity, sumPrice, category, price);
        return "/index";
    }

    @GetMapping("/addToCart")
//    @PreAuthorize("hasAnyRole('ROLE_CLIENT', 'ROLE_ADMIN')")
    public String addToCart(HttpSession session, Model model, @RequestParam(name = "category") int category,
                            @RequestParam(name = "quantity") int quantity, @RequestParam(name = "product") int id,
                            @RequestParam(name = "name", required = false) Optional<String> name){
        shoppingService.setCart(session, model, product, cart, cartQuantity, sumPrice, category, quantity,id, name);
        return "/index";
    }

}
