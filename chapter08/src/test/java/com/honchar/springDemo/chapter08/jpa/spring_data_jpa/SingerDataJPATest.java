package com.honchar.springDemo.chapter08.jpa.spring_data_jpa;

import com.honchar.springDemo.chapter08.jpa.spring_data_jpa.config.DataJpaConfig;
import com.honchar.springDemo.chapter08.jpa.spring_data_jpa.entities.Singer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SingerDataJPATest {

	private static Logger logger = LoggerFactory.getLogger(SingerDataJPATest.class);

	private GenericApplicationContext ctx;
	private SingerService singerService;

	@Test
	public void testFindAll(){
		List<Singer> singers = singerService.findAll();
		assertTrue(singers.size() > 0);
		listSingers(singers);
	}

	@Test
	public void testFindByFirstName(){
		List<Singer> singers = singerService.findByFirstName("John");
		assertTrue(singers.size() > 0);
		assertEquals(2, singers.size());
		listSingers(singers);
	}

	@Test
	public void testFindByFirstNameAndLastName(){
		List<Singer> singers = singerService.findByFirstNameAndLastName("John", "Mayer");
		assertTrue(singers.size() > 0);
		assertEquals(1, singers.size());
		listSingers(singers);
	}

	@BeforeAll
	public void setUp(){
		ctx = new AnnotationConfigApplicationContext(DataJpaConfig.class);
		singerService = ctx.getBean(SingerService.class);
		assertNotNull(singerService);
	}

	private static void listSingers(List<Singer> singers) {
		logger.info(" ---- Listing singers:");
		for (Singer singer : singers) {
			logger.info(singer.toString());
		}
	}

	@AfterAll
	public void tearDown() {
		ctx.close();
	}

}
