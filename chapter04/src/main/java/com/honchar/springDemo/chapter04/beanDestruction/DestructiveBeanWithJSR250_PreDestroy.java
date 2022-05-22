package com.honchar.springDemo.chapter04.beanDestruction;

import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

public class DestructiveBeanWithJSR250_PreDestroy {
    private File file;
    private String filePath;

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean");
        if (filePath == null) {
            throw new IllegalArgumentException("You must "
                    + "specify the filePath property of "
                    + DestructiveBeanWithJSR250_PreDestroy.class);
        }

        this.file = new File(filePath);
        this.file.createNewFile();

        System.out.println("File exists: " + file.exists());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying Bean");

        if (!file.delete()) {
            System.err.println("ERROR: failed to delete file.");
            System.out.println("File exists: " + file.exists());
        }

        System.out.println("File exists: " + file.exists());
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String... args) throws Exception {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/beanDestruction/app-context-annotation.xml");
        ctx.refresh();
        DestructiveBeanWithJSR250_PreDestroy bean =
                (DestructiveBeanWithJSR250_PreDestroy) ctx.getBean("destructiveBean");
        System.out.println("Calling destroy()");
        ctx.close();
        System.out.println("Called destroy()");
    }
}