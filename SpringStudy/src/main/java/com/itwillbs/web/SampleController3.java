package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController3 {
	
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController3.class);
	
	// http://localhost:8088/web/doC?msg=Hello
	@RequestMapping(value = "/doC", method = RequestMethod.GET)
	public String doC(@ModelAttribute("msg") String msg) {
		// (@ModelAttribute("저장할 데이터명") 데이터를 저장하는 변수)
		// => 주소줄에 있는 데이터(파라메터)를 저장
		logger.info("doC() 실행");
//		logger.info("msg : " + request); request 객체 X/ el표현식 X
		// 컨트롤러 -> JSP로 정보 전달
		logger.info("msg : " + msg);
		
		
		return "doC";
	}
	
	// http://localhost:8088/web/doC?id=Hello&pw=itwill
	@RequestMapping(value = "/doC1", method = RequestMethod.GET)
	public String doC1(@ModelAttribute("id") String id, 
					   @ModelAttribute("pw") String pw) {
		
		logger.info("doC1() 실행");
		logger.info("id : " + id);
		logger.info("pw : " + pw);

		
		return "doC";
	}

}
