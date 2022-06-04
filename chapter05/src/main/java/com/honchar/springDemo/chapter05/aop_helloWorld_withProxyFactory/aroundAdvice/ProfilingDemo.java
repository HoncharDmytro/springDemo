package com.honchar.springDemo.chapter05.aop_helloWorld_withProxyFactory.aroundAdvice;

import org.springframework.aop.framework.ProxyFactory;

public class ProfilingDemo {
    public static void main(String... args) {
    WorkerBean bean = getWorkerBean();
    bean.doSomeWork(1000000);
    }

    private static WorkerBean getWorkerBean() {
        WorkerBean target = new WorkerBean();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(new ProfilingInterceptor());
        return (WorkerBean) factory.getProxy();
    }
}
