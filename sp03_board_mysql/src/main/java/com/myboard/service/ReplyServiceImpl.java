package com.myboard.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myboard.dao.BoardDAO;
import com.myboard.dao.ReplyDAO;
import com.myboard.dto.ReplyDTO;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Resource
	private ReplyDAO rdao;
	
	@Resource
	private BoardDAO bdao;
	
	@Transactional
	@Override
	public int insert(ReplyDTO rdto) throws Exception{
		//댓글이 추가 될때 게시판의 댓글 수 +1
		bdao.replycntUp_update(rdto.getBnum());
		return rdao.insert(rdto);
	}

	@Override
	public int update(ReplyDTO rdto) throws Exception{
		// TODO Auto-generated method stub
		return rdao.update(rdto);
	}

    @Transactional
	@Override
	public int delete(int rnum,int bnum) throws Exception{
    	//댓글이 삭제 될때 게시판의 댓글 수 -1
    	bdao.replycntDown_update(bnum);
		return rdao.delete(rnum,bnum);
	}

	@Override
	public List<ReplyDTO> selectList(int bnum) throws Exception{
		return rdao.selectList(bnum);
	}

	@Override
	public ReplyDTO selectOne(int rnum) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete_bnum(int bnum) throws Exception{
		// 게시물의 댓글 삭제
		
		bdao.replycntDown_update(bnum);
		return rdao.delete_bnum(bnum);
	}

}
