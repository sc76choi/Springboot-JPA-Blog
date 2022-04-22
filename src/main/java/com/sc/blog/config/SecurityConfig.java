package com.sc.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// 빈등록 : 스프링 컨데이터에서 객채를 관리할 수 있게 하는것
@Configuration // 빈 등록 (객체 생성)
@EnableWebSecurity // 필터 체인에 등록 (스프링 시큐리티 활성화)
@EnableGlobalMethodSecurity(prePostEnabled=true) // 특정 주소 접근시 권한 및 인증을 pre(미리) 체크하겠다.
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Bean
    public BCryptPasswordEncoder encodePWD() {
//        String encPassword = new BCryptPasswordEncoder().encode("1234");
        return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable() // csrf 토큰 비활성화 (테스트시 걸어두는게 좋음)
        .authorizeRequests()
            .antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**")
            .permitAll()
            .anyRequest()
            .authenticated()
        .and()
            .formLogin().
            loginPage("/auth/loginForm");
    }
}