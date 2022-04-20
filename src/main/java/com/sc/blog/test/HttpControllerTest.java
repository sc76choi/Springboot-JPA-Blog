package com.sc.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 사용자가 요청 -> 응답(html) 
// @Controller

// 사용자가 요청 -> 응답(data)
@RestController
public class HttpControllerTest {
    
    // 인터넷 요청은 get만 가능하다
    // http://localhost:8080/http/get
    @GetMapping("/http/get")
//    public String getTest(@RequestParam int id, @RequestParam String username) {
    public String getTest(Member m) {
//        return "get 요청 : " + id + ", " + username;
        return "get 요청 : " + m.getId() + ", " + m.getUsername();
    }
    
    // http://localhost:8080/http/post
    @PostMapping("/http/post")
    public String postTest() {
        return "post 요청";
    }
    
    // http://localhost:8080/http/put
    @PutMapping("/http/put")
    public String putTest() {
        return "put 요청";
    }
    
    // http://localhost:8080/http/delete
    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }
}
