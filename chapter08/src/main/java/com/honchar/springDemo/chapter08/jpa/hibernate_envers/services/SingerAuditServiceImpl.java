package com.honchar.springDemo.chapter08.jpa.hibernate_envers.services;

import com.google.common.collect.Lists;
import com.honchar.springDemo.chapter08.jpa.hibernate_envers.entities.SingerAudit;
import com.honchar.springDemo.chapter08.jpa.hibernate_envers.repos.SingerAuditRepository;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service("singerAuditService")
@Transactional
public class SingerAuditServiceImpl implements SingerAuditService {

	@Autowired
	private SingerAuditRepository singerAuditRepository;

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional(readOnly = true)
	public List<SingerAudit> findAll() {
		return Lists.newArrayList(singerAuditRepository.findAll());
	}

	public SingerAudit findById(Long id) {
		return singerAuditRepository.findById(id).orElse(null);
	}

	public SingerAudit save(SingerAudit singer) {
		return singerAuditRepository.save(singer);
	}

	@Transactional(readOnly = true)
	@Override
	public SingerAudit findAuditByRevision(Long id, int revision) {
		AuditReader auditReader = AuditReaderFactory.get(entityManager);
		return auditReader.find(SingerAudit.class, id, revision);
	}
}
