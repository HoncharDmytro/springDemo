package com.honchar.springDemo.chapter07.hibernate_crud.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class CleanUp {
    private static Logger logger = LoggerFactory.getLogger(CleanUp.class);

    private JdbcTemplate jdbcTemplate;

    public CleanUp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private void destroy() {
        logger.info(" ... Deleting database files.");
        jdbcTemplate.execute("TRUNCATE album, instrument, singer, singer_instrument;");
    }
}