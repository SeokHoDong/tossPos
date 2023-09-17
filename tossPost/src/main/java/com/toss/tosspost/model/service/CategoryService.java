package com.toss.tosspost.model.service;

import com.toss.tosspost.model.DAO.CategoryDAO;
import com.toss.tosspost.model.DTO.CategoryDTO;
import com.toss.tosspost.model.DTO.ErrorResponse;
import com.toss.tosspost.model.DTO.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    // 카테고리 등록
    public ResponseEntity<Object> insertCategory(CategoryDTO categoryDTO){
        int Whether = categoryDAO.insertCategory(categoryDTO);

        if(Whether == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("400"));
        }

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse("200"));
    }

    // 카테고리 목록
    public ResponseEntity<Object> categoryListAll(long ID_SEQ){
        return ResponseEntity.status(HttpStatus.OK).body(categoryDAO.categoryListAll(ID_SEQ));
    }


    // 카테고리 수정
    public ResponseEntity<Object> categoryPut(CategoryDTO categoryDTO, int CATG_SEQ){
        categoryDTO.setCATG_SEQ(CATG_SEQ);

        int Whether = categoryDAO.categoryPut(categoryDTO);

        System.out.println(Whether);

        if(Whether == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("400"));
        }

        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse("200"));
    }

}
