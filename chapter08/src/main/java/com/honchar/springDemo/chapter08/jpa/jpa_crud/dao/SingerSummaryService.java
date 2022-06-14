package com.honchar.springDemo.chapter08.jpa.jpa_crud.dao;

import com.honchar.springDemo.chapter08.jpa.jpa_crud.view.SingerSummary;

import java.util.List;

public interface SingerSummaryService {
    List<SingerSummary> findAll();
}