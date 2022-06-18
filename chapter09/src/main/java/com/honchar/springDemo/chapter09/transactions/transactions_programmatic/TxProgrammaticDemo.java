package com.honchar.springDemo.chapter09.transactions.transactions_programmatic;

import com.honchar.springDemo.chapter09.transactions.base_dao.config.DataJpaConfig;
import com.honchar.springDemo.chapter09.transactions.transactions_programmatic.config.ServicesConfig;
import com.honchar.springDemo.chapter09.transactions.transactions_programmatic.services.SingerService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class TxProgrammaticDemo {

	public static void main(String... args) {
		GenericApplicationContext ctx =
				 new AnnotationConfigApplicationContext(ServicesConfig.class,
				DataJpaConfig.class);
		SingerService singerService = ctx.getBean(SingerService.class);
		System.out.println("Singer count: " + singerService.countAll());

		ctx.close();
	}
}
