package com.triplay.plan.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triplay.plan.dto.FileDto;
import com.triplay.plan.dto.PlanDto;
import com.triplay.plan.mapper.PlanMapper;

@Service
public class PlanServiceImpl implements PlanService{

	@Autowired
	PlanMapper pMap;
	
	@Override
	public void insertPlan(PlanDto planDto) throws Exception {
		FileDto file = planDto.getFile();
		if(file != null) {
			pMap.insertFile(file);
			planDto.setFileId(file.getFileId());
		}
		pMap.insertPlan(planDto);
	}

	@Override
	public List<PlanDto> getPlanList(Map<String, String> map) throws Exception {
		List<PlanDto> planList = pMap.getPlanList(map);
		// 여기서 file 정보까지 더한 후 return
		for (PlanDto planDto : planList) {
			if(planDto.getFileId() == 0) continue;
			FileDto file = pMap.getFile(planDto.getFileId());
			planDto.setFile(file);
		}
		System.out.println(planList);
		return planList;
	}

	@Override
	public PlanDto getPlan(int planId) throws Exception {
		PlanDto plan = pMap.getPlan(planId);
		System.out.println(plan);
		return plan;
	}

	@Override
	public void updateHit(int planId) throws Exception {
		pMap.updateHit(planId);
	}
	
	@Override
	public void insertFile(FileDto fileDto) throws Exception{
		
	}

}
