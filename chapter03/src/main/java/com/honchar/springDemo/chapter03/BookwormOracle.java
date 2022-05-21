package com.honchar.springDemo.chapter03;

public class BookwormOracle implements Oracle{
    private Encyclopedia encyclopedia;

    public void setEncyclopedia(Encyclopedia encyclopedia) {
        this.encyclopedia = encyclopedia;
    }

    @Override
    public String defineMeaningOfLife() {
        return "Encyclopedias are a waste of money -  go see the world instead";
    }
}
