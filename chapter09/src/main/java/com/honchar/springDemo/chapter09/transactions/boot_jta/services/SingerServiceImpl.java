package com.honchar.springDemo.chapter09.transactions.boot_jta.services;


import com.honchar.springDemo.chapter09.transactions.boot_jta.entities.Singer;
import com.honchar.springDemo.chapter09.transactions.boot_jta.ex.AsyncXAResourcesException;
import com.honchar.springDemo.chapter09.transactions.boot_jta.repos.SingerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("singerService")
@Transactional
public class SingerServiceImpl implements SingerService {


	private SingerRepository singerRepository;

	private JmsTemplate jmsTemplate;


	public SingerServiceImpl(SingerRepository singerRepository, JmsTemplate jmsTemplate) {
		this.singerRepository = singerRepository;
		this.jmsTemplate = jmsTemplate;
	}

	@Override
	public Singer save(Singer singer) {
		jmsTemplate.convertAndSend("singers", "Just saved:" + singer);
		if(singer == null) {
			throw new AsyncXAResourcesException("Simulation of something going wrong.");
		}
		singerRepository.save(singer);
		return singer;
	}

	@Override public long count() {
		return singerRepository.count();
	}
}
