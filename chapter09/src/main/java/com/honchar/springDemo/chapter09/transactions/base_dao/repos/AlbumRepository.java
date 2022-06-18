package com.honchar.springDemo.chapter09.transactions.base_dao.repos;

import com.honchar.springDemo.chapter09.transactions.base_dao.entities.Album;
import com.honchar.springDemo.chapter09.transactions.base_dao.entities.Singer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {
	List<Album> findBySinger(Singer singer);
}
