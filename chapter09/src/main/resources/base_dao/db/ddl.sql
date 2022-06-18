CREATE USER 'test1'@'localhost' IDENTIFIED BY 'test1';
CREATE SCHEMA MUSICDB9_1;
GRANT ALL PRIVILEGES ON MUSICDB9_1 . * TO 'test1'@'localhost';
FLUSH PRIVILEGES;

CREATE USER 'test2'@'localhost' IDENTIFIED BY 'test2';
CREATE SCHEMA MUSICDB9_2;
GRANT ALL PRIVILEGES ON MUSICDB9_2 . * TO 'test2'@'localhost';
FLUSH PRIVILEGES;


/*in case of java.sql.SQLException: The server timezone value 'UTC' is unrecognized or represents more than one timezone. */
SET GLOBAL time_zone = '+3:00';