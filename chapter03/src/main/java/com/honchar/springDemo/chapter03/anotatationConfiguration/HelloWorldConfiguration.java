package com.honchar.springDemo.chapter03.anotatationConfiguration;

import com.honchar.springDemo.chapter02.decoupled.HelloWorldMessageProvider;
import com.honchar.springDemo.chapter02.decoupled.MessageProvider;
import com.honchar.springDemo.chapter02.decoupled.MessageRenderer;
import com.honchar.springDemo.chapter02.decoupled.StandardOutMessageRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfiguration {
    @Bean
    public MessageProvider provider() {
        return new HelloWorldMessageProvider();
    }
    @Bean
    public MessageRenderer renderer() {
            MessageRenderer renderer = new StandardOutMessageRenderer();
            renderer.setMessageProvider(provider());
            return renderer;
    }
}