package com.honchar.springDemo.chapter09.transactions.transactions_programmatic.services;

import com.honchar.springDemo.chapter09.transactions.base_dao.entities.Singer;

import java.util.List;

public interface SingerService {
    List<Singer> findAll();
    Singer findById(Long id);
    Singer save(Singer singer);
    long countAll();
}
