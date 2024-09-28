package com.yedam.app.member.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yedam.app.member.mapper.MemberMapper;
import com.yedam.app.member.service.MemberService;
import com.yedam.app.member.service.MemberVO;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberMapper memberMapper;
	private PasswordEncoder passwordEncoder;
	
	public MemberServiceImpl(MemberMapper memberMapper,PasswordEncoder passwordEncoder) {
		this.memberMapper = memberMapper;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public Map<String, Object> overlapChk(MemberVO memberVO) {
		MemberVO mvo = memberMapper.overlapChk(memberVO);
		boolean isSuccess = false;
		Map<String,Object> map = new HashMap<>();
		if(mvo==null) {
			isSuccess = true;
		}
		map.put("result", isSuccess);
		return map;
	}
	@Override
	public Map<String, Object> memberSingup(MemberVO memberVO) {
		boolean isSuccess = false;
		Map<String,Object> map = new HashMap<>();
		String encodedPw = passwordEncoder.encode(memberVO.getMemberPw());
		memberVO.setMemberPw(encodedPw);
		int result = memberMapper.memberSingup(memberVO);
		if(result > 0) {
			isSuccess = true;
		}
		map.put("result", isSuccess);
		return map;
	}
}
