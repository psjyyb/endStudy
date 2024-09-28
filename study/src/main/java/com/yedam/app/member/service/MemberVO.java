package com.yedam.app.member.service;

import java.util.Date;

import lombok.Data;

@Data
public class MemberVO {
	private Integer memberNo;
	private String memberId;
	private String memberPw;
	private String memberNickname;
	private String memberPhone;
	private String memberProfile;
	private String memberResp;
	private Date memberJoinDate;
}
