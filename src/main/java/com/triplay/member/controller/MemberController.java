package com.triplay.member.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.triplay.member.dto.LeaderBoardDto;
import com.triplay.member.dto.MemberDto;
import com.triplay.member.service.MemberService;
import com.triplay.util.JWTUtil;
import com.triplay.util.RestUtil;

import jakarta.servlet.http.HttpServletRequest;
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
	public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> loginData, HttpServletRequest request) {
		String member_id = loginData.get("member_id");
		String member_pw = loginData.get("member_pw");
		
		
		System.out.println(request.getRemoteAddr() + " - " + member_id + " " + member_pw);
		
		MemberDto loginMember = null;
		try {
			loginMember = memberService.login(member_id, member_pw);
		} catch (Exception e) {
			e.printStackTrace();
			return RestUtil.makeErrorResponseEntity("로그인 실패");
		}
		
		if(loginMember == null) return RestUtil.makeErrorResponseEntity("로그인 실패");
		
		Map<String, Object> res = null;
		
		String access_token = jwtUtil.createAccessToken(loginMember.getMember_id());
		log.debug("access token : {}", access_token);
			
		loginMember.setMember_pw("");	//비밀번호 감추기
		loginMember.setSalt("");	//비밀번호 감추기
		
		System.out.println("로그인 성공");
		res = RestUtil.makeResponseTemplete("로그인 성공");
		RestUtil.setResponseData(res, "access_token", access_token);
		RestUtil.setResponseData(res, loginMember);
			
		return RestUtil.makeResponseEntity(res);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<Map<String, Object>> signin(@RequestBody MemberDto member, HttpServletRequest request) {
		try {
			member.setSalt("test_salt_temp-signupIP:" + request.getRemoteAddr()); 	//temp salt; // TODO: make salt
			memberService.signup(member);
		} catch (Exception e) {
			e.printStackTrace();
			return RestUtil.makeErrorResponseEntity("회원가입 실패");
		}
		
		return RestUtil.makeResponseEntity("회원가입 성공");
	}
	
	@PutMapping("/modify")
	public ResponseEntity<Map<String, Object>> modifyMember(@RequestHeader("access_token") String access_token, @RequestBody MemberDto member) {
		if(!jwtUtil.checkToken(access_token, member.getMember_id())) return RestUtil.makeResponseEntity("권한 없음", HttpStatus.UNAUTHORIZED);
		
		try {
			memberService.modifyMember(member);
		} catch (Exception e) {
			e.printStackTrace();
			return RestUtil.makeErrorResponseEntity("회원수정 실패");
		}
		return RestUtil.makeResponseEntity("회원수정 성공");
	}
	
	@PutMapping("/remove")
	public ResponseEntity<Map<String, Object>> removeMember(@RequestHeader("access_token") String access_token, @RequestParam("member_id") String member_id) {
		if(!jwtUtil.checkToken(access_token, member_id)) return RestUtil.makeResponseEntity("권한 없음", HttpStatus.UNAUTHORIZED);
		
		try {
			memberService.removeMember(member_id);
		} catch (Exception e) {
			return RestUtil.makeErrorResponseEntity("회원삭제 실패");
		}
		return RestUtil.makeResponseEntity("회원삭제 성공");
	}
	
	@GetMapping("/getMember")
	public ResponseEntity<Map<String, Object>> getMember(@RequestHeader("access_token") String access_token, @RequestParam("member_id") String member_id) {
		if(!jwtUtil.checkToken(access_token, member_id)) return RestUtil.makeResponseEntity("권한 없음", HttpStatus.UNAUTHORIZED);
		
		MemberDto member = null; 
		try {
			member = memberService.getMember(member_id);
		} catch (Exception e) {
			return RestUtil.makeErrorResponseEntity("회원조회 실패");
		}
		
		if(member == null) return RestUtil.makeErrorResponseEntity("회원조회 실패");
		
		// 중요 정보 가리기 TODO : 고치기
		member.setMember_pw("");
		member.setSalt("");
		
		Map<String, Object> res = RestUtil.makeResponseTemplete("회원조회 성공");
		RestUtil.setResponseData(res, member);
		
		return RestUtil.makeResponseEntity(res);
	}
	
	@GetMapping("/findPassword")
	public ResponseEntity<Map<String, Object>> findPassword(@RequestParam("member_id") String member_id, @RequestParam("member_email") String member_email) {
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
	
	@PutMapping("/addScore")
	public ResponseEntity<Map<String, Object>> addPoint(@RequestHeader("access_token") String access_token, @RequestParam("member_id") String member_id, @RequestParam("amount") int amount) {
		if(!jwtUtil.checkToken(access_token, member_id)) return RestUtil.makeResponseEntity("권한 없음", HttpStatus.UNAUTHORIZED);
		
		try {
			memberService.addScore(member_id, amount);
		} catch (Exception e) {
			e.printStackTrace();
			return RestUtil.makeErrorResponseEntity("점수추가 실패");
		}
		
		return RestUtil.makeResponseEntity("점수추가 성공");
	}
	
	@GetMapping("/leaderBoard")
	public ResponseEntity<Map<String, Object>> getLeaderBoard() {
		int num = 10; 	//top 10 까지 가져오기
		List<LeaderBoardDto> leaderBoard = null;
		try {
			leaderBoard = memberService.getLeaderBoard(num);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return RestUtil.makeErrorResponseEntity("조회 실패");
		}
		
		if(leaderBoard == null) return RestUtil.makeErrorResponseEntity("조회 실패");
		
		Map<String, Object> res = RestUtil.makeResponseTemplete("리더보드조회 성공");
		RestUtil.setResponseData(res, leaderBoard);
		
		return RestUtil.makeResponseEntity(res);
	}
	
	@GetMapping("/leaderBoard/{member_id}")
	public ResponseEntity<Map<String, Object>> getLeaderBoard(@PathVariable("member_id") String member_id) {
		LeaderBoardDto me = null;
		try {
			me = memberService.getMyLeaderBoard(member_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return RestUtil.makeErrorResponseEntity("조회 실패");
		}
		
		if(me == null) return RestUtil.makeErrorResponseEntity("조회 실패");
		
		Map<String, Object> res = RestUtil.makeResponseTemplete("리더보드조회 성공");
		RestUtil.setResponseData(res, me);
		
		return RestUtil.makeResponseEntity(res);
	}
}

