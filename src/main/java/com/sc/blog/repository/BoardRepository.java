package com.sc.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sc.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {
    
}
