package com.sc.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sc.blog.model.User;

// DAO
//@Repository 생략가능, 자동 등록
public interface UserRepository extends JpaRepository<User, Integer> {
    
    // 네이밍 쿼리
    // select * from user where username = 1?;
    Optional<User> findByUsername(String username);
    
//    // JPA Naming 전략, 하기 쿼리가 실행됨
//    // select * from user where username = ?{userName} And password = ?{password}
//    User findByUserNameAndPassword(String userName, String password);
    
//    @Query(value="select * from user where username = ? And password = ?", nativeQuery = true)
//    User login(String userName, String password);
    
}
