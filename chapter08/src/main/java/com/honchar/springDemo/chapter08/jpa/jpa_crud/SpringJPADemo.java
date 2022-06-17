package com.honchar.springDemo.chapter08.jpa.jpa_crud;

import com.honchar.springDemo.chapter08.jpa.jpa_crud.dao.SingerService;
import com.honchar.springDemo.chapter08.jpa.jpa_crud.entities.Singer;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class SpringJPADemo {
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:jpa_crud/spring/app-context-annotation.xml");
        ctx.refresh();

        SingerService singerService = ctx.getBean(SingerService.class);

        List<Singer> singers = singerService.findAll();

        for(Singer singer : singers) {
            System.out.println(singer);
        }

        ctx.close();
    }
}