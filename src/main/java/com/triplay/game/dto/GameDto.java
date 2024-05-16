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
    private String keyword;
    private String count;
    private String seedInfo;
}

//select s.keyword, s.count, s.seed_info, g.member_id, g.difficulty, game_title
//from seed s join game g on s.seed_id = g.seed_id;