package com.sc.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sc.blog.dto.ReplySaveRequestDto;
import com.sc.blog.model.Board;
import com.sc.blog.model.Reply;
import com.sc.blog.model.User;
import com.sc.blog.repository.BoardRepository;
import com.sc.blog.repository.ReplyRepository;
import com.sc.blog.repository.UserRepository;

// 스프링이 bean에 등록 IOC 메모리에 뛰워 준다.
@Service
public class BoardService {
    
    @Autowired
    private BoardRepository boardRepository;
    
    @Autowired
    private ReplyRepository replyRepository;
    
    @Autowired
    private UserRepository userRepository;
    
    @Transactional
    public void save(Board board, User user) { // title, content
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    public Page<Board> list(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }
    
    // 글 상세보기
    public Board detail(int id) {
        return boardRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 상세보기 실패! id : " + id);
                });
    }
    
    public void deleteById(int id) {
        boardRepository.deleteById(id);
    }
    
    // 글수정하기
    @Transactional
    public void updateById(int id, Board requestBoard) {
        Board board = boardRepository.findById(id)
                .orElseThrow(()->{
                    return new IllegalArgumentException("글 찾기 실패! id : " + id);
                });
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
        
        // 해당함수 종료시에, 트랜젝션이 Service가 종료될때, 트랜젝션이 종료됨. 이때 더티 체킹 발생 자동 업데이트 db flush
    }
    
    // 댓글 쓰기
    @Transactional
    // public void replySave(User user, int boardId, Reply requestReply) {
    public void replySave(ReplySaveRequestDto replySaveRequestDto) {
        
        User user =  userRepository.findById(replySaveRequestDto.getUserId())
            .orElseThrow(()->{
                return new IllegalArgumentException("댓글 쓰기 실패! userId : " + replySaveRequestDto.getUserId());
            }); // 영속화 완료
        
        Board board =  boardRepository.findById(replySaveRequestDto.getBoardId())
            .orElseThrow(()->{
                return new IllegalArgumentException("댓글 쓰기 실패! boardId : " + replySaveRequestDto.getBoardId());
            }); // 영속화 완료
        
        Reply reply = Reply.builder()
                .user(user)
                .board(board)
                .content(replySaveRequestDto.getContent())
                .build();
                
        // requestReply.setUser(user);
        // requestReply.setBoard(board);
        
        replyRepository.save(reply);
    }
}
