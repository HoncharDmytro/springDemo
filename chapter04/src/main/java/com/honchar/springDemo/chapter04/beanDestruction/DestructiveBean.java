package com.honchar.springDemo.chapter04.beanDestruction;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.io.File;

public class DestructiveBean implements InitializingBean {
    private File file;
    private String filePath;

    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean");

        if (filePath == null) {
            throw new IllegalArgumentException("You must specify the filePath property of" + DestructiveBean.class);
        }

        this.file = new File(filePath);
        this.file.createNewFile();
        System.out.println("File exists: " + file.exists());
    }

    public void destroy() {
        System.out.println("Destroying Bean");
        if (!file.delete()) {
            System.err.println("ERROR: failed to delete file.");
        }
        System.out.println("File exists: " + file.exists());
    }

    public void setFilePath (String filePath) {
        this.filePath = filePath;
    }

    public static void main (String... args) throws Exception {
    GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
    ctx.load("classpath:spring/beanDestruction/app-context-xml.xml");
    ctx.refresh();

    DestructiveBean bean = (DestructiveBean) ctx.getBean("destructiveBean");

    System.out.println("Calling destroy()");
    ctx.close();//destroy() deprecated!!!
    System.out.println("Called destroy()");
    }
}
