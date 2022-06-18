package com.honchar.springDemo.chapter09.transactions.boot_jta;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Messages {
	private static final Logger logger = LoggerFactory.getLogger(Messages.class);

	@JmsListener(destination="singers")
	public void onMessage(String content){
		logger.info("--> Received content: " + content);
	}
}
