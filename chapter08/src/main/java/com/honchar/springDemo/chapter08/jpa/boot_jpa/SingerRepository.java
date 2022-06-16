package com.honchar.springDemo.chapter08.jpa.boot_jpa;

import com.honchar.springDemo.chapter08.jpa.boot_jpa.entities.Singer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SingerRepository extends CrudRepository<Singer, Long> {
    List<Singer> findByFirstName(String firstName);
    List<Singer> findByFirstNameAndLastName(String firstName, String lastName);
}
