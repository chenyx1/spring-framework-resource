package com.chenyx.spring.beancycle.service.impl;

import com.chenyx.spring.beancycle.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service("userService")
public class UserServiceImpl implements IUserService {
	@Override
	public void testSay(String msg) throws Exception {
		System.out.println("msg:" + msg);
	}
	@PostConstruct
	public void init() {
		System.out.println("----------IUserService init--------------");
	}
}
