package com.honchar.springDemo.chapter05.aop_with_Proxy_Factory_from_JDK.springCuts.RegexCuts;

import com.honchar.springDemo.chapter05.aop_with_Proxy_Factory_from_JDK.beforeAdvice.Singer;

public class Guitarist implements Singer {

    @Override public void sing() {
        System.out.println("Just keep me where the light is");
    }

    public void sing2() {
        System.out.println("Oh gravity, stay the hell away from me");
    }

    public void rest() {
        System.out.println("zzz");
    }

}