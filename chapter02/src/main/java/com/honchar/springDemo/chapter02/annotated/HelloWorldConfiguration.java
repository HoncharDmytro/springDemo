package com.honchar.springDemo.chapter02.annotated;

import com.honchar.springDemo.chapter02.decoupled.HelloWorldMessageProvider;
import com.honchar.springDemo.chapter02.decoupled.MessageProvider;
import com.honchar.springDemo.chapter02.decoupled.MessageRenderer;
import com.honchar.springDemo.chapter02.decoupled.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//same to resources\spring\app-context.xml
@Configuration
public class HelloWorldConfiguration {

    //same to <bean id="provider" class=" .. "/>
    @Bean
    public MessageProvider provider() {
        return new HelloWorldMessageProvider();
    }

    //same to <bean id="renderer" class=" .. "/>
    @Bean
    public MessageRenderer renderer(){
        MessageRenderer renderer = new StandardOutMessageRenderer();
        renderer.setMessageProvider(provider());
        return renderer;
    }
}

