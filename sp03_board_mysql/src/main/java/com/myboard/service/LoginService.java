package com.myboard.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myboard.dao.MemberDAO;
import com.myboard.dto.MemberDTO;

@Service
public class LoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
	
	@Resource
	private MemberDAO dao;
	@Resource
	private BCryptPasswordEncoder encode;
	
	public Map<String, Object> loginCheck(String userid, String passwd) {
		//result : 0(로그인성공), 1(아이디미존재), 2(패스워드불일치)
		logger.debug(userid);
		String msg = null;
		int result = -1;
		MemberDTO mdto = dao.selectOne(userid);
		System.out.println(mdto);
		if (mdto == null) { //아이디 없음
			msg = "아이디가 없습니다.";
			result = 1;
		}else {
			//평문을 암호화시킨 값과 db에 저장된 암호문과 비교
			if (encode.matches(passwd, mdto.getPasswd())) {
				msg = "로그인 성공";
				result = 0;
			}else {
				msg = "패스워드가 불일치";
				result = 2;
			}
		}
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("msg", msg);
		resultMap.put("result", result);
		return resultMap;
		
	}
}
