package com.sc.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sc.blog.config.auth.PrincipalDetail;

@Controller
public class BoardController {
    
    @GetMapping({"", "/"})
    //public String index(@AuthenticationPrincipal PrincipalDetail principal) { // 컨트롤러 에서 세션을 어떻게 찾는지?
    public String index() { // 컨트롤러 에서 세션을 어떻게 찾는지?
//        System.out.println("login user : " + principal.getUsername());
        return "index";
    }
}
