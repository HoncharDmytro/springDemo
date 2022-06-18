package com.honchar.springDemo.chapter09.transactions.base_dao.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;


@Configuration
@PropertySource("classpath:base_dao/prop/transactions.properties")
@EnableJpaRepositories(basePackages = {"com.honchar.springDemo.chapter09.transactions.base_dao.repos"})
public class DataJpaConfig {

	private static final Logger logger = LoggerFactory.getLogger(DataJpaConfig.class);

	@Autowired
	Environment env;

	@Bean(destroyMethod = "close")
	public BasicDataSource dataSource() {
		try {
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName(env.getProperty("driverClassName"));
			dataSource.setUrl(env.getProperty("url"));
			dataSource.setUsername(env.getProperty("user"));
			dataSource.setPassword(env.getProperty("password"));
			return dataSource;
		} catch (Exception e) {
			logger.error("BasicDataSource bean cannot be created!", e);
			return null;
		}
	}

	@Bean
	public Properties hibernateProperties() {
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.dialect", env.getProperty("dialect"));
		hibernateProp.put("hibernate.hbm2ddl.auto", "create-drop");
		//hibernateProp.put("hibernate.format_sql", true);
		hibernateProp.put("hibernate.show_sql", true);
		hibernateProp.put("hibernate.max_fetch_depth", 3);
		hibernateProp.put("hibernate.jdbc.batch_size", 10);
		hibernateProp.put("hibernate.jdbc.fetch_size", 50);
		return hibernateProp;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPackagesToScan("com.honchar.springDemo.chapter09.transactions.entities");
		factoryBean.setDataSource(dataSource());
		factoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factoryBean.setJpaProperties(hibernateProperties());
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		factoryBean.afterPropertiesSet();
		return factoryBean.getNativeEntityManagerFactory();
	}
}
