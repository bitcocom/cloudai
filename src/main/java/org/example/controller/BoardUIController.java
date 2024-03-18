package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rest")
public class BoardUIController {  // View로 이동해주는 컨트롤러(Router  역할 - React.js)
      // http://localhost:8081/myweb/rest/list
       // 게시판 리스트보기
      @GetMapping("/list")
     public String list(){
          // DB에서 데이터를 가져오기 -> View
          return "rest/list";  // list.jsp(Ajax)
      }

}