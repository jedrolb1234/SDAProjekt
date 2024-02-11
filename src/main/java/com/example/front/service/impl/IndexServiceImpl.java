package com.example.front.service.impl;

import com.example.front.Auth.ApplicationUser;
import com.example.front.Model.ShoppingCart;
import com.example.front.repository.AppRepository;
import com.example.front.repository.PictureEntity;
import com.example.front.repository.ProductEntity;
import com.example.front.service.IndexService;
import com.example.front.user.Authority;
import com.example.front.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class IndexServiceImpl implements IndexService {

    AppRepository repository;
    private List<ShoppingCart> cart = new ArrayList<>();
    List<ProductEntity> product;
    private int sumPrice;
    private int cartQuantity;

    public IndexServiceImpl(AppRepository repository) {
        this.repository = repository;
    }

    public void setIndexMVC(HttpSession session, Model model, List<ProductEntity> product, List<ShoppingCart> cart, int sumPrice, int cartQuantity) {
        product = repository.findAll()
                .stream()
                .filter(p -> !p.getPicture().isEmpty())
                .collect(Collectors.toList());
        cartQuantity = 0;
        sumPrice = 0;

        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        } catch (Exception e) {
            logged = false;
        }
//        Optional<Boolean> auth = Optional.of(false);
        List<String> auth = null;
        boolean admin = false;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.getPrincipal() instanceof ApplicationUser) {
            ApplicationUser user = (ApplicationUser) authentication.getPrincipal();
            auth = user.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList()); //.stream().map(GrantedAuthority::getAuthority).findFirst();
//            System.out.println(auth.contains("ROLE_ADMIN"));
            admin = auth.contains("ROLE_ADMIN");
        }
        model.addAttribute("ifLogged", logged);
        model.addAttribute("sumPrice", 0);
        model.addAttribute("cartQuantity", 0);
        model.addAttribute("productList", product);
        model.addAttribute("admin", admin);
        session.setAttribute("cart", new ArrayList<>());
        session.setAttribute("tokens", new ArrayList<>());
        session.setAttribute("admin", admin);
    }
    public void setLogOutPage(HttpSession session, Model model, List<ProductEntity> product, List<ShoppingCart> cart, int sumPrice, int cartQuantity){
        session.invalidate();
        product = repository.findAll().stream()
                .filter(p -> !p.getPicture().isEmpty())
                .collect(Collectors.toList());;
        cartQuantity = 0;
        sumPrice = 0;
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        }catch(Exception e){
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
        model.addAttribute("sumPrice", 0);
        model.addAttribute("cartQuantity", 0);
        model.addAttribute("productList", product);
    }
}
