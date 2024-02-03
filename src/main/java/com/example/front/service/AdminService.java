package com.example.front.service;

import com.example.front.repository.ProductEntity;
import com.example.front.user.UserEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public interface AdminService {
//    Optional<List<UserEntity>> findByName(String username);
    void setAdminMVC(HttpSession session, Model model, List<ProductEntity> product, int cartQuantity,
                     int sumPrice);
    void setDeleteProduct(HttpSession session, Model model, List<ProductEntity> product, long id);
    void setSearchProductByName(HttpSession session, Model model, List<ProductEntity> product, String name);
    void setDetailMVC(HttpSession session, Model model, long id);
    void setDeleteUserPageMVC(HttpSession session, Model model);
    void deleteUserByIdMVC(HttpSession session, Model model, long user);
    void setDeleteUserByName(HttpSession session, Model model, String username);

    void setAddProductPageMVC(HttpSession session, Model model);
    void setAddProductToDB( String name, String description, int price, int size, String brand,
                        int numberOfPlayer, int warranty, int category,  String picture0,
                        Optional<String> picture1, Optional<String> picture2,
                        Optional<String> picture3 , Optional<String> picture4);
}
