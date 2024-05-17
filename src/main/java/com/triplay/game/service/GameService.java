package com.triplay.game.service;

import java.util.List;

import com.triplay.game.dto.GameDto;

public interface GameService {

public void insertGame(GameDto gameDto) throws Exception;
	
	public List<GameDto> getGameList() throws Exception;
	
	public GameDto getGame(int gameId) throws Exception;
}
