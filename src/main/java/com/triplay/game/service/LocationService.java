package com.triplay.game.service;

import java.util.List;

import com.triplay.game.dto.GugunDto;
import com.triplay.game.dto.SidoDto;

public interface LocationService {
	
	public List<SidoDto> getSidoList() throws Exception;

	public List<GugunDto> getGugunList(int sidoCode) throws Exception;
}
