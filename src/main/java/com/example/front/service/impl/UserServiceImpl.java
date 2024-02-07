package com.example.front.service.impl;

import com.example.front.Auth.ApplicationUser;
import com.example.front.Model.ShoppingCart;
import com.example.front.repository.AppRepository;
import com.example.front.repository.ProductEntity;
import com.example.front.repository.UserRepository;
import com.example.front.service.UserService;
import com.example.front.user.Authority;
import com.example.front.user.UserEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    List<ProductEntity> product;
    private AppRepository repository;
    private int sumPrice;
    private int cartQuantity;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, AppRepository repository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.repository = repository;
    }

    public void setIndexMVC(HttpSession session, Model model) {
        product = repository.findAll()
                .stream()
                .filter(p -> !p.getPicture().isEmpty())
                .collect(Collectors.toList());
        cartQuantity = 0;
        sumPrice = 0;

        session.invalidate();

        model.addAttribute("ifLogged", false);
        model.addAttribute("sumPrice", 0);
        model.addAttribute("cartQuantity", 0);
        model.addAttribute("productList", product);
    }

    public String registerNewUser(String username, String password, String rpassword, String email, String phone,
                           Optional<Boolean> admin, Optional<String> apassword, Model model){
        boolean anyError = false;

        Optional<UserEntity> user = userRepository.findByName(username).stream().findFirst();

        if(user.isPresent()){
            model.addAttribute("error0", "Musisz wybrać inną nazwę!");
            anyError = true;
        }
        if (!password.equals(rpassword)) {
            model.addAttribute("error1", "Hasła się nie zgadzają!");
            anyError = true;
        }
        if (password.length() < 8) {
            model.addAttribute("error1", "Za krótkie hasło!");
            anyError = true;
        }

        // Sprawdzenie, czy hasło zawiera co najmniej 1 dużą literę, 1 cyfrę i 1 znak specjalny
//        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{5,}$");
        Pattern pattern = Pattern.compile("^[A-Za-z\\d@$!%*?&]{5,}$");
        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches()) {
            model.addAttribute("error2", "Niepoprawne hasło!");
            anyError = true;
        }
        pattern = Pattern.compile("^[A-Za-z0-9]{2,}[@][a-z]{2,}[.][a-z]{2,3}$");
        matcher = pattern.matcher(email);

        if (!matcher.matches()){
            model.addAttribute("error3", "niepoprawny format maila!");
            anyError = true;
        }
//zrobić cos z hasłem admina


        if (!anyError) {
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
        return "/account/register";
    }
    public String updateUser(String username, String password, String rpassword, String email, String phone,
                            Model model, HttpSession session){
        boolean anyError = false;

        Optional<UserEntity> user = userRepository.findByName(username).stream().findFirst();

        if(user.isPresent()){
            model.addAttribute("error0", "Musisz wybrać inną nazwę!");
            anyError = true;
        }
        if (!password.equals(rpassword)) {
            model.addAttribute("error1", "Hasła się nie zgadzają!");
            anyError = true;
        }
        if (password.length() < 8) {
            model.addAttribute("error1", "Za krótkie hasło!");
            anyError = true;
        }

        // Sprawdzenie, czy hasło zawiera co najmniej 1 dużą literę, 1 cyfrę i 1 znak specjalny
//        Pattern pattern = Pattern.compile("^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{5,}$");
        Pattern pattern = Pattern.compile("^[A-Za-z\\d@$!%*?&]{5,}$");
        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches()) {
            model.addAttribute("error2", "Niepoprawne hasło!");
            anyError = true;
        }
        pattern = Pattern.compile("^[A-Za-z0-9]{2,}[@][a-z]{2,}[.][a-z]{2,3}$");
        matcher = pattern.matcher(email);

        if (!matcher.matches()){
            model.addAttribute("error3", "niepoprawny format maila!");
            anyError = true;
        }

        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        } catch (Exception e) {
            logged = false;
        }
        Set<Authority> grantedAuthority = new HashSet<>();
        List<String> auth = null;
        boolean admin = false;
        long id = 0;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.getPrincipal() instanceof ApplicationUser) {
            ApplicationUser appuser = (ApplicationUser) authentication.getPrincipal();
            auth = appuser.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList()); //.stream().map(GrantedAuthority::getAuthority).findFirst();
//            System.out.println(auth.contains("ROLE_ADMIN"));
            id = appuser.getId();
            if(auth.contains("ROLE_ADMIN")) {
                grantedAuthority.add(new Authority("ADMIN"));
            } else {
                grantedAuthority.add(new Authority("CLIENT"));
            }

        }

        product = repository.findAll()
                .stream()
                .filter(p -> !p.getPicture().isEmpty())
                .collect(Collectors.toList());
        cartQuantity = 0;
        sumPrice = 0;

        model.addAttribute("ifLogged", logged);
        model.addAttribute("sumPrice", 0);
        model.addAttribute("cartQuantity", 0);
        model.addAttribute("productList", product);
        model.addAttribute("admin", admin);
        session.setAttribute("cart", new ArrayList<>());
        session.setAttribute("admin", admin);

        if (!anyError) {
            UserEntity applicationUser = new UserEntity(
                    id,
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
            return "/";
        }
        return "/account/register";
    }
}