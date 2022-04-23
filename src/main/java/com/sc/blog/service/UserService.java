package com.sc.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sc.blog.model.RoleType;
import com.sc.blog.model.User;
import com.sc.blog.repository.UserRepository;

// 스프링이 bean에 등록 IOC 메모리에 뛰워 준다.
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private BCryptPasswordEncoder encoder;

    
    // 회원가입
    @Transactional
    public void save(User user) {
        
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);
        
        user.setPassword(encPassword);
        user.setRole(RoleType.USER);
        
        userRepository.save(user);
    }
    
    @Transactional
    public void update(User user) {
        // 수정시에는 JPA 영속성 컨텍스트 User 오브젝트를 영속화 시키고, 영속화된 User 오브젝트를 수정
        // select 를 해서 User오프젝트를 dB로 부터 가져오는 이유는 영속회ㅏ를 하기 위해서
        // 영속화된 오브젝트를 변겨하면 자동으로 DB에 update문을 날려줌
        User persistance = userRepository.findById(user.getId())
                    .orElseThrow(() -> {
                       return new IllegalArgumentException("회원 찾기 실패");
                    });
        String rawPassword = user.getPassword();
        String encPassword = encoder.encode(rawPassword);
        //persistance.setUsername(user.getUsername());
        persistance.setPassword(encPassword);
        persistance.setEmail(user.getEmail());
        
        //userRepository.save(persistance);
        // 회원수정 함수 종료시 = 서비스 종료 = 트랜젝션이 종료 = commit이 자동
        // 영속화된 persistance 객체의 변화가 감지되면 터티체킹이 되어 update문을 날려줌.
    }

//    // 로그인
//    // select 할 때 트랜젝션 시작, 서비스 종료시에 트랜젝션 종료 (정합성)
//    @Transactional(readOnly = true)
//    public User login(User user) {
//        return userRepository.findByUserNameAndPassword(user.getUserName(), user.getPassword());
//    }
}
