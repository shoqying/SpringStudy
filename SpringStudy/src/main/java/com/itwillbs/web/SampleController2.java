package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController2 {

	
	private static final Logger logger = LoggerFactory.getLogger(SampleController2.class);
	
	
	// doB 주소로 실행되는 메서드 doB()
	// http://localhost:8088/web/doB
	@RequestMapping(value = "/doB", method = RequestMethod.GET)
	public String doB() {
		logger.info("doB() 실행");
		
		// 매핑된 메서드의 리턴타입이 String일때
		// 리턴문자.jsp 뷰페이지 연결
		return "itwill";
	}
	
	// doB 주소로 실행되는 메서드 doB()
	// http://localhost:8088/web/doB1
		@RequestMapping(value = "/doB1", method = RequestMethod.GET)
		public int doB1() {
			logger.info("doB1() 실행");
			
			// 매핑된 메서드의 리턴타입이 void, String 아닌경우
			// 실행불가(but, 나중에(REST방식) 사용가능해짐)
			return 1000;
		}
}
