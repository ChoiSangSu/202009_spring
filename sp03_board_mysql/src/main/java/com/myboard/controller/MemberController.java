package com.myboard.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myboard.dto.MemberDTO;
import com.myboard.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Resource
	private MemberService service;
	
	//ȸ��������(join.jsp)���� �̵�
	@RequestMapping(value="/join", method = RequestMethod.GET)
	public String join(HttpServletRequest request) {
		logger.info(request.getServletContext().getRealPath("/"));
		return "member/join";
	}
	
	//ȸ������ db�� ������ login.jsp�� �̵�
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(MemberDTO dto, MultipartFile photofile,RedirectAttributes rattr) {
		logger.info(dto.toString());
		logger.info(photofile.toString());
		//ȸ������ ���� ó��
		Map<String, Object> resultMap = service.insert(dto, photofile);
		rattr.addFlashAttribute("msg", resultMap.get("msg"));
		
		if ((int)resultMap.get("result") == 0) { //ȸ������ ����
			return "redirect:/login/";
		}else {  //ȸ������ ����
			return "redirect:/member/join";
		}
		
	}
	
	//ȸ�����������̱�
	@RequestMapping(value="/modify", method = RequestMethod.GET)
	public String modify(HttpSession session, Model model) {
		MemberDTO dto = service.selectOne((String)session.getAttribute("userid"));
		model.addAttribute("dto", dto);
		return "member/modify";
	}
	
	//ȸ�������ϱ�
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public String modify(MemberDTO dto,String oldpasswd,
			MultipartFile photofile, Model model) {
		Map<String, Object> resultMap = service.update(dto, oldpasswd, photofile);
		//��������������� ����ؼ� ȸ������ �ٽ� ��ȸ
		MemberDTO rdto = service.selectOne(dto.getUserid());
		model.addAttribute("dto", rdto);
		model.addAttribute("msg", resultMap.get("msg"));
		
		return "member/modify";
	}

	//ȸ�� �����ϱ�
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public String delete(@ModelAttribute("dto") MemberDTO dto,String oldpasswd, 
			RedirectAttributes rattr, Model model) {
		Map<String, Object> resultMap = service.delete(dto, oldpasswd);
		
		if ((int)resultMap.get("result") == 0) { //���� ������ 
			rattr.addFlashAttribute("msg",resultMap.get("msg")); 
			return "redirect:/login/";			
		}else { //�������н�
			model.addAttribute("msg", resultMap.get("msg"));
			return "member/modify";			
		}
		

	}	
	
	//��й�ȣ ����
	@RequestMapping("/pwUpdate")
	public String pwUpdate(@ModelAttribute("dto") MemberDTO dto,
			String oldpasswd, Model model) {
		//dto : �������̵� + ���ο� �н�����
		//oldpasswd : �����н�����
		Map<String, Object> resultMap = service.pwUpdate(dto,oldpasswd);
		
		logger.info(String.valueOf(resultMap));
		model.addAttribute("msg",resultMap.get("msg"));
		return "member/modify";
	}
	
	
	
	
	
}
