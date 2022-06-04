package com.honchar.springDemo.chapter05.aop_helloWorld_withProxyFactory.afterReturningAdvice;

import com.honchar.springDemo.chapter05.aop_helloWorld_withProxyFactory.beforeAdvice.Guitarist;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class ProxyFactoryAfterReturningAdvice implements AfterReturningAdvice {
    public static void main(String... args) {
        Guitarist target = new Guitarist();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new ProxyFactoryAfterReturningAdvice());
        pf.setTarget(target);
        Guitarist proxy = (Guitarist) pf.getProxy();
        proxy.sing();
    }

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("After '" + method.getName() + "' put down guitar.");
    }
}
