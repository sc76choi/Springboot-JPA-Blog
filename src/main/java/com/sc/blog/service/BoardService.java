package com.sc.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sc.blog.model.Board;
import com.sc.blog.model.User;
import com.sc.blog.repository.BoardRepository;

// 스프링이 bean에 등록 IOC 메모리에 뛰워 준다.
@Service
public class BoardService {
    
    @Autowired
    private BoardRepository boardRepository;
    
    @Transactional
    public void save(Board board, User user) { // title, content
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    public Page<Board> list(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }
}
