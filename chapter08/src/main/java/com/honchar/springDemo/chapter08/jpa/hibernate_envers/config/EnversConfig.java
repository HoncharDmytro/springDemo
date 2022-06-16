package com.honchar.springDemo.chapter08.jpa.hibernate_envers.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.envers.boot.internal.EnversServiceImpl;
import org.hibernate.envers.event.spi.EnversPostUpdateEventListenerImpl;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:jpa_crud/properties/jpa.properties")
@ComponentScan(basePackages = {"com.honchar.springDemo.chapter08.jpa.hibernate_envers"})
@EnableJpaRepositories(basePackages = {"com.honchar.springDemo.chapter08.jpa.hibernate_envers.repos"})
@EnableJpaAuditing(auditorAwareRef = "auditorAwareBean")
public class EnversConfig {

	private static final Logger logger = LoggerFactory.getLogger(EnversConfig.class);

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
		hibernateProp.put("hibernate.dialect", env.getProperty("dialect"));
		hibernateProp.put("hibernate.format_sql", true);
		hibernateProp.put("hibernate.show_sql", true);
		hibernateProp.put("hibernate.max_fetch_depth", 3);
		hibernateProp.put("hibernate.jdbc.batch_size", 10);
		hibernateProp.put("hibernate.jdbc.fetch_size", 50);
		//Properties for Hibernate Envers
		hibernateProp.put("org.hibernate.envers.audit_table_suffix", "_H");
		hibernateProp.put("org.hibernate.envers.revision_field_name", "AUDIT_REVISION");
		hibernateProp.put("org.hibernate.envers.revision_type_field_name", "ACTION_TYPE");
		hibernateProp.put("org.hibernate.envers.audit_strategy", "org.hibernate.envers.strategy.ValidityAuditStrategy");
		hibernateProp.put("org.hibernate.envers.audit_strategy_validity_end_rev_field_name", "AUDIT_REVISION_END");
		hibernateProp.put("org.hibernate.envers.audit_strategy_validity_store_revend_timestamp", "True");
		hibernateProp.put("org.hibernate.envers.audit_strategy_validity_revend_timestamp_field_name",
				"AUDIT_REVISION_END_TS");

		return hibernateProp;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setPackagesToScan("com.honchar.springDemo.chapter08.jpa.hibernate_envers.entities");
		factoryBean.setDataSource(dataSource());
		factoryBean.setJpaProperties(hibernateProperties());
		factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
		factoryBean.afterPropertiesSet();
		return factoryBean.getObject();
	}
}
