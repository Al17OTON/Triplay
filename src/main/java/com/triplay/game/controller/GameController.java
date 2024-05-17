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

import com.triplay.game.dto.GameDto;
import com.triplay.game.service.GameService;
import com.triplay.util.RestUtil;

@RestController
@CrossOrigin(origins = "*") // http://127.0.0.1:5173
@RequestMapping("/game") 
public class GameController {

	@Autowired
	GameService gSer;
	
	@PostMapping
	public ResponseEntity<Map<String, Object>> insertGame(
			@RequestBody GameDto gameDto) throws Exception{
		gSer.insertGame(gameDto);
		return RestUtil.makeResponseEntity("게임 저장 성공");
	}
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> getGameList() throws Exception{
		List<GameDto> gameList = gSer.getGameList();
		Map<String, Object> res = RestUtil.makeResponseTemplete("");
        RestUtil.setResponseData(res, gameList);

        return RestUtil.makeResponseEntity(res);
	}
	
	@GetMapping("/{gameId}")
	public ResponseEntity<Map<String, Object>> getGame(
			@PathVariable("gameId") int gameId) throws Exception{
		GameDto game = gSer.getGame(gameId);
		Map<String, Object> res = RestUtil.makeResponseTemplete();
        RestUtil.setResponseData(res, game);

        return RestUtil.makeResponseEntity(res);
	}
	
}
