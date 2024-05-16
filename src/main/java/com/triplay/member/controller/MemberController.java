package com.triplay.member.controller;

import java.io.Console;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.triplay.member.dto.MemberDto;
import com.triplay.member.service.MemberService;
import com.triplay.util.JWTUtil;
import com.triplay.util.RestUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/member")
@CrossOrigin(origins = {"*"}, maxAge = 60000)
@Slf4j
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private JWTUtil jwtUtil;
	
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> loginData) {
		String member_id = loginData.get("member_id");
		String member_pw = loginData.get("member_pw");
		
		MemberDto loginMember = null;
		try {
			loginMember = memberService.login(member_id, member_pw);
		} catch (Exception e) {
			e.printStackTrace();
			return RestUtil.makeErrorResponseEntity("로그인 실패");
		}
		
		Map<String, Object> res = null;
		
		String access_token = jwtUtil.createAccessToken(loginMember.getMember_id());
		log.debug("access token : {}", access_token);
			
		loginMember.setMember_pw("");	//비밀번호 감추기
			
		res = RestUtil.makeResponseTemplete("로그인 성공");
		RestUtil.setResponseData(res, "access_token", access_token);
		RestUtil.setResponseData(res, loginMember);
			
		return RestUtil.makeResponseEntity(res);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<Map<String, Object>> signin(@RequestBody MemberDto member) {
		try {
			memberService.signup(member);
		} catch (Exception e) {
			e.printStackTrace();
			return RestUtil.makeErrorResponseEntity("회원가입 실패");
		}
		
		return RestUtil.makeResponseEntity("회원가입 성공");
	}
	
	@PutMapping("/modify")
	public ResponseEntity<Map<String, Object>> modifyMember(@RequestHeader("access_token") String access_token, @RequestBody MemberDto member) {
		System.out.println(access_token);
		if(!jwtUtil.checkToken(access_token)) return RestUtil.makeResponseEntity("권한 없음", HttpStatus.UNAUTHORIZED);
		
		try {
			memberService.modifyMember(member);
		} catch (Exception e) {
			e.printStackTrace();
			return RestUtil.makeErrorResponseEntity("회원수정 실패");
		}
		return RestUtil.makeResponseEntity("회원수정 성공");
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<Map<String, Object>> removeMember(@RequestHeader("access_token") String access_token, @RequestParam("member_id") String member_id) {
		if(!jwtUtil.checkToken(access_token)) return RestUtil.makeResponseEntity("권한 없음", HttpStatus.UNAUTHORIZED);
		
		try {
			memberService.removeMember(member_id);
		} catch (Exception e) {
			return RestUtil.makeErrorResponseEntity("회원삭제 실패");
		}
		return RestUtil.makeResponseEntity("회원삭제 성공");
	}
	
	@GetMapping("/getMember")
	public ResponseEntity<Map<String, Object>> getMember(@RequestHeader("access_token") String access_token, @RequestParam("member_id") String member_id) {
		if(!jwtUtil.checkToken(access_token)) return RestUtil.makeResponseEntity("권한 없음", HttpStatus.UNAUTHORIZED);
		
		MemberDto member = null; 
		try {
			member = memberService.getMember(member_id);
		} catch (Exception e) {
			return RestUtil.makeErrorResponseEntity("회원조회 실패");
		}
		
		if(member == null) return RestUtil.makeErrorResponseEntity("회원조회 실패");

		Map<String, Object> res = RestUtil.makeResponseTemplete("회원조회 성공");
		RestUtil.setResponseData(res, member);
		
		return RestUtil.makeResponseEntity(res);
	}
	
	@GetMapping("/findPassword")
	public ResponseEntity<Map<String, Object>> findPassword(@RequestHeader("access_token") String access_token, @RequestParam("member_id") String member_id, @RequestParam("member_email") String member_email) {
		if(!jwtUtil.checkToken(access_token)) return RestUtil.makeResponseEntity("권한 없음", HttpStatus.UNAUTHORIZED);
		String password = null;
		try {
			password = memberService.findPassword(member_id, member_email);
		} catch (Exception e) {
			return RestUtil.makeErrorResponseEntity("비밀번호조회 실패");
		}
		if(password == null) return RestUtil.makeErrorResponseEntity("비밀번호조회 실패");
		
		Map<String, Object> res = RestUtil.makeResponseTemplete("비밀번호조회 성공");
		RestUtil.setResponseData(res, password);
		
		return RestUtil.makeResponseEntity(res);
	}
	
	@GetMapping("/idDuplicateCheck")
	public ResponseEntity<Map<String, Object>> isIdExist(@RequestParam("member_id") String member_id) {
		boolean isOk = false;
		try {
			isOk = memberService.isIdExist(member_id);
		} catch (Exception e) {
			e.printStackTrace();
//			return RestUtil.makeErrorResponseEntity("비밀번호조회 오류");
		}
		
		Map<String, Object> res = RestUtil.makeResponseTemplete("아이디 체크 성공");
		RestUtil.setResponseData(res, isOk);
		
		return RestUtil.makeResponseEntity(res);
	}
}

