package com.example.front.controller.userController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
//    private final ApplicationUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    @PostMapping("/account/register")
    public String registerUser(@RequestParam("username") String username, @RequestParam("password") String password,
                            @RequestParam("rpassword") String rpassword, @RequestParam("email") String email,
                            @RequestParam("phone") String phone,
                            @RequestParam(value = "administratorCheckbox", required = false) Boolean admin,
                            @RequestParam(value = "admin-password", required = false) String apassword,
                            Model model) {

//        System.out.println(username);
//        if (!password.equals(rpassword)) {
//            model.addAttribute("error", "Hasła się nie zgadzają!");
//            return "/account/register";
//        }
//        if (password.length() < 8) {
//            model.addAttribute("error", "Za krótkie hasło!");
//            return "/account/register";
//        }
//
//        // Sprawdzenie, czy hasło zawiera co najmniej 1 dużą literę, 1 cyfrę i 1 znak specjalny
////        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{5,}$");
//        Pattern pattern = Pattern.compile("^[A-Za-z\\d@$!%*?&]{5,}$");
//
//        Matcher matcher = pattern.matcher(password);
//        if(!matcher.matches()){
//            model.addAttribute("error", "Niepoprawne hasło!");
//            return "/account/register";
//        }
////zrobić cos z hasłem admina
//        Set<Authority> grantedAuthority = new HashSet<>();
//// Jeśli admin jest włączony
//        if (admin != null) {
//            grantedAuthority.add(new Authority(1L, "ADMINISTRATOR"));
//        } else {
//            grantedAuthority.add(new Authority(2L, "KLIENT"));
//        }
//
//        ApplicationUserEntity applicationUser = new ApplicationUserEntity(
//                username,
//                passwordEncoder.encode(password),
//                grantedAuthority,
//                email,
//                phone,
//                true,
//                true,
//                true,
//                true
//        );
//        userRepository.save(applicationUser);
        return "/logInPage";
    }
}

