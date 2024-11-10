package com.itwillbs.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDAOTest {

	// MemberDAO - getTime() 메서드 실행(테스트)
	
	// 로거 객체 생성
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOTest.class);
	
	// MemberDAO 객체가 필요하다 => MemberDAO 객체를 의존하고 있다
	@Inject
	private MemberDAO mdao; // = new MemberDAOImpl();
	
	//@Test
	public void daoTest() {
		System.out.println(mdao);
		// dao 객체가 있는지 체크
	}
	//@Test
	public void getTimeTest() {
		System.out.println("---------------------------------");
		String date = mdao.getTime();
		logger.info(date);
		String date2 = mdao.getTime2();
		logger.info(date2);
		System.out.println("---------------------------------");
		logger.info("안녕하세요");
	}
	
	
	// 회원가입 테스트
	//@Test
	public void memberJoinTest() {
		// MemberDAO 객체에 필요한 회원가입 동작 작성
		MemberVO vo = new MemberVO();
		vo.setUserid("admin2");
		vo.setUserpw("1234");
		vo.setUsername("어드민2");
		vo.setUseremail("admin2@admin.com");
		mdao.memberJoin(vo);
		logger.info("회원가입 테스트 완료");
	}
	
	//@Test
	public void loginTest() {
		logger.info("로그인 테스트");
		MemberVO vo = new MemberVO();
		vo.setUserid("admin");
		vo.setUserpw("1234");
		
		MemberVO resultVO = mdao.memberLogin(vo);
		
		if(resultVO != null) {
			logger.info("로그인 성공");
		} else {
			logger.info("로그인 실패");
		}
	}
	
	//@Test
	public void memberListTest() {
		logger.info("회원 정보 조회");
		MemberVO vo = mdao.memberList("admin");
		
		logger.info(vo+"");
	}
	
	//@Test
	public void memberUpdate() {
		MemberVO uvo = new MemberVO();
		uvo.setUserid("admin");
		uvo.setUserpw("1234");
		uvo.setUsername("어드민수정");
		mdao.memberUpdate(uvo);
		logger.info("회원정보 수정 완료");
		logger.info(uvo+"");
		
	}
	
	//@Test
	public void memberDeleteTest() {
		MemberVO vo = new MemberVO();
		vo.setUserid("admin");
		vo.setUserpw("1234");
		
		int result = mdao.memberDelete(vo);
		
		if(result >= 1) {
			logger.info("회원정보 삭제 완료");
		} else {
			logger.info("회원정보 삭제 실패");
		}
	}
	
	@Test
	public void memberList2Test() {
		List<MemberVO> memberList = mdao.memberList2();
		logger.info("@@@@@@@@@@@@@@@@"+memberList);
	}
	
	
}
