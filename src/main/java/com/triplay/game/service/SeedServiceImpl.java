package com.triplay.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triplay.game.dto.SeedDto;
import com.triplay.game.mapper.SeedMapper;

@Service
public class SeedServiceImpl implements SeedService {

	@Autowired
	SeedMapper sMap;
	
	@Override
	public void insertSeed(SeedDto seedDto) throws Exception {
		sMap.insertSeed(seedDto);
		System.out.println(seedDto);
	}

	@Override
	public List<SeedDto> getSeedList() throws Exception {
		return sMap.getSeedList();
	}

	@Override
	public SeedDto getSeed(int seedId) throws Exception {
		return sMap.getSeed(seedId);
	}

}
