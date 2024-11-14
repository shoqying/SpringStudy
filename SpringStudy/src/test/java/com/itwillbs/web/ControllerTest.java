package com.itwillbs.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})

public class ControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ControllerTest.class);
	
	@Inject
	private WebApplicationContext wac;
	// 해당 프로젝트 정보를 주입받아옴
	
	private MockMvc mockMvc;
	
	//@Test
//  @After //  @Test 메서드 동작 이후에 수행하는 동작 선언
	@Before // @Test 메서드 동작 이전에 수행하는 동작 선언
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		logger.info("setup() 완료");
	}
	
	@Test
	public void testDoA() {
		logger.info("testDoA() 실행");
		
		// 컨트롤러에 /doA주소 호출
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/doA"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
















