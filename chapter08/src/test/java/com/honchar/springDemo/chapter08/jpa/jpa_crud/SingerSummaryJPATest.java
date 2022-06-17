package com.honchar.springDemo.chapter08.jpa.jpa_crud;

import com.honchar.springDemo.chapter08.jpa.jpa_crud.config.JpaConfig;
import com.honchar.springDemo.chapter08.jpa.jpa_crud.dao.SingerSummaryService;
import com.honchar.springDemo.chapter08.jpa.jpa_crud.dao.SingerSummaryUntypeImpl;
import com.honchar.springDemo.chapter08.jpa.jpa_crud.view.SingerSummary;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SingerSummaryJPATest {

    private static final Logger logger = LoggerFactory.getLogger(SingerSummaryJPATest.class);
    private GenericApplicationContext ctx;
    private SingerSummaryService singerSummaryService;
    private SingerSummaryUntypeImpl singerSummaryUntype;

    @BeforeAll
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
        singerSummaryService = ctx.getBean(SingerSummaryService.class);
        singerSummaryUntype = ctx.getBean(SingerSummaryUntypeImpl.class);
        assertNotNull(singerSummaryService);
        assertNotNull(singerSummaryUntype);
    }

    @Test
    public void testFindAll() {
        List<SingerSummary> singers = singerSummaryService.findAll();
        listSingerSummary(singers);
        assertEquals(2, singers.size());
    }

    @Test
    public void testFindAllUntype() {
        singerSummaryUntype.displayAllSingerSummary();
    }

    private static void listSingerSummary(List<SingerSummary> singers) {
        logger.info(" ---- Listing singers summary:");
        for (SingerSummary singer : singers) {
            logger.info(singer.toString());
        }
    }

    @AfterAll
    public void tearDown() {
        ctx.close();
    }
}