package com.myboard.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService {
	
	//������丮
	//servlet-context.xml���� bean����=>�ڵ� ����
	@Resource
	String saveDir;
	
	@Override
	public String fileUpload(MultipartFile file) {
		//���� �̸�
		String filename = null;
		try {
			//������ ��ȣ ����
			filename = System.currentTimeMillis() + file.getOriginalFilename();
			//
			File f = new File(saveDir, filename);
			System.out.println(saveDir+ " " + filename);
			file.transferTo(f);
		} catch (IllegalStateException e) {
			filename = null;
			e.printStackTrace();
		} catch (IOException e) {
			filename = null;
			e.printStackTrace();
		}
		
		return filename;
	}

}
