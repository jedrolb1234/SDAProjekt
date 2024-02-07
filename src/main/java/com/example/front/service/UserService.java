package com.example.front.service;

import org.springframework.ui.Model;

import javax.servlet.http.HttpSession;
import java.util.Optional;

public interface UserService {
     void setIndexMVC(HttpSession session, Model model);
     String registerNewUser(String username, String password, String rpassword, String email, String phone,
                            Optional<Boolean> admin, Optional<String> apassword, Model model);
     String updateUser(String username, String password, String rpassword, String email, String phone,
                       Model model, HttpSession session);
}
