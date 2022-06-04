package com.honchar.springDemo.chapter05.aop_with_Proxy_Factory_from_JDK.springCuts.staticCuts;

import com.honchar.springDemo.chapter05.aop_with_Proxy_Factory_from_JDK.beforeAdvice.Singer;

public class GreatGuitarist implements Singer {

    @Override public void sing() {
        System.out.println("I shot the sheriff, But I did not shoot the deputy");
    }
}