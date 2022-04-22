package com.sc.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sc.blog.model.RoleType;
import com.sc.blog.model.User;
import com.sc.blog.repository.UserRepository;

// 스프링이 bean에 등록 IOC 메모리에 뛰워 준다.
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder encoder;
    
    // 회원가입
    @Transactional
    public void save(User user) {
        
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);
        
        user.setPassword(encPassword);
        user.setRole(RoleType.USER);
        
        userRepository.save(user);
    }

//    // 로그인
//    // select 할 때 트랜젝션 시작, 서비스 종료시에 트랜젝션 종료 (정합성)
//    @Transactional(readOnly = true)
//    public User login(User user) {
//        return userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
//    }
}
