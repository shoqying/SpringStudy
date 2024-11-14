package com.itwillbs.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController5 {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController5.class);
	
//	http://localhost:8088/web/doE?msg=itwill
	@RequestMapping(value = "/doE", method = RequestMethod.GET)
//	@GetMapping
	public String doE(RedirectAttributes rttr/*@ModelAttribute("msg") String msg*/) {
		logger.info("doE() 실행");
//		return "redirect:/doF"; // sendRedirect() 방식으로 이동 - 주소변경
//		return "forward:/doF"; // forward() 방식으로 이동 - 주소가 변경 X

//		rttr.addAttribute("msg", "itwill");
		// => 데이터를 URI에 표시, 새로고침시 데이터 유지
		rttr.addFlashAttribute("msg", "itwillbusan");
		// => 데이터를 URI에 표시 X, 새로고침시 데이터 유지 X (반드시 redirect 이동시 사용가능)
		
		return "redirect:/doF";
	}
	
//	http://localhost:8088/web/doF
	@RequestMapping(value = "/doF", method = RequestMethod.GET)
//	@GetMapping
	public String doF(@ModelAttribute("msg") String msg) {
		logger.info("doF() 실행");
		return "/doF";
	}

}
