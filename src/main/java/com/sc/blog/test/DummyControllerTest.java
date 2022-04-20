package com.sc.blog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sc.blog.model.RoleType;
import com.sc.blog.model.User;
import com.sc.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
    
    @Autowired
    private UserRepository userRepository;
    
    // http://localhost:8000/blog/dummy/join
    // body에 요청
    @PostMapping("/dummy/join")
    public String join(User user) { // key = value 약속된 규칙
        System.out.println("username : " + user.getUserName());
        System.out.println("password : " + user.getPassword());
        System.out.println("email : " + user.getEmail());
        
        user.setRole(RoleType.USER); 
        userRepository.save(user);
        
        return "succ";
    }
}
