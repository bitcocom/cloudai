package org.example.controller;

import org.example.entity.Board;
import org.example.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BoardController { //POJO -> new BoardController(); -> Spring Container--->DI(의존성주입)

    @Autowired
    private BoardMapper mapper;
    // 리스트 가져오기 요청받기
    @RequestMapping("/list") // Handler Mapping
    public String list(Model model){
        List<Board> list=mapper.boardList();
       // 객체바인딩
        model.addAttribute("list", list);
        // view의 논리적린 이름 리턴-->프론트컨트롤러에게 리턴
        return "list";
    }
    // 등록하기 요청받기




}
