package com.myboard.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
	//���� �����ϰ� ���ϸ��� ����
	public String fileUpload(MultipartFile file);
}
