package com.itwillbs.service;

import java.util.List;

import com.itwillbs.domain.MemberVO;

public interface MemberService {

	// 실행할려는 동작 추상메서드로 구현
	
	// 회원가입
	public void memberJoin(MemberVO vo);
	
	// 로그인 체크
	public MemberVO memberLogin(MemberVO vo);
	
	// 회원정보
	public MemberVO memberlist(String id);
	
	// 회원정보 업데이트
	public void memberUpdate(MemberVO vo);
	
	// 회원정보 삭제
	public int memberDelete(MemberVO vo);
	
	// 회원정보 리스트
	public List<MemberVO> memberList();
	
}
