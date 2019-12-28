package com.chenyx.spring.beancycle;

import com.chenyx.spring.beancycle.config.ApsectConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @desc 程序启动
 * @author chenyx
 * @date 2019-12-27
 * */
public class SpringApplication {
	public static ApplicationContext run() throws Exception {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(ApsectConfig.class);
		return  annotationConfigApplicationContext;
	}
}
