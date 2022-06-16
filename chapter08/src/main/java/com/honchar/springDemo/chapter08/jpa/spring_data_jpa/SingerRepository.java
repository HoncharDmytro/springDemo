package com.honchar.springDemo.chapter08.jpa.spring_data_jpa;

import java.util.List;

import com.honchar.springDemo.chapter08.jpa.spring_data_jpa.entities.Singer;
import org.springframework.data.repository.CrudRepository;

public interface SingerRepository extends CrudRepository<Singer, Long> {
    List<Singer> findByFirstName(String firstName);
    List<Singer> findByFirstNameAndLastName(String firstName, String lastName);
}
