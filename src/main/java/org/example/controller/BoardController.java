package org.example.controller;

import org.example.entity.Board;
import org.example.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller // @RestController (JSON)
public class BoardController { //POJO -> new BoardController(); -> Spring Container--->DI(의존성주입)

    @Autowired
    private BoardMapper mapper;  // SqlSessionFactoryBean

   // http://localhost:8081/myweb/spring
    @RequestMapping("/spring")
    public String index(){
        return "template"; // /WEB-INF/views/template.jsp
    }

    // 리스트 가져오기 요청받기
    @RequestMapping("/list") // Handler Mapping
    public String list(Model model){
        List<Board> list=mapper.boardList();
       // 객체바인딩
        model.addAttribute("list", list);
        // view의 논리적린 이름 리턴-->프론트컨트롤러에게 리턴
        return "board/list"; // list.jsp
    }
    // 등록화면이동
    @GetMapping("/register")
    public String registerGet(){
        return "board/register"; // register.jsp
    }

    @PostMapping("/register") // title, content, writer -> JSON(X) /  DTO
    public  String registerPost(Board board) throws Exception{ // 파라메터수집
       // request.setCharsetEncoding("utf-8");
       int cnt=mapper.boardInsert(board); // 1,0
       if(cnt>0){
           return "redirect:/list";//등록성공-->다시 리스트페이로이동(redirect)
       }else{
           throw new ServletException("error");
       }
    }

    @GetMapping("/get/{num}")
    public String get(@PathVariable Long num, Model model){
         Board board=mapper.getByNum(num);
         model.addAttribute("board", board); // 객체바인딩
         // get.jsp forward
        return "board/get"; // ${board.?}
    }

    @GetMapping("/remove/{num}")
    public String remove(@PathVariable Long num){
        mapper.boardDelete(num);
        return "redirect:/list";
    }

    @GetMapping("/update/{num}")
    public String updateGet(Model  model, @PathVariable Long num){
          Board board=mapper.getByNum(num);
          model.addAttribute("board", board);
          return "board/update"; // update.jsp(<-get.jsp) - 실습
    }

    @PostMapping("/update")
    public String updatePost(Board board){ // num, title, content
         mapper.boardUpdate(board);
         return "redirect:/get/"+board.getNum(); // get/6
    }
}
