package com.honchar.springDemo.chapter05.aop_with_Proxy_Factory_from_JDK.aroundAdvice;

public class WorkerBean {
    public void doSomeWork(int noOfTimes) {
        for (int x = 0; x < noOfTimes; x++) {
            work();
        }
    }

    private void work() {
        System.out.print("");
    }
}
