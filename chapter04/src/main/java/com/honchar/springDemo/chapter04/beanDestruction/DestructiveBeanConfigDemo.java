package com.honchar.springDemo.chapter04.beanDestruction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.support.GenericApplicationContext;

public class DestructiveBeanConfigDemo {
    @Configuration
    static class DestructiveBeanConfig {
        @Lazy
        @Bean(initMethod = "afterPropertiesSet", destroyMethod = "destroy")
        DestructiveBeanWithJSR250_PreDestroy destructiveBean() {
            DestructiveBeanWithJSR250_PreDestroy destructiveBean = new DestructiveBeanWithJSR250_PreDestroy();
            destructiveBean.setFilePath(System.getProperty("java.io.tmpdir") +
                    System.getProperty("file.separator") + "test.txt");
            return destructiveBean;
        }

    }

    public static void main(String... args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(DestructiveBeanConfig.class);

        ctx.getBean(DestructiveBeanWithJSR250_PreDestroy.class);
        ctx.registerShutdownHook(); //termination interception
    }
}
