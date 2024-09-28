package com.yedam.app.member.web;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.app.member.service.MemberService;
import com.yedam.app.member.service.MemberVO;

@Controller
public class MemberController {

	@Value("${file.upload.path}") // 실행되는 시점에 환경변수에 접근하여 값을 가져온다 (운영체제에 따라 바뀌는값을 알아서 찾아 넣어준다)
	private String uploadPath;
	
	@Autowired
	private MemberService memberService;
	
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	@GetMapping("/login")
	public String loginPage() {
		return "member/login";
	}
	
	@GetMapping("/signup")
	public String signupPage(){
		return "member/signup";
	}
	@PostMapping("/overlapChk")
	@ResponseBody
	public Map<String,Object> overlapChk(MemberVO memberVO,Model model){
		return memberService.overlapChk(memberVO);
	}
	@PostMapping("/memberSignup")
	@ResponseBody
	public Map<String,Object> memberSignup(MemberVO memberVO, MultipartFile memberProfileImg) {
		if (memberProfileImg != null) {
		UUID uuid = UUID.randomUUID();
		String uuidName = uuid + "_" + memberProfileImg.getOriginalFilename();
		memberVO.setMemberProfile(uuidName);
		String saveName = uploadPath + '/' + uuidName;
		Path savePaths = Paths.get(saveName);
		// Paths.get() 메서드는 특정 경로의 파일 정보를 가져옵니다.(경로 정의하기)
		try {
			memberProfileImg.transferTo(savePaths);
			// uploadFile에 파일을 업로드 하는 메서드 transferTo(file)
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		return memberService.memberSingup(memberVO);
	}
}
