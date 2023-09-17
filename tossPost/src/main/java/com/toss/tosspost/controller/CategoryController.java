package com.toss.tosspost.controller;

import com.toss.tosspost.model.DTO.CategoryDTO;
import com.toss.tosspost.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    // 카테고리 등록
    @PostMapping("/category")
    public ResponseEntity<Object> category(@RequestBody CategoryDTO categoryDTO){
        return categoryService.insertCategory(categoryDTO);
    }

    // 카테고리 조회
    @GetMapping("/categoryList/{ID_SEQ}")
    public ResponseEntity<Object> categoryList(@PathVariable("ID_SEQ") long ID_SEQ){
        return categoryService.categoryListAll(ID_SEQ);
    }

    // 카테고리 수정
    @PutMapping("/categoryPut/{CATG_SEQ}")
    public ResponseEntity<Object> categoryPut(@PathVariable("CATG_SEQ") int CATG_SEQ, @RequestBody CategoryDTO categoryDTO){
        System.out.println(CATG_SEQ);
        System.out.println(categoryDTO);

        return categoryService.categoryPut(categoryDTO, CATG_SEQ);
    }


    // 카테고리 삭제
}
