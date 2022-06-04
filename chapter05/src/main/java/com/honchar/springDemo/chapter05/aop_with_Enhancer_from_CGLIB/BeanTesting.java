package com.honchar.springDemo.chapter05.aop_with_Enhancer_from_CGLIB;

import org.springframework.aop.framework.Advised;

public class BeanTesting {
    public static void test(SimpleBean bean) {
        long before = 0;
        long after = 0;

        System.out.println("Testing Advised Method");
        before = System.nanoTime();
        for(int x = 0; x < 500000; x++) {
            bean.advised();
        }
        after = System.nanoTime();

        System.out.println("Took " + (after - before) / 1000000 + " ms");

        System.out.println("Testing Unadvised Method");
        before = System.nanoTime();
        for(int x = 0; x < 500000; x++) {
            bean.unadvised();
        }
        after = System.nanoTime();

        System.out.println("Took " + (after - before) / 1000000 + " ms");

        System.out.println("Testing equals() Method");
        before = System.nanoTime();
        for(int x = 0; x < 500000; x++) {
            bean.equals(bean);
        }
        after = System.nanoTime();

        System.out.println("Took " + (after - before) / 1000000 + " ms");

        System.out.println("Testing hashCode() Method");
        before = System.nanoTime();
        for(int x = 0; x < 500000; x++) {
            bean.hashCode();
        }
        after = System.nanoTime();

        System.out.println("Took " + (after - before) / 1000000 + " ms");

        Advised advised = (Advised)bean;

        System.out.println("Testing Advised.getProxyTargetClass() Method");
        before = System.nanoTime();
        for(int x = 0; x < 500000; x++) {
            advised.getTargetClass();
        }
        after = System.nanoTime();

        System.out.println("Took " + (after - before) / 1000000 + " ms");

        System.out.println(">>>\n");
    }
}
