package com.example.front.repositoryTests;

import com.example.front.repository.UserRepository;
import com.example.front.user.Authority;
import com.example.front.user.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class UserRepositoryTests {
    @Autowired
    private UserRepository repository;
    UserEntity userT;
    UserEntity userB;

//    public UserRepositoryTests(UserRepository repository) {
//        this.repository = repository;
//    }

//
    @BeforeEach
    public void setUser(){
        userT = new UserEntity("Tomek", "12345678", "Tomek@gmail.com", "123456789", false, false, false, false);

        Set<Authority> newSetT = new HashSet<>();
        newSetT.add(new Authority("CLIENT"));
        userT.setAuthorities(newSetT);

        userB = new UserEntity("Bartek", "12345678", "Tomek@gmail.com", "123456789", false, false, false, false);


        Set<Authority> newSetB = new HashSet<>();
        newSetB.add(new Authority("ADMIN"));
        userB.setAuthorities(newSetB);
    }
    @Test
    void givenUser_whenSaved_thenReturnSavedUser() {
        //given

        //when
        UserEntity savedUserT = repository.save(userT);


        //then
        assertThat(savedUserT).isNotNull();
        assertThat(savedUserT.getId()).isGreaterThan(0);
        assertThat(savedUserT.getAuthorities()).isNotNull();
        assertThat(savedUserT.getAuthorities().stream().findFirst().get().getAuthority()).isEqualTo("CLIENT");

//        assertThat(savedUserB.getAuthorities().stream().findFirst().get().getAuthority()).isEqualTo("ADMIN");

    }
    @Test
    void givenUser_thenDeleteUser(){
        repository.save(userB);
        List<UserEntity> user = repository.findByName("Bartek");

        long id = user.get(0).getId();
        repository.delete(userB);
        Optional<UserEntity> userById = repository.findById(id);
        assertThat(userById).isEmpty();
    }


















}
