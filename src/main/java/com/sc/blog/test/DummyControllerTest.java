package com.sc.blog.test;

import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.sc.blog.model.RoleType;
import com.sc.blog.model.User;
import com.sc.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {
    
    @Autowired
    private UserRepository userRepository;
    
    // http://localhost:8000/blog/dummy/user/3
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {
        // user/4 를 찾으면 내가 데이터베이스에서 못찾아오게 되면 user가 null이 될것
        // 그럼 returen null 이되어 문제
        // Optional로 너의 User객체를 감싸서 가져올테니 null인지 아닌지 판단해서 retunr해
//        User user = userRepository.findById(id).orElseGet(new Supplier<User>(){
//            public User get() {
//                return new User();
//            }
//        });

//        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
//            public IllegalArgumentException get() {
//                return new IllegalArgumentException("해당유저는 없습니다. id = " + id);
//            }
//        });
        
        // 람다식
        User user = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("해당유저는 없습니다. id = " + id);
        });
        
        // user 객제는 = 자바 오브젝트
        // 변환 json으로
        // 스프링 부터 = MessageConverter라는 애가 응답시에 자동작동
        // 만약에 자바 오브젝트를 리턴하게 되면 Jackson이라는 라이브러리를 호출해서 
        // user 오브젝트를 json으로 변환해서 리턴
        
        return user;
    }
    
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
