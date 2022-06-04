package com.honchar.springDemo.chapter05.aop_with_Proxy_Factory_from_JDK.springCuts.dynamicCuts;

public class SampleBean {
    public void foo(int x) {
            System.out.println("Invoked foo() with: "+x);
    }
    public void bar() {
        System.out.println("Invoked bar()");
    }
}
