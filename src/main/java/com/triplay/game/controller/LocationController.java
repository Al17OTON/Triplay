package com.triplay.game.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.triplay.game.dto.GugunDto;
import com.triplay.game.dto.SidoDto;
import com.triplay.game.service.LocationService;

@RestController
@CrossOrigin(origins = "*") // http://127.0.0.1:5173
@RequestMapping("/location") 
public class LocationController {
	
	@Autowired
	LocationService lSer;
	
	@GetMapping("sido")
	public ResponseEntity<Map<String, Object>> getSido() throws Exception {
		Map<String, Object> map = new HashMap<>();
		ResponseEntity<Map<String, Object>> response; 
		
		List<SidoDto> sidoList = lSer.getSidoList();
		map.put("data", sidoList);
		map.put("message", null);
		
		response = new ResponseEntity<>(map, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("gugun")
	public ResponseEntity<Map<String, Object>> getGugun(
			@RequestParam int sidoCode) throws Exception {
		Map<String, Object> map = new HashMap<>();
		ResponseEntity<Map<String, Object>> response; 
		
		System.out.println(sidoCode);
		List<GugunDto> gugunList = lSer.getGugunList(sidoCode);

		map.put("data", gugunList);
		map.put("message", null);
		
		response = new ResponseEntity<>(map, HttpStatus.OK);
		return response;
	}
}
