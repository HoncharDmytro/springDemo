package com.honchar.springDemo.chapter05.aop_helloWorld_withProxyFactory.springCuts.staticCuts;

import com.honchar.springDemo.chapter05.aop_helloWorld_withProxyFactory.beforeAdvice.Singer;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class StaticPointcutDemo {
    public static void main(String... args) {
        GoodGuitarist johnMayer = new GoodGuitarist();
        GreatGuitarist ericClapton = new GreatGuitarist();

        Pointcut pc = new SimpleStaticPointcut();
        Advice advice = new SimpleAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pc, advice);

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(johnMayer);
        Singer proxyOne = (Singer)pf.getProxy();

        pf = new ProxyFactory();
        pf.addAdvisor(advisor);
        pf.setTarget(ericClapton);
        Singer proxyTwo = (Singer)pf.getProxy();

        proxyOne.sing();
        proxyTwo.sing();
    }
}