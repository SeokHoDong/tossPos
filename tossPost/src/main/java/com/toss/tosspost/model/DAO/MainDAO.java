package com.toss.tosspost.model.DAO;

import com.toss.tosspost.model.DTO.MemberDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainDAO {

    int createMember(MemberDTO memberDTO);

    MemberDTO selectMemberLogin(MemberDTO memberDTO);

}
