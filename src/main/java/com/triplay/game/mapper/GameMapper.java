package com.triplay.game.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.triplay.game.dto.GameDto;

@Mapper
public interface GameMapper {

	public void insertGame(GameDto gameDto) throws Exception;
	
	public List<GameDto> getGameList() throws Exception;
	
	public GameDto getGame(int gameId) throws Exception;
}
