package org.example.service;


import org.example.entity.Member;
import org.example.repository.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginService {  // new LoginService();

        @Autowired
        private MemberMapper mapper;

        @Transactional
        public Member login(Member member){
                // 새로운 비즈니스로직처리..... -> commit, rollback, 동기화처리
                return mapper.login(member);
        }

}
