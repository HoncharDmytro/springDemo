package com.honchar.springDemo.chapter07.hibernate_base;

//import com.honchar.springDemo.chapter07.hibernate_base.config.AppConfig;
import com.honchar.springDemo.chapter07.hibernate_base.dao.SingerDao;
import com.honchar.springDemo.chapter07.hibernate_base.entities.Album;
import com.honchar.springDemo.chapter07.hibernate_base.entities.Singer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBase {
    private static final Logger logger = LoggerFactory.getLogger(TestBase.class);

    //private GenericApplicationContext ctx;
    private GenericXmlApplicationContext ctx;
    private SingerDao singerDao;

    @BeforeAll
    public void setUp(){
        //ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        //singerDao = ctx.getBean(SingerDao.class);
        // OR //
        ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:app-context2.xml");
        ctx.refresh();
        //1111111111111111111111111111111111111

        singerDao = ctx.getBean(SingerDao.class); //or ("singerDao", SingerDao.class) its same!
        assertNotNull(singerDao);
    }

    @Test
    public void testFindAll(){
        List<Singer> singers = singerDao.findAll();
        assertEquals(3, singers.size());
        listSingers(singers);
    }

    @Test
    public void testFindAllWithAlbum(){
        List<Singer> singers = singerDao.findAllWithAlbum();
        assertEquals(3, singers.size());
        listSingersWithAlbum(singers);
    }

    @Test
    public void testFindByID(){
        Singer  singer = singerDao.findById(1L);
        assertNotNull(singer);
        logger.info(singer.toString());
    }

    @Test
    public void testInsert(){
        Singer singer = new Singer();
        singer.setFirstName("BB");
        singer.setLastName("King");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1940, 8, 16)).getTime().getTime()));

        Album album = new Album();
        album.setTitle("My Kind of Blues");
        album.setReleaseDate(new java.sql.Date(
                (new GregorianCalendar(1961, 7, 18)).getTime().getTime()));
        singer.addAlbum(album);

        album = new Album();
        album.setTitle("A Heart Full of Blues");
        album.setReleaseDate(new java.sql.Date(
                (new GregorianCalendar(1962, 3, 20)).getTime().getTime()));
        singer.addAlbum(album);

        singerDao.save(singer);
        assertNotNull(singer.getId());

        List<Singer> singers = singerDao.findAllWithAlbum();
        assertEquals(4, singers.size());
        listSingersWithAlbum(singers);
    }

    @Test
    public void testUpdate(){
        Singer singer = singerDao.findById(1L);
        assertNotNull(singer);
        assertEquals("Mayer", singer.getLastName());
        Album album = singer.getAlbums().stream().filter(a -> a.getTitle().equals("Battle Studies")).findFirst()
                .get();

        singer.setFirstName("John Clayton");
        singer.removeAlbum(album);
        singerDao.save(singer);

        listSingersWithAlbum(singerDao.findAllWithAlbum());
    }

    @Test
    public void testDelete(){
        Singer singer = singerDao.findById(2L);
        assertNotNull(singer);
        singerDao.delete(singer);

        listSingersWithAlbum(singerDao.findAllWithAlbum());
    }


    private static void listSingers(List<Singer> singers) {
        logger.info(" ---- Listing singers:");
        singers.forEach(singer -> logger.info(singer.toString()));
    }

    private static void listSingersWithAlbum(List<Singer> singers) {
        logger.info(" ---- Listing singers with instruments:");
        singers.forEach(singer -> {
            logger.info(singer.toString());
            if (singer.getAlbums() != null) {
                singer.getAlbums().forEach(album -> logger.info("\t" + album.toString()));
            }
            if (singer.getInstruments() != null) {
                //singer.getInstruments().forEach(Instrument::getInstrumentId);
                singer.getInstruments().forEach(instrument -> instrument.getInstrumentId());
            }
        });
    }

    @AfterAll
    public void tearDown(){
        ctx.close();
    }

}