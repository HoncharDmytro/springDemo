package com.honchar.springDemo.chapter08.jpa.jpa_crud.dao;

import com.honchar.springDemo.chapter08.jpa.jpa_crud.entities.Singer;

import java.util.List;

public interface SingerService {
    List<Singer> findAll();
    List<Singer> findAllWithAlbum();
    Singer findById(Long id);
    Singer save(Singer singer);
    void delete(Singer singer);
    List<Singer> findAllByNativeQuery();
}