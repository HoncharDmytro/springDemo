package com.honchar.springDemo.chapter08.jpa.spring_data_jpa_audit.config;

import com.honchar.springDemo.chapter08.jpa.spring_data_jpa_audit.entities.SingerAudit;
import com.honchar.springDemo.chapter08.jpa.spring_data_jpa_audit.repos.SingerAuditRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class DBInitializer {
	private final Logger logger = LoggerFactory.getLogger(DBInitializer.class);

	@Autowired
	SingerAuditRepository singerRepository;

	@PostConstruct
	public void initDB(){
		logger.info("Starting database initialization...");

		SingerAudit singer = new SingerAudit();
		singer.setFirstName("John");
		singer.setLastName("Mayer");
		singer.setBirthDate(new Date(
				(new GregorianCalendar(1977, Calendar.OCTOBER, 16)).getTime().getTime()));

		singerRepository.save(singer);

		singer = new SingerAudit();
		singer.setFirstName("Eric");
		singer.setLastName("Clapton");
		singer.setBirthDate(new Date(
				(new GregorianCalendar(1945, Calendar.MARCH, 30)).getTime().getTime()));

		singerRepository.save(singer);

		singer = new SingerAudit();
		singer.setFirstName("John");
		singer.setLastName("Butler");
		singer.setBirthDate(new Date(
				(new GregorianCalendar(1975, Calendar.APRIL, 1)).getTime().getTime()));

		singerRepository.save(singer);
		logger.info("Database initialization finished.");
	}

}
