package com.honchar.springDemo.chapter05.aop_with_Proxy_Factory_from_JDK.beforeAdvice;

public class Guitarist implements Singer {

    @Override
    public void sing() {
        String lyric = "You're gonna live forever in me.";
        System.out.println(lyric);
    }
}