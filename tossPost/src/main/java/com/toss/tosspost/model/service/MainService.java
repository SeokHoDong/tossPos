package com.toss.tosspost.model.service;


import com.toss.tosspost.model.DAO.MainDAO;
import com.toss.tosspost.model.DTO.ErrorResponse;
import com.toss.tosspost.model.DTO.MemberDTO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class MainService {

    @Autowired
    MainDAO mainDAO;

    private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public void joinSave(MemberDTO memberDTO){
        mainDAO.createMember(memberDTO);
    }

    public ResponseEntity<Object> login(MemberDTO memberDTO){

        MemberDTO memberInfoDTO = mainDAO.selectMemberLogin(memberDTO);

        System.out.println(memberInfoDTO);

        if(memberInfoDTO.getId_SEQ() != null){
            String token = generateToken(memberInfoDTO.getId_SEQ());

            System.out.println(token);

            // 토큰을 헤더에 추가
            HttpHeaders headers = new HttpHeaders();
            headers.add("token", token);

            System.out.println(headers);

            return ResponseEntity.status(HttpStatus.OK).headers(headers).build();

        } else {
            // 인증 실패 시 오류 응답
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("400"));
        }

    }

    private String generateToken(String Id_SEQ) {
        Date expiration = new Date(System.currentTimeMillis() + 3600_000); // 1 hour
        return Jwts.builder()
                .setSubject(Id_SEQ)
                .setExpiration(expiration)
                .signWith(secretKey)
                .compact();
    }

}
