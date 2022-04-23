package com.sc.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sc.blog.config.auth.PrincipalDetailService;

// 빈등록 : 스프링 컨데이터에서 객채를 관리할 수 있게 하는것
@Configuration // 빈 등록 (객체 생성)
@EnableWebSecurity // 필터 체인에 등록 (스프링 시큐리티 활성화)
@EnableGlobalMethodSecurity(prePostEnabled=true) // 특정 주소 접근시 권한 및 인증을 pre(미리) 체크하겠다.
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private PrincipalDetailService principalDetailService;
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder encodePWD() {
//        String encPassword = new BCryptPasswordEncoder().encode("1234");
        return new BCryptPasswordEncoder();
    }
    
    // 시큐리티가 대신 로그인해 주는데 password를 가로채기를 하는데
    // 해당 password가 뭘로 해쉬가 되어 회원가입이 되었는지 알아야
    // 같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교할 수 있음
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .csrf().disable() // csrf 토큰 비활성화 (테스트시 걸어두는게 좋음)
        .authorizeRequests()
            .antMatchers("/", "/auth/**", "/js/**", "/css/**", "/image/**", "/dummy/**")
            .permitAll()
            .anyRequest()
            .authenticated()
        .and()
            .formLogin()
            .loginPage("/auth/loginForm")
            .loginProcessingUrl("/auth/loginProc") // 스프링 시큐리티가 해당 주소로 로그인을 가로채서 대신 로그인 한다.
            .defaultSuccessUrl("/");
    }
}