package com.honchar.springDemo.chapter08.jpa.spring_data_jpa.services;

import com.honchar.springDemo.chapter08.jpa.spring_data_jpa.entities.Album;
import com.honchar.springDemo.chapter08.jpa.spring_data_jpa.entities.Singer;

import java.util.List;

public interface AlbumService {
    List<Album> findBySinger(Singer singer);

    List<Album> findByTitle(String title);
}