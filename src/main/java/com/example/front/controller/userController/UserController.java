package com.example.front.controller.userController;

import com.example.front.repository.AppRepository;
import com.example.front.repository.ProductEntity;
import com.example.front.repository.UserRepository;
import com.example.front.user.UserEntity;
import com.example.front.user.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class UserController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    List<ProductEntity> product;
    private AppRepository repository;
    private int sumPrice;
    private int cartQuantity;
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

//    @GetMapping("/account/register")
//    String register(HttpSession session, Model model){
//        session.invalidate();
//        product = repository.findAll();
//        cartQuantity = 0;
//        sumPrice = 0;
//        model.addAttribute("sumPrice", 0);
//        model.addAttribute("cartQuantity", 0);
//        model.addAttribute("productList", product);
//
//        return "/logInPage";
//    }
    @PostMapping("/account/register")
    public String registerUser(@RequestParam("username") String username, @RequestParam("password") String password,
                            @RequestParam("rpassword") String rpassword, @RequestParam("email") String email,
                            @RequestParam("phone") String phone,
                            @RequestParam(value = "administratorCheckbox", required = false) Optional<Boolean> admin,
                            @RequestParam(value = "admin-password", required = false) Optional<String> apassword,
                            Model model) {

        if (!password.equals(rpassword)) {
            model.addAttribute("error", "Hasła się nie zgadzają!");
            return "/account/register";
        }
        if (password.length() < 8) {
            model.addAttribute("error", "Za krótkie hasło!");
            return "/account/register";
        }

        // Sprawdzenie, czy hasło zawiera co najmniej 1 dużą literę, 1 cyfrę i 1 znak specjalny
//        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{5,}$");
        Pattern pattern = Pattern.compile("^[A-Za-z\\d@$!%*?&]{5,}$");

        Matcher matcher = pattern.matcher(password);
        if(!matcher.matches()){
            model.addAttribute("error", "Niepoprawne hasło!");
            return "/account/register";
        }
//zrobić cos z hasłem admina
        Set<Authority> grantedAuthority = new HashSet<>();
// Jeśli admin jest włączony
        if (admin.isPresent()) {
            grantedAuthority.add(new Authority( "ADMIN"));
        } else {
            grantedAuthority.add(new Authority( "CLIENT"));
        }

        UserEntity applicationUser = new UserEntity(
                username,
                passwordEncoder.encode(password),
                email,
                phone,
                true,
                true,
                true,
                true
        );

        applicationUser.setAuthorities(grantedAuthority);
        userRepository.save(applicationUser);
        return "/logInPage";
    }
}

