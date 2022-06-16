package com.honchar.springDemo.chapter08.jpa.spring_data_jpa_audit.repos;

import com.honchar.springDemo.chapter08.jpa.spring_data_jpa_audit.entities.SingerAudit;
import org.springframework.data.repository.CrudRepository;

public interface SingerAuditRepository extends CrudRepository<SingerAudit, Long> {
}
