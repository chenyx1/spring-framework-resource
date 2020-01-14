package com.chenyx.mybatis.config;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @desc spring环境配置
 * @author chenyx
 * @date 2020-01-08
 * */
@Configuration
@ComponentScan("com.chenyx.mybatis")
@MapperScan("com.chenyx.mybatis.data.dao")
public class AspectConfig {

	/**
	 * @desc 注入DataSource
	 * @author chenyx
	 * @date 2020-01-08
	 *
	 *
	 * */
	@Bean
	public DataSource dataSource () {
		PooledDataSource dataSource = new PooledDataSource();
		dataSource.setDriver("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/study");
		dataSource.setUsername("root");
		dataSource.setPassword("xiaopei");
		return dataSource;
	}

	/**
	 * @desc 事务工厂
	 * @author chenyx
	 * @date 2020-01-08
	 *
	 * */
	@Bean
	public TransactionFactory transactionFactory () {
		ManagedTransactionFactory transactionFactory  = new ManagedTransactionFactory();
		return transactionFactory;
	}
	/**
	 * @desc SqlSessionFactory
	 * @author chenyx
	 * @date 2020-01-08
	 *
	 * */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource,TransactionFactory transactionFactory) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setTransactionFactory(transactionFactory);
		//配置mapper.xml文件
		Resource[] resource = new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/*Mapper.xml");
		sqlSessionFactoryBean.setMapperLocations(resource);
		SqlSessionFactory sessionFactory = sqlSessionFactoryBean.getObject();
		return sessionFactory;
	}

}
