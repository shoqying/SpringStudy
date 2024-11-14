package com.itwillbs.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

// 서비스 동작 : DAO 메서드 호출
@Service // 해당 객체를 서비스 객체로 등록(root-context.xml)
public class MemberServiceImpl implements MemberService {
	
	

	private static final Logger logger = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Inject
	private MemberDAO mdao;
	
	@Override
	public void memberJoin(MemberVO vo) {
		mdao.memberJoin(vo);
		
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		MemberVO resultVO = mdao.memberLogin(vo);
		
		return resultVO;
	}

	@Override
	public MemberVO memberlist(String id) {
		
		return mdao.memberList(id);
	}

	@Override
	public void memberUpdate(MemberVO vo) {
		
		mdao.memberUpdate(vo);
		
	}

	@Override
	public int memberDelete(MemberVO vo) {
		
		return mdao.memberDelete(vo);
	}
	
	@Override
	public List<MemberVO> memberList() {
		
		return mdao.memberList2();
	}
	

	
	
	
}
