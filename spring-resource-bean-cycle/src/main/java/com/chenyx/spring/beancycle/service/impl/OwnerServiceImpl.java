package com.chenyx.spring.beancycle.service.impl;

import com.chenyx.spring.beancycle.service.IOwnerService;

public class OwnerServiceImpl implements IOwnerService {
	@Override
	public void say() throws Exception {
		System.out.println("OwnerServiceImpl say....");
	}
}
