package com.sc.blog.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sc.blog.model.Board;
import com.sc.blog.model.Reply;
import com.sc.blog.repository.BoardRepository;
import com.sc.blog.repository.ReplyRepository;

@RestController
public class ReplyControllerTest {
    
    @Autowired
    private BoardRepository boardRepository;
    
    @Autowired
    private ReplyRepository replyRepository;
    
    @GetMapping("/test/board/{id}")
    public Board getBoard(@PathVariable int id) {
        return boardRepository.findById(id).get(); // jackson 라이브러리(오브젝트를 json 으로 리턴) => 모델의 getter를 호출
    }

    @GetMapping("/test/reply")
    public List<Reply> getReply() {
        return replyRepository.findAll(); // jackson 라이브러리(오브젝트를 json 으로 리턴) => 모델의 getter를 호출
    }
}
