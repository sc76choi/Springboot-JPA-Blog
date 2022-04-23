package com.sc.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sc.blog.model.Board;
import com.sc.blog.service.BoardService;

@Controller
public class BoardController {
    
    @Autowired
    private BoardService boardService;
    
    @GetMapping({"", "/"})
    //public String index(@AuthenticationPrincipal PrincipalDetail principal) { // 컨트롤러 에서 세션을 어떻게 찾는지?
    public String index(Model model, @PageableDefault(size=3, sort="id", direction=Sort.Direction.DESC)Pageable pageable) { // 컨트롤러 에서 세션을 어떻게 찾는지?
//        System.out.println("login user : " + principal.getUsername());
        Page<Board> boards = (boardService.list(pageable));
        
        model.addAttribute("boards", boards);
        return "index"; //viewResolver가 작동
    }
    
    // User권한이 필요함
    @GetMapping("/board/saveForm")
    public String saveForm() {
        return "board/saveForm";
    }
}
