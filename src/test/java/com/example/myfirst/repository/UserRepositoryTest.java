package com.example.myfirst.repository;


import com.example.myfirst.MyfirstApplicationTests;
import com.example.myfirst.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Optional;

public class UserRepositoryTest extends MyfirstApplicationTests {

    //Dependency Injection(DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        //String sql = insert into user(%s, %s, %d) value (accout, email, age);

        User user = new User();

        user.setAccount("TestUser01");
        user.setEmail("Test@gamil.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);


    }

    @Test
    public void read(){
        Optional<User> user = userRepository.findById(2L);


        user.ifPresent(selectUser -> {
            System.out.println("user : " + selectUser);
            System.out.println("email : " + selectUser.getEmail());
        });



    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("pppp");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });

    }

    public void delete(){

    }
}
