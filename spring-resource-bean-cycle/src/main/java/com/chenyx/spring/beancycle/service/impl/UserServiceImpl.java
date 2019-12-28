package com.chenyx.spring.beancycle.service.impl;

import com.chenyx.spring.beancycle.service.IOtherService;
import com.chenyx.spring.beancycle.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Autowired
	private IOtherService otherService;
	@Override
	public void testSay(String msg) throws Exception {
		System.out.println("msg:" + msg);
	}

	@Override
	public void testOther() throws Exception {
		otherService.testOther();
	}

	@PostConstruct
	public void init() {
		System.out.println("----------IUserService init--------------");
	}
}
