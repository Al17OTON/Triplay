package com.triplay.game.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.triplay.game.dto.SeedDto;

@Mapper
public interface SeedMapper {

	// seed 저장
	public void insertSeed(SeedDto seedDto) throws Exception;
	
	// seed 리스트
	public List<SeedDto> getSeedList() throws Exception;
	
	// seed 1개 select
	public SeedDto getSeed(int seedId) throws Exception;
}
