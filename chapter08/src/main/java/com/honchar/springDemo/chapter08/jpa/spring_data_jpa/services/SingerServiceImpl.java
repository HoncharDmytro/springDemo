package com.honchar.springDemo.chapter08.jpa.spring_data_jpa.services;

import com.honchar.springDemo.chapter08.jpa.spring_data_jpa.entities.Singer;
import com.honchar.springDemo.chapter08.jpa.spring_data_jpa.repository.SingerRepository;
import com.honchar.springDemo.chapter08.jpa.spring_data_jpa.services.SingerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.google.common.collect.Lists;

@Service("springJpaSingerService")
@Transactional
public class SingerServiceImpl implements SingerService {
    @Autowired
    private SingerRepository singerRepository;

    @Transactional(readOnly=true)
    public List<Singer> findAll() {
        return Lists.newArrayList(singerRepository.findAll());
    }

    @Transactional(readOnly=true)
    public List<Singer> findByFirstName(String firstName) {
        return singerRepository.findByFirstName(firstName);
    }

    @Transactional(readOnly=true)
    public List<Singer> findByFirstNameAndLastName(
        String firstName, String lastName) {
        return singerRepository.findByFirstNameAndLastName(
            firstName, lastName);
    }
}
