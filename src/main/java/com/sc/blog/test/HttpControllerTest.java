package com.sc.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// 사용자가 요청 -> 응답(html) 
// @Controller

// 사용자가 요청 -> 응답(data)
@RestController
public class HttpControllerTest {
    private static final String TAG = "HttpControllerTest:";
    @GetMapping("/http/lombok")
    public String lomnokTest() {
        Member m = new Member(1, "choi", "1234", "as@gmail.com");
        System.out.println("TAG getter:" + m.getId());
        m.setId(5000);
        System.out.println("TAG setter:" + m.getId());
        return "succ";
    }
    // 인터넷 요청은 get만 가능하다
    // http://localhost:8080/http/get
    @GetMapping("/http/get")
//    public String getTest(@RequestParam int id, @RequestParam String username) {
    public String getTest(Member m) {
        
//        return "get 요청 : " + id + ", " + username;
        return "get 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }
    
    // http://localhost:8080/http/post
    @PostMapping("/http/post") // text/plain
//    public String postTest(Member m) {
//    public String postTest(@RequestBody String text) {
    public String postTest(@RequestBody Member m) { // MessageConverter (스프링부트)
//        return "post 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
        return "post 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
//        return "post 요청 : " + text;
    }
    
    // http://localhost:8080/http/put
    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m) {
        return "put 요청 : " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", " + m.getEmail();
    }
    
    // http://localhost:8080/http/delete
    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }
}
