package com.honchar.springDemo.chapter09.transactions.boot_jta;
import com.honchar.springDemo.chapter09.transactions.boot_jta.entities.Singer;
import com.honchar.springDemo.chapter09.transactions.boot_jta.services.SingerService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SpringBootApplication(scanBasePackages = "com.honchar.springDemo.chapter09.transactions.boot_jta")
public class Application implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(Application.class);

	public static void main(String... args) throws Exception {
		ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

		System.in.read();
		ctx.close();
	}

	@Autowired
	SingerService singerService;

	@Override public void run(String... args) throws Exception {
		Singer singer = new Singer();
		singer.setFirstName("John");
		singer.setLastName("Mayer");
		singer.setBirthDate(new Date(
				(new GregorianCalendar(1977, Calendar.OCTOBER, 16)).getTime().getTime()));
		singerService.save(singer);

		long count = singerService.count();
		if (count == 1) {
			logger.info("--> Singer saved successfully");
		}  else {
			logger.error("--> Singer was not saved, check the configuration!!");
		}

		try {
			singerService.save(null);
		} catch (Exception ex) {
			logger.error(ex.getMessage() + "Final count:" + singerService.count());
		}
	}
}
