package com.sc.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sc.blog.model.User;

// DAO
//@Repository 생략가능, 자동 등록
public interface UserRepository extends JpaRepository<User, Integer> {
    
}
