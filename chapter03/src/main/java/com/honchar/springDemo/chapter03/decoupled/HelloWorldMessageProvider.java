package com.honchar.springDemo.chapter03.decoupled;

import com.honchar.springDemo.chapter02.decoupled.MessageProvider;
import org.springframework.stereotype.Component;

@Component("provider")//Simple Spring Bean
public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}