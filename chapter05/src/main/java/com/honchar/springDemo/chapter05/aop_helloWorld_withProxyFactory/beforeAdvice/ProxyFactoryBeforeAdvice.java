package com.honchar.springDemo.chapter05.aop_helloWorld_withProxyFactory.beforeAdvice;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class ProxyFactoryBeforeAdvice implements MethodBeforeAdvice {
    public static void main(String... args) {
        Guitarist johnMayer = new Guitarist();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new ProxyFactoryBeforeAdvice());
        pf.setTarget(johnMayer);
        Guitarist proxy = (Guitarist) pf.getProxy();
        proxy.sing();
    }

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("Before '" + method.getName() + "', tune guitar.");
    }
}
