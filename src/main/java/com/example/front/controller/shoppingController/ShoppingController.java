package com.example.front.controller.shoppingController;

import com.example.front.Model.Picture;
import com.example.front.repository.AppRepository;
import com.example.front.repository.PictureEntity;
import com.example.front.repository.ProductEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/shopping")
public class ShoppingController {

    public List<ProductEntity> product;

    public ShoppingController(AppRepository repository) {
        this.repository = repository;
    }

    private AppRepository repository;


    @GetMapping("/schoolarticles")
    public String schoolArticles(Model model) {
        product = repository.findProductsByCategory(1);
        model.addAttribute("productList", product);
//        product.get
        for(ProductEntity p: product)
            for(PictureEntity pic : p.getPicture())
              System.out.println(pic.getPath());
        return "/index";
    }

    @GetMapping("games")
    public String games(Model model) {
//        model.addAttribute("productList", list);
        return "/index";
    }

    @GetMapping("puzzles")
    public String puzzles(Model model) {
        //        model.addAttribute("productList", list);
        return "/index";
    }

    @GetMapping("/bricks")
    public String bricks(Model model) {
        //        model.addAttribute("productList", list);
        return "/index";
    }

    @GetMapping("/mascots")
    public String mascots(Model model) {
        //        model.addAttribute("productList", list);
        return "/index";
    }

    @GetMapping("/dolls")
    public String dolls(Model model) {
        //        model.addAttribute("productList", list);
        return "/index";
    }

    @GetMapping("/cars")
    public String cars(Model model) {
        //        model.addAttribute("productList", list);
        return "/index";
    }

    @GetMapping("/plasticstoys")
    public String plasticsToys(Model model) {
        //        model.addAttribute("productList", list);
        return "/index";
    }

    @GetMapping("edutoys")
    public String eduToys(Model model) {
        //        model.addAttribute("productList", list);
        return "/index";
    }

    @GetMapping("gardentoys")
    public String gardenToys(Model model) {
        //        model.addAttribute("productList", list);
        return "/index";
    }

    @GetMapping("bathtoys")
    public String bathToys(Model model) {
        //        model.addAttribute("productList", list);
        return "/index";
    }

    @GetMapping("others")
    public String others(Model model) {
        //        model.addAttribute("productList", list);
        return "/index";
    }
}
