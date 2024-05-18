package com.triplay.plan.service;

import java.util.List;
import java.util.Map;

import com.triplay.plan.dto.FileDto;
import com.triplay.plan.dto.PlanDto;

public interface PlanService {
	
	void insertPlan(PlanDto planDto) throws Exception;
		
	List<PlanDto> getPlanList(Map<String, String> map) throws Exception;
	
	PlanDto getPlan(int planId) throws Exception;

	void updateHit(int planId) throws Exception;
	
	void insertFile(FileDto fileDto) throws Exception;
}
