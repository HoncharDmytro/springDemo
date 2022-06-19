package com.honchar.springDemo.chapter09.transactions.base_dao.services;

import com.honchar.springDemo.chapter09.transactions.base_dao.entities.Album;
import com.honchar.springDemo.chapter09.transactions.base_dao.entities.Singer;

import java.util.List;

public interface AlbumService {
    List<Album> findBySinger(Singer singer);

    List<Album> findByTitle(String title);
}