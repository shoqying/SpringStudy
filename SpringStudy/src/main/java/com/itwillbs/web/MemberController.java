package com.itwillbs.web;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;
import com.itwillbs.service.MemberService;

@Controller
@RequestMapping(value = "/member/*") // *.me
public class MemberController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	// MemberDAO 객체 root-context.xml 주입
//	@Inject
//	private MemberDAO mdao;
	@Inject
	private MemberService mService;
	
	
	
	// http://localhost:8088/web/Memberjoin
	// http://localhost:8088/member/join
	// 회원가입 - 정보 입력 하러 가는곳 / GET 방식
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public void memberJoinGET() {
		logger.info("/member/join -> memberJoinGET() 실행");
		logger.info("주소에 맞는 view페이지 매핑(보여주기)");
	}
	
	// 회원가입 - 정보 처리 하러 가는곳 / POST 방식
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String memberJoinPOST(MemberVO vo) {
		logger.info("/member/join -> memberJoinPOST() 실행");
		
		// 전달정보 저장
		logger.info("" + vo);
		
		// MemberDAO 객체가 필요 => 주입
		// DB에 정보를 전달 - 회원가입 동작 실행
//		mdao.memberJoin(vo); // => 위험함
		mService.memberJoin(vo);
		
		
		return "redirect:/member/login";
	}
	
	// 로그인 - 정보입력 / GET
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void memberloginGET() {
		logger.info("memberloginGET() 호출");
		logger.info("/member/login.jsp 뷰페이지 연결");
	}
	
	// 로그인 - 정보입력 / POST
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String memberloginPOST(MemberVO vo, RedirectAttributes rttr, HttpSession session) {
		logger.info("memberloginPOST() 호출");
		logger.info("/member/main => /member/main.jsp 뷰페이지 연결");
		
		logger.info("" + vo);
		// 전달 정보 저장
		MemberVO resultVO = mService.memberLogin(vo);
		
		if(resultVO != null) {
			logger.info("로그인 성공");
			
			//main 페이지로 정보 전달
			rttr.addFlashAttribute("result", "loginOK");
			// 사용자의 정보(아이디) "세션"에 저장
			session.setAttribute("id", vo.getUserid());
			
			return "redirect:/member/main";
			
		} else {
			logger.info("로그인 실패");
			
			rttr.addFlashAttribute("result", "loginFail");
			return "redirect:/member/login";
		}
		
	}
	
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void mainGET() {
		logger.info("mainGET() 호출");
		logger.info("/member/main => /member/main.jsp 뷰페이지 연결");
	}
	
	
	// 로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String memberLogoutGET(HttpSession session) {
		logger.info("memberLogoutGET() 호출");
		
		// 로그아웃 처리(세션정보 초기화)
		session.invalidate();
		
		// 로그아웃 처리 후 페이지 이동
		
		return "redirect:/member/main";
	}
	
	
	// 회원정보 조회 - /member/info (GET)
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public void memberInfoGET(Model model, @SessionAttribute(name = "id") String id) {
		logger.info("memberInfoGET() 호출");
		
		// 세션에 저장된 아이디 정보를 가져오기
		logger.info("" + id);
		
		// 서비스 -> DAO 호출(회원정보 조회)
		MemberVO result = mService.memberlist(id);
		
		// 결과정보를 저장 view페이지 전달 & 출력 (model 객체)
		model.addAttribute("result", result);
		
		
		logger.info("/member/info => /member/info.jsp 뷰페이지 연결");
	}
	
	// 회원정보 수정 - /member/update - GET(기존 정보를 가져와서 보여주고, 수정할 정보 입력
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public void memberUpdateGET(@SessionAttribute("id") String id,
			                    Model model) {
		logger.info("memberUpdateGET() 호출");
		
		// 사용자의 ID정보를 가져오기(세션)
		logger.info("id : " + id);
		
		// 서비스 -> DAO 회원정보 가져오는 동작 호출
		MemberVO result = mService.memberlist(id);
		
		// 연결된 뷰페이지에 출력
		// => model 객체에 정보 저장
		model.addAttribute("result", result);
		// /member/update.jsp 뷰페이지 연결
	}
	
	
	// 회원정보 수정 - /member/update - POST(수정된 정보를 전달받아서 정보 수정)
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String memberUpdatePOST(MemberVO vo) {
		logger.info("memberUpdatePOST() 호출");
		
		// 전달정보(수정정보) 저장
		logger.info("name : " + vo.getUsername());
		
		// 서비스 -> DAO 호출 (회원정보 수정)
		mService.memberUpdate(vo);
		
		
		
			return "redirect:/member/main";
		}
	
	
	// 회원정보 삭제 - /member/delete - GET(기존 정보를 가져와서 보여주고, 삭제 정보 입력
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void memberDeleteGET() {
		logger.info("memberDeleteGET() 호출");
		
	}
		
		
	// 회원정보 수정 - /member/delete - POST(수정된 정보를 전달받아서 정보 삭제)
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String memberDeletePOST(HttpSession session, MemberVO vo) {
		logger.info("memberDeletePOST() 호출");
		
		// 전달정보(수정정보) 저장
		logger.info("name : " + vo.getUsername());
		
		// 서비스 -> DAO 호출 (회원정보 수정)
		int result = mService.memberDelete(vo);
		
		if(result == 0) {
			return "redirect:/member/delete";
		} 
		
		session.invalidate();
		return "redirect:/member/main";			
	}
	
	// 회원정보 리스트 - /member/list - GET
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String memberListGET(Model model) {
		logger.info("memberListGET() 호출");
		
		// 서비스 -> DAO (회원 리스트 가져오기 동작)
		List<MemberVO> memberList = mService.memberList();
		logger.info("회원수 : " + memberList.size());
		
		// 뷰페이지에 정보 전달(model)
		model.addAttribute("memberList", memberList); 
		
		return "/member/list";
	}
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
