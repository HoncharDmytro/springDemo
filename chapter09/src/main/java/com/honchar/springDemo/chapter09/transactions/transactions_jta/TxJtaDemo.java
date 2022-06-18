package com.honchar.springDemo.chapter09.transactions.transactions_jta;

import com.honchar.springDemo.chapter09.transactions.base_dao.config.XAJpaConfig;
import com.honchar.springDemo.chapter09.transactions.base_dao.entities.Singer;
import com.honchar.springDemo.chapter09.transactions.base_dao.services.SingerService;
import com.honchar.springDemo.chapter09.transactions.transactions_jta.config.ServicesConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class TxJtaDemo {
	private static final Logger logger = LoggerFactory.getLogger(TxJtaDemo.class);

	public static void main(String... args) {
		GenericApplicationContext ctx = new AnnotationConfigApplicationContext(ServicesConfig.class,
				XAJpaConfig.class);
		SingerService singerService = ctx.getBean(SingerService.class);
		Singer singer = new Singer();
		singer.setFirstName("John");
		singer.setLastName("Mayer");
		singer.setBirthDate(new Date(
				(new GregorianCalendar(1977, Calendar.OCTOBER, 16)).getTime().getTime()));
		singerService.save(singer);
		if (singer.getId() != null) {
			logger.info("--> Singer saved successfully");
		}  else {
			logger.error("--> Singer was not saved, check the configuration!!");
		}

		// check saving in both databases
		List<Singer> singers = singerService.findAll();
		if (singers.size()!= 2) {
			logger.error("--> Something went wrong.");
		} else {
			logger.info("--> Singers from both DBs: " + singers);
		}
		ctx.close();
	}
} 
