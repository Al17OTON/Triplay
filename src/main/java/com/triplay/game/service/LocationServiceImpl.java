package com.triplay.game.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.triplay.game.dto.GugunDto;
import com.triplay.game.dto.SidoDto;
import com.triplay.game.mapper.LocationMapper;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
    LocationMapper lMap;
	
	@Override
	public List<SidoDto> getSidoList() throws Exception {
		System.out.println(lMap.getSidoList());
		return lMap.getSidoList();
	}

	@Override
	public List<GugunDto> getGugunList(int sidoCode) throws Exception {
		System.out.println(lMap.getGugunList(sidoCode));
		return lMap.getGugunList(sidoCode);
	}

}
