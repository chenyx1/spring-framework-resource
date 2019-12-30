package com.chenyx.mvc;

import com.chenyx.mvc.config.AspectConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @desc web容器启动自动扫描的启动的类
 *        servlet3.0规范
 *@author chenyx
 * @date 2019-12-30
 *
 * */
public class SpringMvcApplicationInitializer implements WebApplicationInitializer {

	/**
	 * @desc spring-mvc 项目启动类
	 *       在spring 和web容器 遵循servlet3.0规范
	 *       在容器启动时，容器会读取 META-INF\services\javax.servlet.ServletContainerInitializer文件
	 *       通过扫描和调用该类SpringServletContainerInitializer启动web程序
	 *       扫描@HandlesTypes(WebApplicationInitializer.class)---->WebApplicationInitializer接口，
	 *       最后循环调用WebApplicationInitializer的onStartup方法
	 * @author chenyx
	 * @date 2019-12-30
	 * */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(AspectConfig.class);//注入扫描配置
		//applicationContext.refresh();武器此处进行springbean的声明周期管理，后续再dispatchServlet中会进行bean的生命周期管理
		DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);
		//注入dispatchServlet
		ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("/",dispatcherServlet);
		servletRegistration.setLoadOnStartup(1);
		servletRegistration.addMapping("/**");
	}
}
