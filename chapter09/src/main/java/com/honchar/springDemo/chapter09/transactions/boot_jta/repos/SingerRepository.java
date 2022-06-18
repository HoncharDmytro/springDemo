package com.honchar.springDemo.chapter09.transactions.boot_jta.repos;

import com.honchar.springDemo.chapter09.transactions.boot_jta.entities.Singer;
import org.springframework.data.repository.CrudRepository;

public interface SingerRepository extends CrudRepository<Singer, Long> {

}
