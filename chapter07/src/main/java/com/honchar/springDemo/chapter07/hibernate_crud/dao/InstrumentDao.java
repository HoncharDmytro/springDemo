package com.honchar.springDemo.chapter07.hibernate_crud.dao;

import com.honchar.springDemo.chapter07.hibernate_crud.entities.Instrument;

public interface InstrumentDao {
	Instrument save(Instrument instrument);
}
