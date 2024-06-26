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
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/list")
	public ResponseEntity<Map<String, Object>> getSeedList() throws Exception{
		List<SeedDto> seedList = sSer.getSeedList();
		Map<String, Object> res = RestUtil.makeResponseTemplete();
        RestUtil.setResponseData(res, seedList);

        return RestUtil.makeResponseEntity(res);
	}
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> checkSeedDuplicated(
			@RequestParam("seedInfo") String seedInfo,
			@RequestParam("keyword") String keyword
			) throws Exception{
		SeedDto seed = sSer.checkSeedDuplicated(seedInfo, keyword);
		System.out.println(seed);
		Map<String, Object> res = RestUtil.makeResponseTemplete();
        RestUtil.setResponseData(res, seed);
        // seed가 있으면 그 seedId 사용하고, 없으면 seedSave ~~ 
        return RestUtil.makeResponseEntity(res);
	}
}
