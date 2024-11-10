package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwillbs.domain.MemberVO;

@Controller
public class SampleController4 {
	
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController4.class);
	
	
	// http://localhost:8088/web/doD?userid=admin&userpw=1234&msg=아이티월
	// @RequestMapping(value = "/doD", method = RequestMethod.GET)
	@GetMapping(value = "/doD") // 알아서 GET POST 방식을 연결해준다 4.3버전 이후로
	public void doD(/*@ModelAttribute*/ MemberVO vo,
					 @ModelAttribute("msg") String msg) {
		
		logger.info("doD() 실행");
		
		
		///*@ModelAttribute*/ MemberVO vo
		// => 1) 파라메터 정보를 저장
		// => 2) 전달된 정보를 객체(Model)에 저장
		
		
		logger.info("객체를 사용해서 정보 전달");
		// 파라메터 정보를 자동 수집 가능
		// 해당 객체가 포함된 파라메터정보라면 자동으로 객체에 정보 저장
		logger.info(vo+"");
		
		logger.info("view연결 -> doD.jsp 실행");
		
	}
	
	
	// http://localhost:8088/web/doD1?
	@RequestMapping(value = "/doD1", method = RequestMethod.GET)
	public String doD1(Model model) { // 컨트롤러의 정보를 뷰페이지로 전달하는 객체
		
		logger.info("doD1() 실행");
		
		MemberVO vo = new MemberVO();
		vo.setUserid("DBID");
		vo.setUserpw("DB1234");
		vo.setUsername("DBNAME");
		
		// model 객체에 정보 저장
		model.addAttribute(vo);
		
		
		logger.info("view연결 -> doD.jsp 실행");
		
		return "doD";
	}
	
	// http://localhost:8088/web/doD2?userid=admin&userpw=1234
	@RequestMapping(value = "/doD2", method = RequestMethod.GET)
	public String doD2(MemberVO urlvo, Model model) { // 컨트롤러의 정보를 뷰페이지로 전달하는 객체
		
		logger.info("doD1() 실행");
		
		MemberVO vo = new MemberVO();
		vo.setUserid("DBID");
		vo.setUserpw("DB1234");
		// => 모델객체를 생성 전달(이름 X)
		model.addAttribute(vo);
		
		logger.info(""+urlvo);
		
		
		logger.info("view연결 -> doD.jsp 실행");
		
		return "doD";
	}

	
	

}
