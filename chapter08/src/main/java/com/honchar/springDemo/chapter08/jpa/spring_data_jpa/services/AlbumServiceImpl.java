package com.honchar.springDemo.chapter08.jpa.spring_data_jpa.services;

import com.honchar.springDemo.chapter08.jpa.spring_data_jpa.entities.Album;
import com.honchar.springDemo.chapter08.jpa.spring_data_jpa.entities.Singer;
import com.honchar.springDemo.chapter08.jpa.spring_data_jpa.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("springJpaAlbumService")
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