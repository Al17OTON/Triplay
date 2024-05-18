package com.triplay.plan.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.triplay.plan.dto.FileDto;
import com.triplay.plan.dto.PlanDto;
import com.triplay.plan.service.PlanService;
import com.triplay.util.RestUtil;

@RestController
@CrossOrigin(origins = "*") // http://127.0.0.1:5173
@RequestMapping("/plan") 
public class PlanController {

	@Autowired
	PlanService pSer;
	
	// 여행 계획 작성
	@PostMapping
	public ResponseEntity<Map<String, Object>> insertPlan(
			@RequestBody PlanDto planDto,
			MultipartFile file) throws Exception{
		System.out.println(planDto);
		System.out.println(file);
//		pSer.insertPlan(planDto);
		return RestUtil.makeResponseEntity("계획 저장 성공");
	}
		
	// 여행 계획 리스트 -> 페이지네이션
	@GetMapping
	public ResponseEntity<Map<String, Object>> getPlanList() throws Exception{
		Map<String, String> map = new HashMap<>();
		List<PlanDto> planList = pSer.getPlanList(map);
		
		Map<String, Object> res = RestUtil.makeResponseTemplete("여행 계획 리스트 조회 성공");
        RestUtil.setResponseData(res, planList);

        return RestUtil.makeResponseEntity(res);
	}
	
	// 여행 계획 조회
	@GetMapping("/{planId}")
	public ResponseEntity<Map<String, Object>> getPlan(
			@PathVariable("planId") int planId) throws Exception{
		PlanDto plan = pSer.getPlan(planId);
		Map<String, Object> res = RestUtil.makeResponseTemplete("여행 계획 조회 성공");
        RestUtil.setResponseData(res, plan);

        return RestUtil.makeResponseEntity(res);
	}

	@PutMapping("/hit/{planId}")
	public ResponseEntity<Map<String, Object>> updateHit(
			@PathVariable int planId) throws Exception{
		pSer.updateHit(planId);
		return RestUtil.makeResponseEntity("조회수 갱신");
	}
	
	@PostMapping("/file")
	public ResponseEntity<Map<String, Object>> insertFile(
			@RequestBody FileDto fileDto) throws Exception{
		pSer.insertFile(fileDto);
		return RestUtil.makeResponseEntity("이미지 업로드 성공");
	}
}
