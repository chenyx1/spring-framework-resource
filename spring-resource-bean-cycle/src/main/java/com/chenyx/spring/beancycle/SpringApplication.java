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

	/**
	 * @desc 自定义是否需要循环依赖
	 * @author chenyx
	 * @date 2019-12-28
	 *
	 * */
	public static ApplicationContext run(boolean allowEarlyReference) throws Exception {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
		applicationContext.setAllowCircularReferences(allowEarlyReference);
		applicationContext.register(ApsectConfig.class);
		applicationContext.refresh();
		return applicationContext;
	}
}
