package com.honchar.springDemo.chapter08.jpa.hibernate_envers.repos;

import com.honchar.springDemo.chapter08.jpa.hibernate_envers.entities.SingerAudit;
import org.springframework.data.repository.CrudRepository;

public interface SingerAuditRepository extends CrudRepository<SingerAudit, Long> {
}
