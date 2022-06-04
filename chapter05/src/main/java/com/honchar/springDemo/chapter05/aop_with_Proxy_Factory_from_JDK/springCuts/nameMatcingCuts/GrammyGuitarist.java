package com.honchar.springDemo.chapter05.aop_with_Proxy_Factory_from_JDK.springCuts.nameMatcingCuts;

import org.springframework.stereotype.Component;

@Component("johnMayer")
public class GrammyGuitarist{

    public void sing() {
        System.out.println("sing: Gravity is working against me\n" +
                "And gravity wants to bring me down");
    }

    public void sing(Guitar guitar) {
        System.out.println("play: " + guitar.play());
    }

    public void rest(){
        System.out.println("zzz");
    }

    public void talk(){
        System.out.println("talk");
    }
}