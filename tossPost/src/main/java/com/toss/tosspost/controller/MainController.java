package com.toss.tosspost.controller;

import com.toss.tosspost.model.DTO.MemberDTO;
import com.toss.tosspost.model.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    MainService mainService;

    // 회원가입
    @PostMapping("/join")
    public void joinSave(@RequestBody MemberDTO memberDTO){
        mainService.joinSave(memberDTO);
    }

    // 로그인(성공 : 200, 실패 : 400)
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody MemberDTO memberDTO){
        System.out.println(memberDTO);

        return mainService.login(memberDTO);
    }


}
