package com.honchar.springDemo.chapter09.transactions.boot_jta.services;

import com.honchar.springDemo.chapter09.transactions.boot_jta.entities.Singer;

public interface SingerService {
    Singer save(Singer singer);

    long count();

}
