package com.honchar.springDemo.chapter08.jpa.spring_data_jpa;

import com.honchar.springDemo.chapter08.jpa.spring_data_jpa.entities.Singer;

import java.util.List;

public interface SingerService {
    List<Singer> findAll();
    List<Singer> findByFirstName(String firstName);
    List<Singer> findByFirstNameAndLastName(String firstName, String lastName);
}
