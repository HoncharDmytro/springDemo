package com.honchar.springDemo.chapter03.bean_aliases.annotated;

import org.springframework.core.annotation.AliasFor;

public @interface Trophy {

    @AliasFor(annotation = Award.class, attribute = "value")
    String[] name() default {};
}