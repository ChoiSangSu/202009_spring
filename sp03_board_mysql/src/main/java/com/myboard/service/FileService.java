package com.myboard.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	//파일 저장하고 파일명을 리턴
	public String fileUpload(MultipartFile file);
}
