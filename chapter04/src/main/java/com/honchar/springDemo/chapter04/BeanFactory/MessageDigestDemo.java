package com.honchar.springDemo.chapter04.BeanFactory;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MessageDigestDemo {
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/BeanFactory/app-context-xml.xml");
        ctx.refresh();

        MessageDigester digester = (MessageDigester) ctx.getBean("digester");
        digester.digest("Hello World!");

        ctx.close();
    }
}