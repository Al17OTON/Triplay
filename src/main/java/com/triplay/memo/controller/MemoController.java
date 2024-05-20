package com.triplay.memo.controller;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.triplay.memo.dto.MemoDto;
import com.triplay.memo.service.MemoService;
import com.triplay.util.RestUtil;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/memo")
@CrossOrigin(origins = {"*"}, maxAge = 60000)
@Slf4j
public class MemoController {
	
	@Autowired
	private MemoService memoService;
	
	@PostMapping("/add/{plan_id}")
	public ResponseEntity<Map<String, Object>> addMemo(@RequestHeader String access_token, @RequestBody Map<String, Object> memo, @PathVariable("plan_id") int plan_id) {
		int parent_step = (Integer)memo.get("parent_step");
		int parent_depth = (Integer)memo.get("parent_depth");
		
		MemoDto m = new MemoDto(-1, "", "", -1, -1, -1, "", -1);
		m.setComment((String)memo.get("comment"));
		m.setMember_id((String)memo.get("member_id"));
		
		try {
			if(parent_depth >= 6) throw new SQLException();
			memoService.updateOrder(plan_id, parent_step + 1);
			memoService.addMemo(plan_id, parent_step, parent_depth, m);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return RestUtil.makeErrorResponseEntity("댓글등록 실패");
		}
		
		return RestUtil.makeResponseEntity("댓글등록 성공");
	}
	
	@DeleteMapping("/delete/{memo_id}")
	public ResponseEntity<Map<String, Object>> deleteMemo(@PathVariable("memo_id") int memo_id) {
		try {
			memoService.deleteMemo(memo_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return RestUtil.makeErrorResponseEntity("댓글삭제 실패");
		}
		
		return RestUtil.makeResponseEntity("댓글삭제 성공");
	}
	
	@PutMapping("/modify")
	public ResponseEntity<Map<String, Object>> deleteMemo(@RequestBody MemoDto memo) {
		try {
			memoService.modifyMemo(memo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return RestUtil.makeErrorResponseEntity("댓글수정 실패");
		}
		
		return RestUtil.makeResponseEntity("댓글수정 성공");
	}
	
	@GetMapping("/getMemoList/{plan_id}")
	public ResponseEntity<Map<String, Object>> getMemoList(@PathVariable("plan_id") int plan_id) {
		
		List<MemoDto> list = null;
		try {
			list = memoService.getMemoList(plan_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return RestUtil.makeErrorResponseEntity("댓글조회 실패");
		}
		
//		if(list != null) Collections.sort(list);	//정렬해서 보내기 -> 클라이언트에서 하기
		
		Map<String, Object> res = RestUtil.makeResponseTemplete("댓글조회 성공");
		RestUtil.setResponseData(res, list);
		return RestUtil.makeResponseEntity(res);
	}
	
	@GetMapping("/{memo_id}")
	public ResponseEntity<Map<String, Object>> getMemo(@PathVariable("memo_id") int memo_id) {
		
		MemoDto memo = null;
		try {
			memo = memoService.getMemo(memo_id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return RestUtil.makeErrorResponseEntity("댓글조회 실패");
		}
		
		Map<String, Object> res = RestUtil.makeResponseTemplete("댓글조회 성공");
		RestUtil.setResponseData(res, memo);
		return RestUtil.makeResponseEntity(res);
	}
}
