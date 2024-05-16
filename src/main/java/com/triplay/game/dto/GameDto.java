package com.triplay.game.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class GameDto {
	private int gameId;
    private int seedId;
    private String memberId;
    private String difficulty;
    private String gameTitle;
}
