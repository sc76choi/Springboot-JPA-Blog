package com.sc.blog.test;



import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncTest {

    @Test
    public void hashGo() {
        String encPassword = new BCryptPasswordEncoder().encode("1234");
        System.out.println(" go :" + encPassword);
    }
}
