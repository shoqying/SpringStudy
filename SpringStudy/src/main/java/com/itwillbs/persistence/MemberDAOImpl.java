package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.itwillbs.domain.MemberVO;

	/**
	 * MemberDAO인터페이스의 동작을 직접 구현
	 * => 추상메서드를 구현(오버라이딩)
	 */
//해당 DAO 객체를 스프링(root-context.xml)에 빈(객체)으로 등록
@Repository 
public class MemberDAOImpl implements MemberDAO{
	
	// mylog 단축명령어 입력
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOImpl.class);

	// SqlSessionFactory 객체 정보를 주입(root-context.xmml)
	@Inject
	private SqlSessionFactory sqlFactory;
	// SqlSession 객체 정보를 주입(root-context.xmml)
	// => 디비연결까지 처리
	@Inject
	private SqlSession sqlSession;
	
	// mapper의 이름을 상수로 저장
	private static final String NAMESPACE = "com.itwillbs.mapper.MemberMapper.";
	
	
	@Override
	public String getTime() {
		System.out.println("DAOImpl : getTime() 실행!");
		
		// 1.2 디비연결
		SqlSession sqlSession =  sqlFactory.openSession();
		// 3. SQL 작성 & pstmt 객체
		// 4. SQL 실행
		String date = sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime");
		// 5. 데이터처리(rs)
		
		return date;
	}

	@Override
	public String getTime2() {
		// 1.2 디비연결(X)
		// 3. sql 구문 & pstmt 객체
		String date2 = sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime");
		// 4. sql 실행
		// 5. 데이터처리(rs)
		return date2;
	}

	
	@Override
	public void memberJoin(MemberVO vo) {
		// li 단축 명령어
		logger.info("memberJoin(MemberVO vo) 실행");
		
		// 1.2 디비연결(X)
		// 3. sql 구문 & pstmt 객체 (X) (mapper/MyBatis 자동생성)
		// 4. sql 실행
		// SqlSession.insert("SQL구문", 전달데이터)
		sqlSession.insert("com.itwillbs.mapper.MemberMapper.insertMember", vo);
		logger.info("회원가입 성공!");
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		logger.info("memberLogin(MemberVO vo) 실행");
		
		MemberVO resultVO = sqlSession.selectOne(NAMESPACE + "loginCheck", vo);
		return resultVO;
	}

	@Override
	public MemberVO memberList(String userid) {
		logger.info("memberList() 실행");
		
		return sqlSession.selectOne(NAMESPACE + "memberList", userid);
	}

	@Override
	public void memberUpdate(MemberVO uvo) {
		logger.info("memberUpdate(MemberVO uvo) 실행");
		
		sqlSession.update(NAMESPACE + "memberUpdate", uvo);
		logger.info("회원정보 수정 완료");
		
	}

	@Override
	public int memberDelete(MemberVO vo) {
		logger.info("memberDelete(MemberVO vo) 실행");
		
		return sqlSession.delete(NAMESPACE + "memberDelete", vo);
		
	}

	@Override
	public List<MemberVO> memberList2() {
		logger.info("memberList2() 호출");
		
		return sqlSession.selectList(NAMESPACE + "memberList2");
	}
	
	
	
	
	
	
	

}
