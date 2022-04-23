package com.sc.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sc.blog.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer>{

}
