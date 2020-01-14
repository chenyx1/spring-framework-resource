package com.chenyx.mybatis.data.dao;

import com.chenyx.mybatis.Application;
import com.chenyx.mybatis.config.AspectConfig;
import com.chenyx.mybatis.data.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import static org.junit.Assert.*;

public class UserMapperTest {

	@Test
	public void selectByPrimaryKey() throws Exception {
		ApplicationContext applicationContext = Application.run(AspectConfig.class);
		UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
		User user =  userMapper.selectByPrimaryKey(1);
		System.out.print("user:" + user);
	}

}