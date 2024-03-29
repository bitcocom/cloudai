package org.example.controller;

import org.example.entity.Board;
import org.example.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController // RestFull Service
@RequestMapping("/api")
public class BoardRestController { //POJO -> new BoardController(); -> Spring Container--->DI(의존성주입)

    @Autowired
    private BoardMapper mapper;  // SqlSessionFactoryBean
   // Restful API 명세서(문서)
   // GET   : http://localhost:8081/myweb/api/board   :   게시판 전체리스트
   // 리스트 가져오기 요청받기
    @GetMapping("/board")
    public List<Board> list(){
        List<Board> list=mapper.boardList();
         return list; // list -> JSONArray : [ {     },{     }...]
    }
    // POST   : http://localhost:8081/myweb/api/board   :   게시판 등록하기
    // request parameter : title, content, writer - JSON
    // 등록하기 요청받기
    @PostMapping("/board")
    public int register(@RequestBody Board board){  // 자동으로 파라메터가 수집
        System.out.println(board); // toString()
        return mapper.boardInsert(board);
    }
    // DELETE  : http://localhost:8081/myweb/api/board/4 : 게시판삭제하기
    // request parameter : num
    @DeleteMapping("/board/{num}")
    public int boardDelete(@PathVariable Long num){
         return mapper.boardDelete(num);
    }

    // GET  : http://localhost:8081/myweb/api/board/4 : 게시판상세보기
    @GetMapping("/board/{num}")
    public ResponseEntity<?> getBynum(@PathVariable Long num){
        Board board=mapper.getByNum(num);
        if(board!=null) {
            return new ResponseEntity<>(board, HttpStatus.OK); // X, O ->예외처리
        }else{
            return new ResponseEntity<>("실패", HttpStatus.BAD_REQUEST); // X, O ->예외처리
        }
    }
    @PutMapping("/board/{num}")
    public ResponseEntity<?> boardUpdate(@PathVariable Long num,@RequestBody  Board board){
        board.setNum(num); // ?
        return new ResponseEntity<>(mapper.boardUpdate(board), HttpStatus.OK);
    }
}
