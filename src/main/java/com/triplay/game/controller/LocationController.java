package com.triplay.game.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.triplay.game.dto.GugunDto;
import com.triplay.game.dto.SidoDto;
import com.triplay.game.service.LocationService;
import com.triplay.util.RestUtil;

@RestController
@CrossOrigin(origins = "*") // http://127.0.0.1:5173
@RequestMapping("/location") 
public class LocationController {
	
	@Autowired
	LocationService lSer;
	
	@GetMapping("sido")
	public ResponseEntity<Map<String, Object>> getSido() throws Exception {
		List<SidoDto> sidoList = lSer.getSidoList();
		Map<String, Object> res = RestUtil.makeResponseTemplete();
        RestUtil.setResponseData(res, sidoList);

        return RestUtil.makeResponseEntity(res);
	}
	
	@GetMapping("gugun")
	public ResponseEntity<Map<String, Object>> getGugun(
			@RequestParam int sidoCode) throws Exception {
		List<GugunDto> gugunList = lSer.getGugunList(sidoCode);
		Map<String, Object> res = RestUtil.makeResponseTemplete();
        RestUtil.setResponseData(res, gugunList);

        return RestUtil.makeResponseEntity(res);
	}
}
