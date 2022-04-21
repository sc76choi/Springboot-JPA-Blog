package com.sc.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sc.blog.dto.ResponseDto;
import com.sc.blog.model.RoleType;
import com.sc.blog.model.User;
import com.sc.blog.service.UserService;

@RestController
public class UserApiController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user) {
        System.out.println("called UserApiController!");
        
        user.setRole(RoleType.USER);
        // 자바오브젝트를 JSON으로 변환해서 리턴(Jackson)
        // 실제 DB에서 insert하고 return 
        int result = userService.save(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), result);
    }
}
