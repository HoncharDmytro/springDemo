package com.honchar.springDemo.chapter05.aop_with_Spring_Framework.AOP_Namespace;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AopNamespaceDemo {
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        //ctx.load("classpath:spring/app-context-namespace.xml");
        ctx.load("classpath:spring/app-context-namespace2.xml");
        ctx.refresh();

        NewDocumentarist documentarist = ctx.getBean("documentarist", NewDocumentarist.class);
        documentarist.execute();

        ctx.close();
    }
}