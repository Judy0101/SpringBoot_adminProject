package com.example.myfirst.repository;

import com.example.myfirst.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

// 레파지토리 핸들링