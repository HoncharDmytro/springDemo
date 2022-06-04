package com.honchar.springDemo.chapter05.aop_helloWorld_withProxyFactory.springCuts.staticCuts;

import com.honchar.springDemo.chapter05.aop_helloWorld_withProxyFactory.beforeAdvice.Singer;

public class GoodGuitarist implements Singer {

    @Override public void sing() {
        System.out.println("Who says I can't be free From all of the things that I used to be");
    }
}