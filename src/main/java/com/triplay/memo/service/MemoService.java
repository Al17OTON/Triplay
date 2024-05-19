package com.triplay.memo.service;

import java.util.List;

import com.triplay.memo.dto.MemoDto;

public interface MemoService {
	public void addMemo(int plan_id, int parent_step, int parent_depth, MemoDto memo) throws Exception;
	public void deleteMemo(int memo_id) throws Exception;
	public void modifyMemo(MemoDto memo) throws Exception;
	public List<MemoDto> getMemoList(int plan_id) throws Exception;
	public MemoDto getMemo(int memo_id) throws Exception;	
	public void updateOrder(int plan_id, int target_step);
}
