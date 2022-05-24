package com.honchar.springDemo.chapter03.setter_injection;

import com.honchar.springDemo.chapter03.setter_injection.Dependency;

public class SetterInjection {
    private Dependency dependency;

    public void setDependency(Dependency dependency) {
        this.dependency = dependency;
    }

    @Override
    public String toString() {
        return dependency.toString();
    }
}
