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
    private final AppRepository repository;

    @Autowired
    private ShoppingService shoppingService;
    public ShoppingController(AppRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/schoolarticles")
    public String schoolArticles(HttpSession session, Model model) {
//        product = repository.findProductsByCategory(1);
//        cart = (List<ShoppingCart>) session.getAttribute("cart");
//        System.out.println(cart);
//        if (cart == null) {
//            cart = new ArrayList<>();}
//        cartQuantity = 0;
//        sumPrice = 0;
//        for (ShoppingCart sc : cart) {
//            cartQuantity += sc.getQuantity();
//            sumPrice += sc.getQuantity() * repository.getProductRepositoryByProductId(sc.getProduct()).get().getPrice();
//        }
//        model.addAttribute("sumPrice", sumPrice);
//        model.addAttribute("cartQuantity", cartQuantity);
//        model.addAttribute("productList", product);
//        model.addAttribute("category", 1);
//        boolean logged;
//        try {
//            logged = (boolean) session.getAttribute("logged");
//        }catch(Exception e){
//            logged = false;
//        }
//        model.addAttribute("ifLogged", logged);
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, repository, 1);
        return "/index";
    }

    @GetMapping("games")
    public String games(HttpSession session, Model model) {
//        product = repository.findProductsByCategory(2);
//        cart = (List<ShoppingCart>) session.getAttribute("cart");
//        System.out.println(cart);
//        if (cart == null) {
//            cart = new ArrayList<>();}
//        cartQuantity = 0;
//        sumPrice = 0;
//        for (ShoppingCart sc : cart) {
//            cartQuantity += sc.getQuantity();
//            sumPrice += sc.getQuantity() * repository.getProductRepositoryByProductId(sc.getProduct()).get().getPrice();
//        }
//        model.addAttribute("sumPrice", sumPrice);
//        model.addAttribute("cartQuantity", cartQuantity);
//        model.addAttribute("productList", product);
//        model.addAttribute("category", 2);
//        boolean logged;
//        try {
//            logged = (boolean) session.getAttribute("logged");
//        }catch(Exception e){
//            logged = false;
//        }
//        model.addAttribute("ifLogged", logged);
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, repository, 2);

        return "/index";
    }

    @GetMapping("puzzle")
    public String puzzles(HttpSession session, Model model) {
//        product = repository.findProductsByCategory(6);
//        cart = (List<ShoppingCart>) session.getAttribute("cart");
//        System.out.println(cart);
//        if (cart == null) {
//            cart = new ArrayList<>();}
//        cartQuantity = 0;
//        sumPrice = 0;
//        for (ShoppingCart sc : cart) {
//            cartQuantity += sc.getQuantity();
//            sumPrice += sc.getQuantity() * repository.getProductRepositoryByProductId(sc.getProduct()).get().getPrice();
//        }
//        model.addAttribute("sumPrice", sumPrice);
//        model.addAttribute("cartQuantity", cartQuantity);
//        model.addAttribute("productList", product);
//        model.addAttribute("category", 6);
//        boolean logged;
//        try {
//            logged = (boolean) session.getAttribute("logged");
//        }catch(Exception e){
//            logged = false;
//        }
//        model.addAttribute("ifLogged", logged);
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, repository, 6);

        return "/index";
    }

    @GetMapping("/mascots")
    public String mascots(HttpSession session, Model model) {
//        product = repository.findProductsByCategory(4);
//        cart = (List<ShoppingCart>) session.getAttribute("cart");
//        System.out.println(cart);
//        if (cart == null) {
//            cart = new ArrayList<>();}
//        cartQuantity = 0;
//        sumPrice = 0;
//        for (ShoppingCart sc : cart) {
//            cartQuantity += sc.getQuantity();
//            sumPrice += sc.getQuantity() * repository.getProductRepositoryByProductId(sc.getProduct()).get().getPrice();
//        }
//        model.addAttribute("sumPrice", sumPrice);
//        model.addAttribute("cartQuantity", cartQuantity);
//        model.addAttribute("productList", product);
//        model.addAttribute("category", 4);
//        boolean logged;
//        try {
//            logged = (boolean) session.getAttribute("logged");
//        }catch(Exception e){
//            logged = false;
//        }
//        model.addAttribute("ifLogged", logged);
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, repository, 4);

        return "/index";
    }

    @GetMapping("/dolls")
    public String dolls(HttpSession session, Model model) {
//        product = repository.findProductsByCategory(3);
//        cart = (List<ShoppingCart>) session.getAttribute("cart");
//        System.out.println(cart);
//        if (cart == null) {
//            cart = new ArrayList<>();}
//        cartQuantity = 0;
//        sumPrice = 0;
//        for (ShoppingCart sc : cart) {
//            cartQuantity += sc.getQuantity();
//            sumPrice += sc.getQuantity() * repository.getProductRepositoryByProductId(sc.getProduct()).get().getPrice();
//        }
//        model.addAttribute("sumPrice", sumPrice);
//        model.addAttribute("cartQuantity", cartQuantity);
//        model.addAttribute("productList", product);
//        model.addAttribute("category", 3);
//        boolean logged;
//        try {
//            logged = (boolean) session.getAttribute("logged");
//        }catch(Exception e){
//            logged = false;
//        }
//        model.addAttribute("ifLogged", logged);
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, repository, 3);

        return "/index";
    }

    @GetMapping("/cars")
    public String cars(HttpSession session, Model model) {
//        product = repository.findProductsByCategory(7);
//        cart = (List<ShoppingCart>) session.getAttribute("cart");
//        System.out.println(cart);
//        if (cart == null) {
//            cart = new ArrayList<>();}
//        cartQuantity = 0;
//        sumPrice = 0;
//        for (ShoppingCart sc : cart) {
//            cartQuantity += sc.getQuantity();
//            sumPrice += sc.getQuantity() * repository.getProductRepositoryByProductId(sc.getProduct()).get().getPrice();
//        }
//        model.addAttribute("sumPrice", sumPrice);
//        model.addAttribute("cartQuantity", cartQuantity);
//        model.addAttribute("productList", product);
//        model.addAttribute("category", 7);
//        boolean logged;
//        try {
//            logged = (boolean) session.getAttribute("logged");
//        }catch(Exception e){
//            logged = false;
//        }
//        model.addAttribute("ifLogged", logged);
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, repository, 7);

        return "/index";
    }

    @GetMapping("/plasticstoys")
    public String plasticsToys(HttpSession session, Model model) {
//        product = repository.findProductsByCategory(12);
//        cart = (List<ShoppingCart>) session.getAttribute("cart");
//        System.out.println(cart);
//        if (cart == null) {
//            cart = new ArrayList<>();}
//        cartQuantity = 0;
//        sumPrice = 0;
//        for (ShoppingCart sc : cart) {
//            cartQuantity += sc.getQuantity();
//            sumPrice += sc.getQuantity() * repository.getProductRepositoryByProductId(sc.getProduct()).get().getPrice();
//        }
//        model.addAttribute("sumPrice", sumPrice);
//        model.addAttribute("cartQuantity", cartQuantity);
//        model.addAttribute("productList", product);
//        model.addAttribute("category", 12);
//        boolean logged;
//        try {
//            logged = (boolean) session.getAttribute("logged");
//        }catch(Exception e){
//            logged = false;
//        }
//        model.addAttribute("ifLogged", logged);
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, repository, 12);

        return "/index";
    }

    @GetMapping("edutoys")
    public String eduToys(HttpSession session, Model model) {
//        product = repository.findProductsByCategory(10);
//        cart = (List<ShoppingCart>) session.getAttribute("cart");
//        System.out.println(cart);
//        if (cart == null) {
//            cart = new ArrayList<>();}
//        cartQuantity = 0;
//        sumPrice = 0;
//        for (ShoppingCart sc : cart) {
//            cartQuantity += sc.getQuantity();
//            sumPrice += sc.getQuantity() * repository.getProductRepositoryByProductId(sc.getProduct()).get().getPrice();
//        }
//        model.addAttribute("sumPrice", sumPrice);
//        model.addAttribute("cartQuantity", cartQuantity);
//        model.addAttribute("productList", product);
//        model.addAttribute("category", 12);
//        boolean logged;
//        try {
//            logged = (boolean) session.getAttribute("logged");
//        }catch(Exception e){
//            logged = false;
//        }
//        model.addAttribute("ifLogged", logged);
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, repository, 12);

        return "/index";
    }

    @GetMapping("gardentoys")
    public String gardenToys(HttpSession session, Model model) {
//        product = repository.findProductsByCategory(11);
//        cart = (List<ShoppingCart>) session.getAttribute("cart");
//        System.out.println(cart);
//        if (cart == null) {
//            cart = new ArrayList<>();}
//        cartQuantity = 0;
//        sumPrice = 0;
//        for (ShoppingCart sc : cart) {
//            cartQuantity += sc.getQuantity();
//            sumPrice += sc.getQuantity() * repository.getProductRepositoryByProductId(sc.getProduct()).get().getPrice();
//        }
//        model.addAttribute("sumPrice", sumPrice);
//        model.addAttribute("cartQuantity", cartQuantity);
//        model.addAttribute("productList", product);
//        model.addAttribute("category", 11);
//        boolean logged;
//        try {
//            logged = (boolean) session.getAttribute("logged");
//        }catch(Exception e){
//            logged = false;
//        }
//        model.addAttribute("ifLogged", logged);
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, repository, 11);

        return "/index";
    }

    @GetMapping("bathtoys")
    public String bathToys(HttpSession session, Model model) {
//        product = repository.findProductsByCategory(9);
//        cart = (List<ShoppingCart>) session.getAttribute("cart");
//        System.out.println(cart);
//        if (cart == null) {
//            cart = new ArrayList<>();}
//        cartQuantity = 0;
//        sumPrice = 0;
//        for (ShoppingCart sc : cart) {
//            cartQuantity += sc.getQuantity();
//            sumPrice += sc.getQuantity() * repository.getProductRepositoryByProductId(sc.getProduct()).get().getPrice();
//        }
//        model.addAttribute("sumPrice", sumPrice);
//        model.addAttribute("cartQuantity", cartQuantity);
//        model.addAttribute("productList", product);
//        model.addAttribute("category", 9);
//        boolean logged;
//        try {
//            logged = (boolean) session.getAttribute("logged");
//        }catch(Exception e){
//            logged = false;
//        }
//        model.addAttribute("ifLogged", logged);
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, repository, 9);

        return "/index";
    }

    @GetMapping("others")
    public String others(HttpSession session, Model model) {
//        product = repository.findProductsByCategory(5);
//        cart = (List<ShoppingCart>) session.getAttribute("cart");
//        System.out.println(cart);
//        if (cart == null) {
//            cart = new ArrayList<>();}
//        cartQuantity = 0;
//        sumPrice = 0;
//        for (ShoppingCart sc : cart) {
//            cartQuantity += sc.getQuantity();
//            sumPrice += sc.getQuantity() * repository.getProductRepositoryByProductId(sc.getProduct()).get().getPrice();
//        }
//        model.addAttribute("sumPrice", sumPrice);
//        model.addAttribute("cartQuantity", cartQuantity);
//        model.addAttribute("productList", product);
//        model.addAttribute("category", 5);        boolean logged;
//        try {
//            logged = (boolean) session.getAttribute("logged");
//        }catch(Exception e){
//            logged = false;
//        }
//        model.addAttribute("ifLogged", logged);
        shoppingService.setMVC( session, model, product, cart, cartQuantity, sumPrice, repository, 5);

        return "/index";
    }
    @GetMapping("searchbyname")
    public String searchByName(HttpSession session, Model model, @RequestParam(name = "name") String name) {
//        product = repository.findProductsByName(name);
//        cart = (List<ShoppingCart>) session.getAttribute("cart");
//        if (cart == null) {
//            cart = new ArrayList<>();}
//        cartQuantity = 0;
//        sumPrice = 0;
//        for (ShoppingCart sc : cart) {
//            cartQuantity += sc.getQuantity();
//            sumPrice += sc.getQuantity() * repository.getProductRepositoryByProductId(sc.getProduct()).get().getPrice();
//        }
//        model.addAttribute("sumPrice", sumPrice);
//        model.addAttribute("cartQuantity", cartQuantity);
//        model.addAttribute("productList", product);
//        boolean logged;
//        try {
//            logged = (boolean) session.getAttribute("logged");
//        }catch(Exception e){
//            logged = false;
//        }
//        model.addAttribute("ifLogged", logged);

        shoppingService.setMVCByName(session, model, product, cart, cartQuantity, sumPrice, repository, name);
        return "/index";
    }

    @GetMapping("/productFiltered")
    public String productFilteredByPrice(HttpSession session, Model model, @RequestParam(name = "price") int price, @RequestParam(name = "category", required = false) Optional<Integer> category) {
//        if(category.isPresent())
//            product = repository.findProductsByPriceAndCategory(price, category.get());
//        else product = repository.findProductsByPrice(price);
//        cart = (List<ShoppingCart>) session.getAttribute("cart");
//        if (cart == null) {
//            cart = new ArrayList<>();}
//        cartQuantity = 0;
//        sumPrice = 0;
//        for (ShoppingCart sc : cart) {
//            cartQuantity += sc.getQuantity();
//            sumPrice += sc.getQuantity() * repository.getProductRepositoryByProductId(sc.getProduct()).get().getPrice();
//        }
//        model.addAttribute("sumPrice", sumPrice);
//        model.addAttribute("cartQuantity", cartQuantity);
//        model.addAttribute("productList", product);
//        if(category.isPresent())
//            model.addAttribute( "category", category);
//        boolean logged;
//        try {
//            logged = (boolean) session.getAttribute("logged");
//        }catch(Exception e){
//            logged = false;
//        }
//        model.addAttribute("ifLogged", logged);

        shoppingService.setMVCFilteredByPrice(session, model, product, cart, cartQuantity, sumPrice, repository, category, price);
        return "/index";
    }

    @GetMapping("/addToCart")
//    @PreAuthorize("hasAnyRole('ROLE_CLIENT', 'ROLE_ADMIN')")
    public String addToCart(HttpSession session, Model model, @RequestParam(name = "category") int category,
                            @RequestParam(name = "quantity") int quantity, @RequestParam(name = "product") int id,
                            @RequestParam(name = "name", required = false) Optional<String> name){
//        cart = (List<ShoppingCart>) session.getAttribute("cart");
//        if (cart == null) {
//            cart = new ArrayList<>();}
//        ShoppingCart productWithQuantity = new ShoppingCart();
//        productWithQuantity.setQuantity(quantity);
//        productWithQuantity.setProduct(id);
//        cart.add(productWithQuantity);
//        cartQuantity = 0;
//        sumPrice = 0;
//
//        if(cart != null) {
//            for (ShoppingCart sc : cart) {
//                cartQuantity += sc.getQuantity();
//                sumPrice += sc.getQuantity() * repository.getProductRepositoryByProductId(sc.getProduct()).get().getPrice();
//                System.out.println(sc);
//
//            }
//            model.addAttribute("sumPrice", sumPrice);
//            model.addAttribute("cartQuantity", cartQuantity);
//        }else {
//            model.addAttribute("sumPrice", 0);
//            model.addAttribute("cartQuantity", 0);
//        }
//        if(name.isEmpty())
//            product = repository.findProductsByCategory(category);
//        else
//            product = repository.findProductsByName(name.get());
//        model.addAttribute("productList", product);
//        model.addAttribute("category", category);
//        session.setAttribute("cart", cart);
//        boolean logged;
//        try {
//            logged = (boolean) session.getAttribute("logged");
//        }catch(Exception e){
//            logged = false;
//        }
//        model.addAttribute("ifLogged", logged);
        shoppingService.setCart(session, model, product, cart, cartQuantity, sumPrice, repository, category, quantity,id, name);
        return "/index";
    }

}
