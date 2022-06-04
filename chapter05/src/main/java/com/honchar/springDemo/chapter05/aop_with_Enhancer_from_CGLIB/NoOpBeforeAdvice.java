package com.honchar.springDemo.chapter05.aop_with_Enhancer_from_CGLIB;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class NoOpBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target)
            throws Throwable {
        // no-op
    }
}