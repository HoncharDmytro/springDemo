package com.honchar.springDemo.chapter07.hibernate_base.dao;

import com.honchar.springDemo.chapter07.hibernate_base.entities.Singer;

import java.util.List;

public interface SingerDao {

    List<Singer> findAll();

    List<Singer> findAllWithAlbum();

    Singer findById(Long id);

    Singer save(Singer singer);

    void delete(Singer singer);
}