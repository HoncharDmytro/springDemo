package com.honchar.springDemo.chapter05.aop_with_Spring_Framework.AOP_Boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	private static Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);
		assert (ctx != null);

		NewDocumentarist documentarist = ctx.getBean("documentarist", NewDocumentarist.class);
		documentarist.execute();

		System.in.read();
		ctx.close();
	}
}
