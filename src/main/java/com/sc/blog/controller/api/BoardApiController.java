package com.sc.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sc.blog.config.auth.PrincipalDetail;
import com.sc.blog.dto.ResponseDto;
import com.sc.blog.model.Board;
import com.sc.blog.service.BoardService;

@RestController
public class BoardApiController {
    
    @Autowired
    private BoardService boardService;
    
    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) {
        System.out.println("called BoardApiController! - save");
        boardService.save(board, principal.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
    
    @DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> deleteById(@PathVariable int id) {
        System.out.println("deleteById : " + id);
        boardService.deleteById(id);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
    
    @PutMapping("/api/board/{id}")
    public ResponseDto<Integer> updateById(@PathVariable int id, @RequestBody Board board) {
        System.out.println("updateById : " + id);
        boardService.updateById(id, board);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
