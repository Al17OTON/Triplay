package com.triplay.game.service;

import java.util.List;

import com.triplay.game.dto.SeedDto;

public interface SeedService {

	public void insertSeed(SeedDto seedDto) throws Exception;
	
	public List<SeedDto> getSeedList() throws Exception;
	
	public SeedDto getSeed(int seedId) throws Exception;
}
