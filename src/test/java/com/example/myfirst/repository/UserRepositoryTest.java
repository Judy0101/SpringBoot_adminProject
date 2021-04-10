package com.example.myfirst.repository;


import com.example.myfirst.MyfirstApplicationTests;
import com.example.myfirst.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

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

    public void read(){

    }

    public void update(){

    }

    public void delete(){

    }
}
