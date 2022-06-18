package chapter06.spring_jdbc_annotations;

import com.honchar.springDemo.chapter06.simple_jdbc.dao.SingerDao;
import com.honchar.springDemo.chapter06.simple_jdbc.entities.Album;
import com.honchar.springDemo.chapter06.simple_jdbc.entities.Singer;
import com.honchar.springDemo.chapter06.spring_jdbc_annotations.config.AppConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Disabled
public class AnnotationJdbcTest {

    private GenericApplicationContext ctx;
    private SingerDao singerDao;

    @BeforeAll
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        singerDao = ctx.getBean(SingerDao.class);
        assertNotNull(singerDao);
    }

    @Test
    public void testFindAll() {
        List<Singer> singers = singerDao.findAll();
        assertTrue(singers.size() == 5);
        listSingers(singers);
        ctx.close();
    }

    @Test
    public void testFindByFirstName() {
        List<Singer> singers = singerDao.findByFirstName("John");
        assertTrue(singers.size() == 1);
        listSingers(singers);
        ctx.close();
    }

    @Test
    public void testSingerUpdate() {
        Singer singer = new Singer();
        singer.setId(2L);
        singer.setFirstName("Van");
        singer.setLastName("Mayer");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1977, Calendar.OCTOBER, 16)).getTime().getTime()));
        singerDao.update(singer);

        List<Singer> singers = singerDao.findAll();
        listSingers(singers);
    }

    @Test
    public void testSingerInsert(){
        Singer singer = new Singer();
        singer.setFirstName("Ed");
        singer.setLastName("Sheeran");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1991, Calendar.FEBRUARY, 17)).getTime().getTime()));
        singerDao.insert(singer);

        List<Singer> singers = singerDao.findAll();
        listSingers(singers);
    }

    @Test
    public void testSingerInsertWithAlbum(){
        Singer singer = new Singer();
        singer.setFirstName("BB");
        singer.setLastName("King");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1940, Calendar.SEPTEMBER, 16)).getTime().getTime()));

        Album album = new Album();
        album.setTitle("My Kind of Blues");
        album.setReleaseDate(new Date(
                (new GregorianCalendar(1961, Calendar.AUGUST, 18)).getTime().getTime()));
        singer.addAlbum(album);

        album = new Album();
        album.setTitle("A Heart Full of Blues");
        album.setReleaseDate(new Date(
                (new GregorianCalendar(1962, Calendar.APRIL, 20)).getTime().getTime()));
        singer.addAlbum(album);

        singerDao.insertWithAlbum(singer);

        List<Singer> singers = singerDao.findAllWithAlbums();
        listSingers(singers);
    }

    @Test
    public void testFindFirstNameById(){
        String firstName = singerDao.findFirstNameById(2L);
        assertEquals("Van", firstName);
        System.out.println("Retrieved value: " + firstName);
    }

    private void listSingers(List<Singer> singers){
        singers.forEach(singer -> {
            System.out.println(singer);
            if (singer.getAlbums() != null) {
                for (Album album : singer.getAlbums()) {
                    System.out.println("\t--> " + album);
                }
            }
        });
    }

    @AfterAll
    public void tearDown() {
        ctx.close();
    }
}