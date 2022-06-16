package com.honchar.springDemo.chapter08.jpa.spring_data_jpa.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:spring_data_jpa/properties/jpa.properties")
@ComponentScan(basePackages = {"com.honchar.springDemo.chapter08.jpa.spring_data_jpa"})
@EnableJpaRepositories(basePackages = {"com.honchar.springDemo.chapter08.jpa.spring_data_jpa"})
public class DataJpaConfig {

	private static final Logger logger = LoggerFactory.getLogger(DataJpaConfig.class);

//	  @Value("${driverClassName}")
//    private String driverClassName;
//    @Value("${url}")
//    private String url;
//    @Value("${user}")
//    private String username;
//    @Value("${password}")
//    private String password;
//    @Value("${dialect}")
//    private String dialect;
//
//    @Bean
//    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
//        return new PropertySourcesPlaceholderConfigurer();
//    }

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
	public PlatformTransactionManager transactionManager() {
		return new JpaTransactionManager(entityManagerFactory());
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}

	@Bean
	public Properties hibernateProperties() {
		Properties hibernateProp = new Properties();
		hibernateProp.put("hibernate.dialect", "${dialect}");
		hibernateProp.put("hibernate.format_sql", true);
		hibernateProp.put("hibernate.use_sql_comments", true);
		hibernateProp.put("hibernate.show_sql", true);
		hibernateProp.put("hibernate.max_fetch_depth", 3);
		hibernateProp.put("hibernate.jdbc.batch_size", 10);
		hibernateProp.put("hibernate.jdbc.fetch_size", 50);
		return hibernateProp;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPackagesToScan("com.honchar.springDemo.chapter08.jpa.spring_data_jpa.entities");
		factoryBean.setDataSource(dataSource());
		factoryBean.setJpaProperties(hibernateProperties());
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		factoryBean.afterPropertiesSet();
		return factoryBean.getNativeEntityManagerFactory();
	}
}
