package com.yedam.app.member.service;

import java.util.Map;

public interface MemberService {
	Map<String,Object> overlapChk(MemberVO memberVO); // 아이디 중복체크
	Map<String,Object> memberSingup(MemberVO memberVO); //  회원가입
}
