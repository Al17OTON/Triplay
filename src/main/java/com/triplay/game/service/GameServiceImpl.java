package com.triplay.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triplay.game.dto.GameDto;
import com.triplay.game.mapper.GameMapper;

@Service
public class GameServiceImpl implements GameService {

	@Autowired
	GameMapper gMap;
	
	@Override
	public void insertGame(GameDto gameDto) throws Exception {
		gMap.insertGame(gameDto);
	}

	@Override
	public List<GameDto> getGameList() throws Exception {
		return gMap.getGameList();
	}

	@Override
	public GameDto getGame(int gameId) throws Exception {
		// TODO Auto-generated method stub
		return gMap.getGame(gameId);
	}

}
