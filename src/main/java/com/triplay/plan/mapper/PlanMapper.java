package com.triplay.plan.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.triplay.plan.dto.FileDto;
import com.triplay.plan.dto.PlanDto;

@Mapper
public interface PlanMapper {

	// 여행 계획 작성
	void insertPlan(PlanDto planDto) throws Exception;
		
	// 여행 계획 리스트 -> 페이지네이션
	List<PlanDto> getPlanList(Map<String, String> map) throws Exception;
	
	// 여행 계획 조회
	PlanDto getPlan(int planId) throws Exception;

	void updateHit(int planId) throws Exception;

	FileDto getFile(int fileId) throws Exception;
	
	void insertFile(FileDto fileDto) throws Exception;
	
	// 수정 및 삭제
}
