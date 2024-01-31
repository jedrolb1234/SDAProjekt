package com.example.front.repository;


import com.example.front.user.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
//    @Modifying
//    @Transactional
//    @Query(value = "insert into users(username, password, email, phone, is_account_non_expired, is_credentials_non_expired,  is_account_non_locked, is_enabled) values (:username, :password, :email, :phone, :isAccountNonExpired, :isAccountNonLocked, :isCredentialsNonExpired, :isEnabled)", nativeQuery = true)
//    void saveNewUser(String username, String password, String email, String phone, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled);
}


