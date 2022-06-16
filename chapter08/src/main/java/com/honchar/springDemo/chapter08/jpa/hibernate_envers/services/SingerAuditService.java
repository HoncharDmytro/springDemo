package com.honchar.springDemo.chapter08.jpa.hibernate_envers.services;

import com.honchar.springDemo.chapter08.jpa.hibernate_envers.entities.SingerAudit;

import java.util.List;

public interface SingerAuditService {
    List<SingerAudit> findAll();
    SingerAudit findById(Long id);
    SingerAudit save(SingerAudit singerAudit);
    SingerAudit findAuditByRevision(Long id, int revision);
}
