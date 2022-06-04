package com.honchar.springDemo.chapter05.aop_with_Proxy_Factory_from_JDK.simple;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AgentDecorator implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.print("James ");

        Object retVal = invocation.proceed();//call method speak().

        System.out.println("!");
        return retVal;
    }
}