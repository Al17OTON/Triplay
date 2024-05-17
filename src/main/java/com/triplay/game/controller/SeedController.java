package com.triplay.game.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.triplay.game.dto.SeedDto;
import com.triplay.game.service.SeedService;
import com.triplay.util.RestUtil;

@RestController
@CrossOrigin(origins = "*") // http://127.0.0.1:5173
@RequestMapping("/seed") 
public class SeedController {

	// 게임 저장
	// 게임 리스트
	// 게임 select
	@Autowired
	SeedService sSer;
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> insertSeed(
			@RequestBody SeedDto seedDto) throws Exception{
		sSer.insertSeed(seedDto);
		System.out.println(seedDto);
		Map<String, Object> res = RestUtil.makeResponseTemplete("시드 저장 성공");
        RestUtil.setResponseData(res, seedDto.getSeedId());

        return RestUtil.makeResponseEntity(res);
	}
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> getSeedList() throws Exception{
		List<SeedDto> seedList = sSer.getSeedList();
		Map<String, Object> res = RestUtil.makeResponseTemplete();
        RestUtil.setResponseData(res, seedList);

        return RestUtil.makeResponseEntity(res);
	}
	
	@GetMapping("/{seedId}")
	public ResponseEntity<Map<String, Object>> getSeed(
			@PathVariable("seedId") int seedId) throws Exception{
		SeedDto seed = sSer.getSeed(seedId);
		Map<String, Object> res = RestUtil.makeResponseTemplete();
        RestUtil.setResponseData(res, seed);

        return RestUtil.makeResponseEntity(res);
	}
}
