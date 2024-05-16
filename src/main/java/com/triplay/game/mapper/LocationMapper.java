package com.triplay.game.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.triplay.game.dto.GugunDto;
import com.triplay.game.dto.SidoDto;

@Mapper
public interface LocationMapper {

	public List<SidoDto> getSidoList() throws Exception;

	public List<GugunDto> getGugunList(int sidoCode) throws Exception;
}
