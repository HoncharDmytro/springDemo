package com.honchar.springDemo.chapter04.springBootWeb;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping("/")
    public String sayHi() {
        return "Hello World!";
    }
}