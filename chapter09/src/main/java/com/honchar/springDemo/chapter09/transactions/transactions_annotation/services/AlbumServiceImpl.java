package com.honchar.springDemo.chapter09.transactions.transactions_annotation.services;

import com.honchar.springDemo.chapter09.transactions.base_dao.entities.Album;
import com.honchar.springDemo.chapter09.transactions.base_dao.entities.Singer;
import com.honchar.springDemo.chapter09.transactions.base_dao.repos.AlbumRepository;
import com.honchar.springDemo.chapter09.transactions.base_dao.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("albumService")
@Transactional
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumRepository albumRepository;

    @Transactional(readOnly=true)
    @Override public List<Album> findBySinger(Singer singer) {
        return albumRepository.findBySinger(singer);
    }

    @Override public List<Album> findByTitle(String title) {
        return albumRepository.findByTitle(title);
    }
}