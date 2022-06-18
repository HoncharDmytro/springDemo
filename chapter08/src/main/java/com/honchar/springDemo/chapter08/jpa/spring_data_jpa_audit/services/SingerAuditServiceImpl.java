package com.honchar.springDemo.chapter08.jpa.spring_data_jpa_audit.services;

import com.honchar.springDemo.chapter08.jpa.spring_data_jpa_audit.entities.SingerAudit;
import com.honchar.springDemo.chapter08.jpa.spring_data_jpa_audit.repos.SingerAuditRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.google.common.collect.Lists;

@Service("singerAuditService")
@Transactional
public class SingerAuditServiceImpl implements SingerAuditService {

    @Autowired
    private SingerAuditRepository singerAuditRepository;

    @Transactional(readOnly=true)
    public List<SingerAudit> findAll() {
        return Lists.newArrayList(singerAuditRepository.findAll());
    }

    public SingerAudit findById(Long id) {
        return singerAuditRepository.findById(id).orElse(null);
    }

    public SingerAudit save(SingerAudit singer) {
        return singerAuditRepository.save(singer);
    }
}
