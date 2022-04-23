package com.sc.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sc.blog.config.auth.PrincipalDetail;
import com.sc.blog.dto.ResponseDto;
import com.sc.blog.model.User;
import com.sc.blog.service.UserService;

@RestController
public class UserApiController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private AuthenticationManager authenticationManager;
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
    
    // 회원수정
    @PutMapping("/user")
    public ResponseDto<Integer> update(@RequestBody User user) { // key = value, x-www-urlencoded
        userService.update(user);
        // 여기서는 트랜젝션이 종료되기 때문에 DB에 값을 변경되나
        // 세셧 값을 변경되지 않음, 직접 세션값을 변경해야 한다.
//        Authentication authentication =
//                new UsernamePasswordAuthenticationToken(principal, null, principal.getAuthorities());
//        SecurityContext securityContext = SecurityContextHolder.getContext(); 
//        securityContext.setAuthentication(authentication); // 세션값을 변경해줌
//        session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
        
        // 세션등록
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
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
