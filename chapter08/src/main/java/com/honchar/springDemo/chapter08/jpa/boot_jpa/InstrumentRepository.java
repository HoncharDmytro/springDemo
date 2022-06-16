package com.honchar.springDemo.chapter08.jpa.boot_jpa;

import com.honchar.springDemo.chapter08.jpa.boot_jpa.entities.Instrument;
import org.springframework.data.repository.CrudRepository;

public interface InstrumentRepository extends CrudRepository<Instrument, Long> {

}
