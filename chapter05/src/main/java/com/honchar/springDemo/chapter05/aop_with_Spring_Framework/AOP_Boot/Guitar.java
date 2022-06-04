package com.honchar.springDemo.chapter05.aop_with_Spring_Framework.AOP_Boot;

public class Guitar {
	private String brand =" Martin";

	public String play(){
		return "G C G C Am D7";
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}
