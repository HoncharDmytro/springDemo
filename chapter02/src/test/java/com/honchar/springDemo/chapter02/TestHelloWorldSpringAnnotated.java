package com.honchar.springDemo.chapter02;

import com.honchar.springDemo.chapter02.annotated.HelloWorldConfiguration;
import com.honchar.springDemo.chapter02.decoupled.MessageRenderer;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestHelloWorldSpringAnnotated {
    @Test
    public void testHello() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext
                (HelloWorldConfiguration.class);
        MessageRenderer mr = ctx.getBean("renderer", MessageRenderer.class);
        assertNotNull(mr);
    }
}
