package com.example.front.service.impl;

import com.example.front.Model.ShoppingCart;
import com.example.front.repository.AppRepository;
import com.example.front.repository.PictureEntity;
import com.example.front.repository.ProductEntity;
import com.example.front.repository.UserRepository;
import com.example.front.service.AdminService;
import com.example.front.user.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    UserRepository userRepository;
    AppRepository repository;
    List<UserEntity> users;
    private List<ShoppingCart> cart = new ArrayList<>();



    public AdminServiceImpl(UserRepository user, AppRepository repository) {
        this.repository = repository;
        this.userRepository = user;
    }

//    public Optional<List<UserEntity>> findByName(String username){
//        List<UserEntity> users = userRepository.findAll().stream()
//                .filter(user -> user.getUsername().equals(username))
//                .collect(Collectors.toList());
//        return Optional.ofNullable(users);
//        };


    @Override
    public void setAdminMVC(HttpSession session, Model model, List<ProductEntity> product, int cartQuantity,
                            int sumPrice) {
        product = repository.findAll()
                .stream()
                .filter(p -> !p.getPicture().isEmpty())
                .collect(Collectors.toList());;
        cartQuantity = 0;
        sumPrice = 0;
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
//            System.out.println(logged);
        }catch(Exception e){
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
        model.addAttribute("productList", product);
    }

    public void setDeleteProduct(HttpSession session, Model model, List<ProductEntity> product, long id){
        repository.deleteById(id);
        product = repository.findAll()
                .stream()
                .filter(p -> !p.getPicture().isEmpty())
                .collect(Collectors.toList());;
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
//            System.out.println(logged);
        }catch(Exception e){
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
        model.addAttribute("productList", product);
    };
    public void setSearchProductByName(HttpSession session, Model model, List<ProductEntity> product, String name){
        product = repository.findProductsByName(name)
                .stream()
                .filter(p -> !p.getPicture().isEmpty())
                .collect(Collectors.toList());;
        model.addAttribute("productList", product);
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        } catch (Exception e) {
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
    }

    public void setDetailMVC(HttpSession session, Model model, long id){
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        } catch (Exception e) {
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
        Optional<ProductEntity> productOptional = repository.getProductByProductId(id);
        if(productOptional.isPresent()) {
            ProductEntity product = productOptional.get();
            model.addAttribute("product", product);
        }
    };
    public void setDeleteUserPageMVC(HttpSession session, Model model){
        users = userRepository.findAll();
        System.out.println(users.get(0));
        System.out.println(users.get(0).getAuthorities());
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        }catch(Exception e){
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
        model.addAttribute("usersList", users);
    };

    public void deleteUserByIdMVC(HttpSession session, Model model, long user){
        userRepository.deleteById(user);
        users = userRepository.findAll();
        System.out.println(users.get(0).getAuthorities());
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        }catch(Exception e){
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
        model.addAttribute("usersList", users);

    }

    public void setDeleteUserByName(HttpSession session, Model model, String username){
        users = userRepository.findByName(username);
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        }catch(Exception e){
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
        model.addAttribute("usersList", users);
    }

    public void setAddProductPageMVC(HttpSession session, Model model){
        boolean logged;
        try {
            logged = (boolean) session.getAttribute("logged");
        }catch(Exception e){
            logged = false;
            logged = false;
        }
        model.addAttribute("ifLogged", logged);
    };

    public void setAddProductToDB( String name, String description, int price, int size, String brand,
                            int numberOfPlayer, int warranty, int category,  String picture0,
                            Optional<String> picture1, Optional<String> picture2,
                            Optional<String> picture3 , Optional<String> picture4){

        ProductEntity product;
        List<PictureEntity> pictures = new ArrayList<>();
        PictureEntity picture_0 = new PictureEntity();
        product = ProductEntity.builder()
                .brand(brand)
                .description(description)
                .category(category)
                .name(name)
                .numberOfPlayer(numberOfPlayer)
                .size(size)
                .warranty(warranty)
                .price(price)
                .build();

        picture_0.setPath(picture0);
        picture_0.setProduct(product);
        pictures.add(picture_0);

        if(picture1.isPresent() ){
            if(picture1.get().length() != 0){
                PictureEntity picture_1 = new PictureEntity();
                picture_1.setPath(picture1.get());
                picture_1.setProduct(product);
                pictures.add(picture_1);

                if(picture2.isPresent()){
                    if(picture2.get().length() != 0){
                        PictureEntity picture_2 = new PictureEntity();
                        picture_2.setPath(picture2.get());
                        picture_2.setProduct(product);
                        pictures.add(picture_2);

                        if(picture3.isPresent()){
                            if(picture3.get().length() != 0) {
                                PictureEntity picture_3 = new PictureEntity();
                                picture_3.setPath(picture3.get());
                                picture_3.setProduct(product);
                                pictures.add(picture_3);

                                if(picture4.isPresent()){
                                    if (picture4.get().length() != 0) {
                                        PictureEntity picture_4 = new PictureEntity();
                                        picture_4.setPath(picture4.get());
                                        picture_4.setProduct(product);
                                        pictures.add(picture_4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        product.setPicture(pictures);
        repository.save(product);
    };
}
