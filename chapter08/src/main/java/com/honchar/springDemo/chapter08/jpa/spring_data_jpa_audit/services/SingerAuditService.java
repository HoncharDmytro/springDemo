package com.honchar.springDemo.chapter08.jpa.spring_data_jpa_audit.services;

import com.honchar.springDemo.chapter08.jpa.spring_data_jpa_audit.entities.SingerAudit;

import java.util.List;

public interface SingerAuditService {
    List<SingerAudit> findAll();
    SingerAudit findById(Long id);
    SingerAudit save(SingerAudit singer);
}
