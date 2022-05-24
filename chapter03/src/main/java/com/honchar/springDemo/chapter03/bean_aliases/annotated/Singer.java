package com.honchar.springDemo.chapter03.bean_aliases.annotated;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("johnMayer")
//samples of @Awars annotation possible syntax
//@Award("grammy")
//@Award(prize = {"grammy", "platinum disk"})
@Award(value={"grammy", "platinum disk"})
//@Award({"grammy", "platinum disk"})
@Trophy(name={"grammy", "platinum disk"})
public class Singer {

    private String lyric = "We found a message in a bottle we were drinking";

    public void setLyric(@Value("I'm busted up but I'm loving every minute of it") String lyric) {
        this.lyric = lyric;
    }

    public void sing() {
        System.out.println(lyric);
    }

}