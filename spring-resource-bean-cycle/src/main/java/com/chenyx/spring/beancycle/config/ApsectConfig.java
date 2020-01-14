package com.chenyx.spring.beancycle.config;

import com.chenyx.spring.beancycle.service.IOwnerService;
import com.chenyx.spring.beancycle.service.impl.OwnerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @desc spring零配置实现
 * @author chenyx
 * @date 2019-12-27
 * */
@ComponentScan("com.chenyx.spring.beancycle")
@Configuration
public class ApsectConfig {

	@Bean
	public IOwnerService ownerService(){
		IOwnerService ownerService  = new OwnerServiceImpl();
		return ownerService;
	}
}
