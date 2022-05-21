package com.honchar.springDemo.chapter03.anotatationConfiguration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(basePackages = {"com.honchar.springDemo.chapter03.anotatationConfiguration"})
@Configuration
public class HelloWorldConfigurationComponentScan {
}