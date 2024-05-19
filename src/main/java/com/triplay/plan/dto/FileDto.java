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
	private String saveFolder;
	private String originalFolder;
	private String saveFile;
	
	public FileDto(String saveFolder, String originalFolder, String saveFile) {
		super();
		this.saveFolder = saveFolder;
		this.originalFolder = originalFolder;
		this.saveFile = saveFile;
	}
}
