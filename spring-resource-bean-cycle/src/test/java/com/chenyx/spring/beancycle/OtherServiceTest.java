package com.chenyx.spring.beancycle;

import com.chenyx.spring.beancycle.service.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

public class OtherServiceTest {

	/***
	 * @desc 循环依赖校验
	 * @author chenyx
	 * @date 2019-12-28
	 *
	 * */
	@Test
	public void testUser()throws Exception{
		boolean allowEarlyReference = true;
		ApplicationContext applicationContext = SpringApplication.run(allowEarlyReference);
		IUserService userService = (IUserService) applicationContext.getBean("userService");
		userService.testOther();
	}
}
