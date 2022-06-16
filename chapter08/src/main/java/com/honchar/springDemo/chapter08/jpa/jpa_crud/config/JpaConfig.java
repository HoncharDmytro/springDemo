package com.honchar.springDemo.chapter08.jpa.jpa_crud.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
@ComponentScan(basePackages = {"com.honchar.springDemo.chapter08.jpa.jpa_crud.dao"})
@PropertySource("classpath:jpa_crud/properties/jpa.properties")
public class JpaConfig {
    private static final Logger logger = LoggerFactory.getLogger(JpaConfig.class);

//    @Value("${driverClassName}")
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
        Properties hibernateProperties = new Properties();
        hibernateProperties.put("hibernate.dialect", env.getProperty("dialect"));
        hibernateProperties.put("hibernate.format_sql", true);
        hibernateProperties.put("hibernate.use_sql_comments", true);
        hibernateProperties.put("hibernate.show_sql", true);
        hibernateProperties.put("hibernate.max_fetch_depth", 3);
        hibernateProperties.put("hibernate.jdbc.batch_size", 10);
        hibernateProperties.put("hibernate.jdbc.fetch_size", 50);
        return hibernateProperties;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("com.honchar.springDemo.chapter08.jpa.jpa_crud.entities");
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.afterPropertiesSet();
        return factoryBean.getNativeEntityManagerFactory();
    }
}