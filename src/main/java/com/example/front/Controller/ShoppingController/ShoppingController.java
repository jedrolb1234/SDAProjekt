package com.example.front.Controller.ShoppingController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shopping")
public class ShoppingController {

    @GetMapping("/schoolarticles")
    public String schoolArticles(Model model) {
//        model.addAttribute("productList", list);
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
