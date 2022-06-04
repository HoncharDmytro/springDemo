package com.honchar.springDemo.chapter05.aop_hello_world;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AgentDecorator implements MethodInterceptor {
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.print("James ");

        Object retVal = invocation.proceed();

        System.out.println("!");
        return retVal;
    }
}