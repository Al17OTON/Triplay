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
public class FileDto {
	private int fileId;
	private String save_folder;
	private String original_folder;
	private String save_file;
}
