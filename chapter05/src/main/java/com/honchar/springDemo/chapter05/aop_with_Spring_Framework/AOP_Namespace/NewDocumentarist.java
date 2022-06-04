package com.honchar.springDemo.chapter05.aop_with_Spring_Framework.AOP_Namespace;

import com.honchar.springDemo.chapter05.aop_with_Proxy_Factory_from_JDK.springCuts.nameMatcingCuts.Guitar;
import com.honchar.springDemo.chapter05.aop_with_Spring_Framework.Advise.Documentarist;

public class NewDocumentarist extends Documentarist {
    @Override
    public void execute() {
        guitarist.sing();
        Guitar guitar = new Guitar();
        guitar.setBrand("Gibson");
        //guitarist.sing(guitar);
        guitarist.sing(new Guitar());
        guitarist.talk();
    }
}