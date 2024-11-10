package com.itwillbs.persistence;

import java.util.List;

import com.itwillbs.domain.MemberVO;

/**
	 * 
	 * MemberDAO 인터페이스
	 * Member관련된 테이블(tbl_member)의 정보를 처리하는 객체
	 * => 상속해서 구현(추상 메서드 사용)
	 *
	 */
public interface MemberDAO {
	
	// 시간정보 죄회동작
	public String getTime();
	public String getTime2();
	
	
	// 회원가입 동작
	public void memberJoin(MemberVO vo);
	
	// 로그인 동작
	public MemberVO memberLogin(MemberVO vo);
	
	// 회원정보 조회
	public MemberVO memberList(String userid);
	
	// 회원정보 업데이트
	public void memberUpdate(MemberVO uvo);
	
	// 회원정보 삭제
	public int memberDelete(MemberVO vo);
	
	// 회원정보 리스트
	public List<MemberVO> memberList2();
	
}

