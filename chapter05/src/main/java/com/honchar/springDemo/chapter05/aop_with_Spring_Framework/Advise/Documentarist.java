package com.honchar.springDemo.chapter05.aop_with_Spring_Framework.Advise;

import com.honchar.springDemo.chapter05.aop_with_Proxy_Factory_from_JDK.springCuts.nameMatcingCuts.GrammyGuitarist;

public class Documentarist {
    protected GrammyGuitarist guitarist;

    public void execute() {
        guitarist.sing();
        guitarist.talk();
    }

    public void setGuitarist(GrammyGuitarist guitarist) {
        this.guitarist = guitarist;
    }
}
