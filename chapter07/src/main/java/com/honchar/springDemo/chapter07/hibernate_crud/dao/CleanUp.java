package com.honchar.springDemo.chapter07.hibernate_crud.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class CleanUp {
    private static final Logger logger = LoggerFactory.getLogger(CleanUp.class);

    private final JdbcTemplate jdbcTemplate;

    public CleanUp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private void destroy() {
        logger.info(" ... Deleting database files.");
        jdbcTemplate.execute("TRUNCATE musicdb7.album, musicdb7.instrument, musicdb7.singer," +
                " musicdb7.singer_instrument;");//"DROP ALL OBJECTS DELETE FILES;"
    }
}