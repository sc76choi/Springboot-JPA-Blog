package com.sc.blog.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.blog.model.User;
import com.sc.blog.repository.UserRepository;

// 스프링이 bean에 등록 IOC 메모리에 뛰워 준다.
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    // 회원가입
    @Transactional
    public int save(User user) {
        try {
            userRepository.save(user);
            return 1;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println("UserService : save" + e.getMessage());
        }
        return -1;
    }
}
