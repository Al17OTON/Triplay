package com.triplay.plan.dto;

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
public class PlanDto {
	private int planId;
    private int seedId;
    private String memberId;
    private String planTitle;
    private String planContent;
    private String estimateTime;
    private String distance;
    private int hit;
    private String registerTime;
    
    // seed 값
    private String keyword;
    private String seedInfo;

    // 이미지 관련
    private int fileId; // 파일을 띄우기위한 값으로 가져오기 일단 아이디로 넣어둠
    private FileDto file;
}
