package com.sc.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sc.blog.dto.ResponseDto;

import com.sc.blog.model.User;
import com.sc.blog.service.UserService;

@RestController
public class UserApiController {
    
    @Autowired
    private UserService userService;

//    @Autowired
//    private HttpSession session;
    
//    @PostMapping("/api/user")
    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user) {
        System.out.println("called UserApiController! - save");
         
//        user.setRole(RoleType.USER);
        // 자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
        // 실제 DB에서 insert하고 return 
        userService.save(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
    
    // 전통적인 로그인 방식 
//    @PostMapping("/api/user/login")
//    public ResponseDto<Integer> login(@RequestBody User user) {
//        System.out.println("called UserApiController! - login");
//        
//        User principal = userService.login(user);
//        
//        System.out.println("principal : " + principal);
//        if(principal  != null) {
//            session.setAttribute("principal", principal); // 세션을 만듦
//        }
//        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
//    }
}
