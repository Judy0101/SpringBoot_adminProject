package com.example.myfirst.repository;

import com.example.myfirst.MyfirstApplicationTests;
import com.example.myfirst.model.entity.AdminUser;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class AdminUserRepositoryTest extends MyfirstApplicationTests {

    @Autowired
    private AdminUserRepository adminUserRepository;

   @Test
    public void create(){

        AdminUser adminUser = new AdminUser();

        adminUser.setAccount("AdminUser01");
        adminUser.setPassword("AdminUer01");
        adminUser.setStatus("RESISTER");
        adminUser.setRole("PARTNER");
        adminUser.setCreatedAt(LocalDateTime.now());
        adminUser.setCreatedBy("AdminServer");

        AdminUser newAdminUser = adminUserRepository.save(adminUser);

        Assert.assertNotNull(newAdminUser);

    }
}
