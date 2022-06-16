package com.honchar.springDemo.chapter08.jpa.spring_data_jpa.repository;

import com.honchar.springDemo.chapter08.jpa.spring_data_jpa.entities.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {

}