package com.honchar.springDemo.chapter03;

import com.honchar.springDemo.chapter03.setter_injection.Dependency;

public class ConstructorInjection {
    private Dependency dependency;

    public ConstructorInjection(Dependency dependency) {
        this.dependency = dependency;
    }

    @Override
    public String toString() {
        return dependency.toString();
    }
}
