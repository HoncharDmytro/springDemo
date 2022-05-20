package com.honchar.springDemo.chapter02;

import com.honchar.springDemo.chapter02.decoupled.HelloWorldMessageProvider;
import com.honchar.springDemo.chapter02.decoupled.MessageProvider;
import com.honchar.springDemo.chapter02.decoupled.MessageRenderer;
import com.honchar.springDemo.chapter02.decoupled.StandardOutMessageRenderer;

public class HelloWorld {
    public static void main(String[] args) {
        MessageRenderer mr = new StandardOutMessageRenderer();
        MessageProvider mp = new HelloWorldMessageProvider();
        mr.setMessageProvider(mp);
        mr.render() ;
    }
}
