package com.chenyx.mybatis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @deac spring-resource-mybatis启动类
 * @author chenyx
 * @date 2020-01-08
 * */
public class Application {

	/**
	 * @desc 启动方法
	 * @author chenyx
	 * @date 2020-01-08
	 * */
	public static ApplicationContext run(Class clazz) {
		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(clazz);
		return  annotationConfigApplicationContext;
	}
}
