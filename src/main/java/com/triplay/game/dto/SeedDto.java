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
public class SeedDto {
	private int seedId;
    private String keyword;
    private int count;
    private String seedInfo;
}