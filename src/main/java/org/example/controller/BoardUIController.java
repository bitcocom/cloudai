package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
      @GetMapping("/register")
      public String register(){
          return "rest/register"; // register.jsp
      }

      @GetMapping("/get/{num}")
      public String get(@PathVariable Long num, Model model){
            model.addAttribute("num",  num);
            return "rest/get"; //get.jsp
      }

      @GetMapping("/update/{num}")
      public String updateGet(Model model, @PathVariable Long num){
          model.addAttribute("num", num);
          return "rest/update"; // update.jsp
      }
}
