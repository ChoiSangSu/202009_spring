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
	
	//저장디렉토리
	//servlet-context.xml에서 bean생성=>자동 주입
	@Resource
	String saveDir;
	
	@Override
	public String fileUpload(MultipartFile file) {
		//파일 이름
		String filename = null;
		try {
			//유일한 번호 생성
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
