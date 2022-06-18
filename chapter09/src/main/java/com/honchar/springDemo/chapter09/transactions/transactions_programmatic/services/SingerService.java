package com.honchar.springDemo.chapter09.transactions.transactions_programmatic.services;



import java.util.List;

public interface SingerService {
    List<Singer> findAll();
    Singer findById(Long id);
    Singer save(Singer singer);
    long countAll();
}
