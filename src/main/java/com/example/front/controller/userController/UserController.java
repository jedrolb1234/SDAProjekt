package com.example.front.controller.userController;

import com.example.front.Auth.ApplicationUser;
import com.example.front.Model.ShoppingCart;
import com.example.front.repository.AppRepository;
import com.example.front.repository.ProductEntity;
import com.example.front.repository.UserRepository;
import com.example.front.service.UserService;
import com.example.front.user.UserEntity;
import com.example.front.user.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Controller
public class UserController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    List<ProductEntity> product;
    private AppRepository repository;
    private int sumPrice;
    private int cartQuantity;
    @Autowired
    UserService userService;

    @Autowired
    public UserController(UserRepository userRepository, AppRepository repository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping("/user/logIn")
    String logIn(){
        return "/logInPage";
    }
    @GetMapping("/user/registerPage")
    String registerPage(){
        return "/account/register";
    }

//    @GetMapping("/user/info")
//    public String userInfo(Model  model){
//
//        //kopiować
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if(authentication != null && authentication.getPrincipal() instanceof ApplicationUser){
//            ApplicationUser user = (ApplicationUser) authentication.getPrincipal();
//            model.addAttribute("username", user.getUsername());
//            model.addAttribute("id", user.getId());
//            model.addAttribute("auth", user.getAuthorities()
//                    .stream()
//                            .map(GrantedAuthority::getAuthority)
//                            .collect(Collectors.toList()));
//
//        }
//        return "/userInfo";
//    }

    @PostMapping("/user/logout")
    String logoutPage(HttpSession session, Model model){
        userService.setIndexMVC(session, model);
        return "/index";
    }
    @GetMapping("/account/settings")
    String settingsPage(){
        return "/account/settings";
    }
    @GetMapping("/account/saveUser")
    String saveUser(Model model, HttpSession session,@RequestParam("username") String username, @RequestParam("password") String password,
                    @RequestParam("rpassword") String rpassword, @RequestParam("email") String email,
                    @RequestParam("phone") String phone){
        String view = userService.updateUser(username, password, rpassword, email, phone,
                                    model, session);
        return view;
    }

    @GetMapping("/account/register")
    public String registerUser(@RequestParam("username") String username, @RequestParam("password") String password,
                            @RequestParam("rpassword") String rpassword, @RequestParam("email") String email,
                            @RequestParam("phone") String phone,
                            @RequestParam(value = "administratorCheckbox", required = false) Optional<Boolean> admin,
                            @RequestParam(value = "admin-password", required = false) Optional<String> apassword,
                            Model model) {
        String view = userService.registerNewUser(username, password, rpassword, email, phone, admin, apassword, model);
        return view;
    }
}

