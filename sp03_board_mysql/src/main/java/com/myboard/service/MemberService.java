package com.myboard.service;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.myboard.dto.MemberDTO;

public interface MemberService {
	public Map<String, Object> insert(MemberDTO dto, MultipartFile photofile);
	public Map<String, Object> update(MemberDTO dto, String oldpasswd, MultipartFile photofile);
	public Map<String, Object> delete(MemberDTO dto, String oldpasswd);
	public MemberDTO selectOne(String userid);
	public Map<String, Object> pwUpdate(MemberDTO dto, String oldpasswd);
	public int passCheck(String userid, String oldpasswd);
}
