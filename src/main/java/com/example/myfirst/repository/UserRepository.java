package com.example.myfirst.repository;

import com.example.myfirst.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // select * from user where account = ? << test03, test04
    Optional<User> findByAccount(String account);
    //Optional 있을 수도 있고 없을 수도 있다.


    Optional<User> findByEmail(String email);

    // select * from user where account =? and email = ?
    Optional<User> findByAccountAndEmail(String account, String email);
}

// 레파지토리 핸들링