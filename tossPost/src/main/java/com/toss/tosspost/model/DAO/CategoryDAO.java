package com.toss.tosspost.model.DAO;

import com.toss.tosspost.model.DTO.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CategoryDAO {

    //카테고리 등록
    int insertCategory(CategoryDTO categoryDTO);

    // 카테고리 조회
    List<CategoryDTO> categoryListAll(long ID_SEQ);

    // 카테고리 수정
    int categoryPut(CategoryDTO categoryDTO);
}
