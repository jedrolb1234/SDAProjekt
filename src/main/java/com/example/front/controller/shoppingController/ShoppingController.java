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
@RequestMapping("/shopping")
public class ShoppingController {

    public List<ProductEntity> product;
    private List<ShoppingCart> cart = new ArrayList<>();

    private int sumPrice;
    private int cartQuantity;
    private AppRepository repository;

    public ShoppingController(AppRepository repository) {
        this.repository = repository;
    }




    @GetMapping("/schoolarticles")
    public String schoolArticles(HttpSession session, Model model) {
        product = repository.findProductsByCategory(1);
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        System.out.println(cart);
        if (cart == null) {
            cart = new ArrayList<>();}
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
        model.addAttribute("productList", product);
        model.addAttribute("category", 1);
        return "/index";
    }

    @GetMapping("games")
    public String games(HttpSession session, Model model) {
        product = repository.findProductsByCategory(2);
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        System.out.println(cart);
        if (cart == null) {
            cart = new ArrayList<>();}
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
        model.addAttribute("productList", product);
        model.addAttribute("category", 2);
        return "/index";
    }

    @GetMapping("puzzle")
    public String puzzles(HttpSession session, Model model) {
        product = repository.findProductsByCategory(6);
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        System.out.println(cart);
        if (cart == null) {
            cart = new ArrayList<>();}
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
        model.addAttribute("productList", product);
        model.addAttribute("category", 6);
        return "/index";
    }

    @GetMapping("/mascots")
    public String mascots(HttpSession session, Model model) {
        product = repository.findProductsByCategory(4);
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        System.out.println(cart);
        if (cart == null) {
            cart = new ArrayList<>();}
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
        model.addAttribute("productList", product);
        model.addAttribute("category", 4);
        return "/index";
    }

    @GetMapping("/dolls")
    public String dolls(HttpSession session, Model model) {
        product = repository.findProductsByCategory(3);
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        System.out.println(cart);
        if (cart == null) {
            cart = new ArrayList<>();}
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
        model.addAttribute("productList", product);
        model.addAttribute("category", 3);
        return "/index";
    }

    @GetMapping("/cars")
    public String cars(HttpSession session, Model model) {
        product = repository.findProductsByCategory(7);
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        System.out.println(cart);
        if (cart == null) {
            cart = new ArrayList<>();}
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
        model.addAttribute("productList", product);
        model.addAttribute("category", 7);
        return "/index";
    }

    @GetMapping("/plasticstoys")
    public String plasticsToys(HttpSession session, Model model) {
        product = repository.findProductsByCategory(12);
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        System.out.println(cart);
        if (cart == null) {
            cart = new ArrayList<>();}
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
        model.addAttribute("productList", product);
        model.addAttribute("category", 12);
        return "/index";
    }

    @GetMapping("edutoys")
    public String eduToys(HttpSession session, Model model) {
        product = repository.findProductsByCategory(10);
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        System.out.println(cart);
        if (cart == null) {
            cart = new ArrayList<>();}
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
        model.addAttribute("productList", product);
        model.addAttribute("category", 12);
        return "/index";
    }

    @GetMapping("gardentoys")
    public String gardenToys(HttpSession session, Model model) {
        product = repository.findProductsByCategory(11);
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        System.out.println(cart);
        if (cart == null) {
            cart = new ArrayList<>();}
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
        model.addAttribute("productList", product);
        model.addAttribute("category", 11);
        return "/index";
    }

    @GetMapping("bathtoys")
    public String bathToys(HttpSession session, Model model) {
        product = repository.findProductsByCategory(9);
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        System.out.println(cart);
        if (cart == null) {
            cart = new ArrayList<>();}
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
        model.addAttribute("productList", product);
        model.addAttribute("category", 9);
        return "/index";
    }

    @GetMapping("others")
    public String others(HttpSession session, Model model) {
        product = repository.findProductsByCategory(5);
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        System.out.println(cart);
        if (cart == null) {
            cart = new ArrayList<>();}
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
        model.addAttribute("productList", product);
        model.addAttribute("category", 5);
        return "/index";
    }
    @GetMapping("searchbyname")
    public String searchByName(HttpSession session, Model model, @RequestParam(name = "name") String name) {
        product = repository.findProductsByName(name);
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        System.out.println(cart);
        if (cart == null) {
            cart = new ArrayList<>();}
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
        model.addAttribute("productList", product);
        return "/index";
    }

    @GetMapping("/productFiltered")
    public String productFilteredByPrice(HttpSession session, Model model, @RequestParam(name = "price") int price, @RequestParam(name = "category") int category) {
        product = repository.findProductsByPriceAndCategory(price, category);
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        System.out.println(cart);
        if (cart == null) {
            cart = new ArrayList<>();}
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
        model.addAttribute("productList", product);
        model.addAttribute("category", category);
        return "/index";
    }

    @GetMapping("/addToCart")
    public String addToCart(HttpSession session, Model model, @RequestParam(name = "category") int category,
                            @RequestParam(name = "quantity") int quantity, @RequestParam(name = "product") int id,
                            @RequestParam(name = "name", required = false) Optional<String> name){
        cart = (List<ShoppingCart>) session.getAttribute("cart");
        System.out.println(cart);
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
        if(name.isEmpty())
            product = repository.findProductsByCategory(category);
        else
            product = repository.findProductsByName(name.get());
        model.addAttribute("productList", product);
        model.addAttribute("category", category);
        session.setAttribute("cart", cart);

        return "/index";
    }

}
