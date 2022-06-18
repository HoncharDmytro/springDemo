package com.honchar.springDemo.chapter06.spring_boot_jdbc;

import com.honchar.springDemo.chapter06.simple_jdbc.dao.SingerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
        assert (ctx != null);

        SingerDao singerDao = ctx.getBean(SingerDao.class);
        String singerName = singerDao.findNameById(1L);
        String singerFirstName = singerDao.findFirstNameById(2L);
        logger.info("Retrieved singer full name: " + singerName);
        logger.info("Retrieved singer first name: " + singerFirstName);

        System.in.read();
        ctx.close();
    }
}