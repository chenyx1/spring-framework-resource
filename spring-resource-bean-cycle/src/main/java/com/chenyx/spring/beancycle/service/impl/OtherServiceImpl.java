package com.chenyx.spring.beancycle.service.impl;

import com.chenyx.spring.beancycle.service.IOtherService;
import com.chenyx.spring.beancycle.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("otherService")
public class OtherServiceImpl implements IOtherService {
	@Autowired
	private IUserService userService;

	@Override
	public void testOther() throws Exception {
		System.out.println("-----------testOther--------------");
	}

	@Override
	public void testUser() throws Exception {
		userService.testSay("hello UserService");
	}
}
