package com.chenyx.spring.beancycle;


import com.chenyx.spring.beancycle.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class UserServiceTest {


	@Test
	public void userServiceBean ()throws Exception{
		ApplicationContext applicationContext = SpringApplication.run();
		IUserService userService = (IUserService) applicationContext.getBean("userService");
		userService.testSay("success");
	}

}
