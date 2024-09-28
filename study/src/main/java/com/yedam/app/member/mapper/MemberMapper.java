package com.yedam.app.member.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.yedam.app.member.service.MemberVO;

@Mapper
public interface MemberMapper {
	
	MemberVO overlapChk(MemberVO memberVO); // 아이디 중복체크
	int memberSingup(MemberVO memberVO); //  회원가입
	
}
