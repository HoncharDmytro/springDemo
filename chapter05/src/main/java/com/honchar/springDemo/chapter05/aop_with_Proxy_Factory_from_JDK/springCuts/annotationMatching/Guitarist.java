package com.honchar.springDemo.chapter05.aop_with_Proxy_Factory_from_JDK.springCuts.annotationMatching;

import com.honchar.springDemo.chapter05.aop_with_Proxy_Factory_from_JDK.beforeAdvice.Singer;
import com.honchar.springDemo.chapter05.aop_with_Proxy_Factory_from_JDK.springCuts.nameMatcingCuts.Guitar;

public class Guitarist implements Singer {

        @Override public void sing() {
            System.out.println("Dream of ways to throw it all away");
        }

        @AdviceRequired
        public void sing(Guitar guitar) {
            System.out.println("play: " + guitar.play());
        }

        public void rest(){
            System.out.println("zzz");
        }
}
