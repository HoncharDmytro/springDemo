insert into MUSICDB8.SINGER (FIRST_NAME, LAST_NAME, BIRTH_DATE) values ('John', 'Mayer', '1977-10-16');
insert into MUSICDB8.SINGER (FIRST_NAME, LAST_NAME, BIRTH_DATE) values ('Eric', 'Clapton', '1945-03-30');
insert into MUSICDB8.SINGER (FIRST_NAME, LAST_NAME, BIRTH_DATE) values ('John', 'Butler', '1975-04-01');

insert into MUSICDB8.ALBUM (SINGER_ID, TITLE, RELEASE_DATE) values (1, 'The Search For Everything', '2017-01-20');
insert into MUSICDB8.ALBUM (SINGER_ID, TITLE, RELEASE_DATE) values (1, 'Battle Studies', '2009-11-17');
insert into MUSICDB8.ALBUM (SINGER_ID, TITLE, RELEASE_DATE) values (2, 'From The Cradle ', '1994-09-13');


insert into MUSICDB8.INSTRUMENT (INSTRUMENT_ID) values ('Guitar');
insert into MUSICDB8.INSTRUMENT (INSTRUMENT_ID) values ('Piano');
insert into MUSICDB8.INSTRUMENT (INSTRUMENT_ID) values ('Voice');
insert into MUSICDB8.INSTRUMENT (INSTRUMENT_ID) values ('Drums');
insert into MUSICDB8.INSTRUMENT (INSTRUMENT_ID) values ('Synthesizer');

insert into MUSICDB8.SINGER_INSTRUMENT(SINGER_ID, INSTRUMENT_ID) values (1, 'Guitar');
insert into MUSICDB8.SINGER_INSTRUMENT(SINGER_ID, INSTRUMENT_ID) values (1, 'Piano');
insert into MUSICDB8.SINGER_INSTRUMENT(SINGER_ID, INSTRUMENT_ID) values (2, 'Guitar');