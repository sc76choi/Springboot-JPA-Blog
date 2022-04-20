package com.sc.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// ORM Object를 테이블로 매핑
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@DynamicInsert // insert시에 null인 필드는 제외시켜준다.
@Entity // User 클래스가 Mysql에 테이블이 생성이 된다.
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private int id; // 시쿼스 auto_increment
    
    @Column(nullable = false, length = 30)
    private String userName;
    
    @Column(nullable = false, length = 100) // 해쉬로 변경 암호화
    private String password;
    
    @Column(nullable = false, length = 50)
    private String email;
    
    // @ColumnDefault("'user'")
    @Enumerated(EnumType.STRING)
    private RoleType role; // Enum을 쓰는게 좋다. ADMIN, USER
    
    @CreationTimestamp //  시간이 자동 입력
    private Timestamp createDate;
    
}
