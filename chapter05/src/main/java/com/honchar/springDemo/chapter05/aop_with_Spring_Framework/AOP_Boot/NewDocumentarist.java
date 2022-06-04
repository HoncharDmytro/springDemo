package com.honchar.springDemo.chapter05.aop_with_Spring_Framework.AOP_Boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("documentarist")
public class NewDocumentarist {

	protected GrammyGuitarist guitarist;

	public void execute() {
		guitarist.sing();
		Guitar guitar = new Guitar();
		guitar.setBrand("Gibson");
		guitarist.sing(guitar);
		guitarist.talk();
	}

	@Autowired
	@Qualifier("johnMayer")
	public void setGuitarist(GrammyGuitarist guitarist) {
		this.guitarist = guitarist;
	}
}
