package com.honchar.springDemo.chapter08.jpa.spring_data_jpa.repository;

import com.honchar.springDemo.chapter08.jpa.spring_data_jpa.entities.Album;
import com.honchar.springDemo.chapter08.jpa.spring_data_jpa.entities.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findBySinger(Singer singer);

    @Query("select a from Album a where a.title like %:title%")
    List<Album> findByTitle(@Param("title") String title);
}