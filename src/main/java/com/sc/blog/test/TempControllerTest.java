package com.sc.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
    
    @GetMapping("/temp/home")
    public String tempHome() {
        return "/home";
    }
}
