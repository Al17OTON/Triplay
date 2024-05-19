package com.triplay.memo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triplay.memo.dto.MemoDto;
import com.triplay.memo.mapper.MemoMapper;

@Service
public class MemoServiceImpl implements MemoService{
	
	@Autowired
	private MemoMapper memoMapper;
	
	@Override
	public void addMemo(int plan_id, int parent_step, int parent_depth, MemoDto memo) throws Exception {
		memoMapper.addMemo(plan_id, parent_step, parent_depth, memo);
	}

	@Override
	public void deleteMemo(int memo_id) throws Exception {
		memoMapper.deleteMemo(memo_id);
	}

	@Override
	public void modifyMemo(MemoDto memo) throws Exception {
		memoMapper.modifyMemo(memo);
	}

	@Override
	public List<MemoDto> getMemoList(int plan_id) throws Exception {
		return memoMapper.getMemoList(plan_id);
	}

	@Override
	public MemoDto getMemo(int memo_id) throws Exception {
		return memoMapper.getMemo(memo_id);
	}

	@Override
	public void updateOrder(int plan_id, int target_step) {
		memoMapper.updateOrder(plan_id, target_step);
	}

}
