package org.example.controller;

import org.example.entity.Member;
import org.example.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private LoginService service;

    @PostMapping("/login")
    public String login(Member member, HttpSession session){
             Member dbmember=service.login(member); // null(실패), not null(성공)
             if(dbmember!=null){ // 성공
                 // PageContext, HttpServletRequest, HttpSession, ServletContext
                session.setAttribute("member",dbmember);
             }
            // 다시 시작페이지(list)로 전환
           return "redirect:/list";
    }
}
