package com.sc.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.sc.blog.dto.ReplySaveRequestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private int id; // 시쿼스 auto_increment
    
    @Column(nullable = false, length = 200)
    private String content;
    
    @ManyToOne // Many = Reply,  One = Reply
    @JoinColumn(name="boardId") 
    private Board board;
    
    @ManyToOne // Many = Reply,  One = User
    @JoinColumn(name="userId")
    private User user;
    
    @CreationTimestamp
    private Timestamp createDate;
    
    public void update(User user, Board board, String content) {
        setUser(user);
        setBoard(board);
        setContent(content);
    }
    
}
