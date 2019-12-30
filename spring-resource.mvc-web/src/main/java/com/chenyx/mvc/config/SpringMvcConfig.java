package com.chenyx.mvc.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
/**
 * @desc spring mvc 配置
 * @author chenyx
 * @date 2019-12-30
 *
 * */
@EnableWebMvc
@Component
public class SpringMvcConfig implements WebMvcConfigurer {
	/**
	 * @desc 配置请求适配器
	 * @author chenyx
	 * @date 2019-12-30
	 *
	 * */
	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters)  {
		List<MediaType> supportedMediaTypes = new ArrayList<>();
		Charset charset = Charset.forName("UTF-8");
		MediaType mediaType = new MediaType(MediaType.TEXT_HTML,charset);
		supportedMediaTypes.add(mediaType);
		//字符解析器
		StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
		stringHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
		converters.add(stringHttpMessageConverter);

		//json解析器
		FastJsonHttpMessageConverter jsonbHttpMessageConverter = new FastJsonHttpMessageConverter ();
		jsonbHttpMessageConverter.setSupportedMediaTypes(supportedMediaTypes);
		converters.add(jsonbHttpMessageConverter);
	}

	/**
	 * @desc 添加静态资源
	 * @author chenyx 、
	 * @date 2019-12-30
	 * */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("addResourceHandlers.....");
		/*classpath：路径为：/WEB-INF/路径*/
		registry.addResourceHandler("/script/**").addResourceLocations("/script/");
	}

	/**
	 * @desc 视图解析器
	 * @author chenyx
	 * @date 2019-12-30
	 * */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		System.out.println(".....configureViewResolvers ");
		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
		internalResourceViewResolver.setPrefix("/script/");//前缀
		internalResourceViewResolver.setSuffix(".html");//后缀
		registry.viewResolver(internalResourceViewResolver);
	}
}
