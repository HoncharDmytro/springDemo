# CREATE USER 'username'@'host' IDENTIFIED WITH authentication_plugin BY 'password';
# plugins: auth_socket, authentication_plugin, leave out - caching_sha2_password

# CREATE USER 'username'@'localhost' IDENTIFIED BY 'password';
# CREATE USER 'username'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';
# ALTER USER 'username'@'localhost' IDENTIFIED WITH mysql_native_password BY 'password';
# GRANT PRIVILEGE ON database.table TO 'username'@'host';
# GRANT CREATE, ALTER, DROP, INSERT, UPDATE, DELETE, SELECT, REFERENCES,
#                                           RELOAD on *.* TO 'sammy'@'localhost' WITH GRANT OPTION;
# GRANT ALL PRIVILEGES ON *.* TO 'sammy'@'localhost' WITH GRANT OPTION;
# FLUSH PRIVILEGES;
# REVOKE type_of_permission ON database_name.table_name FROM 'username'@'host';
# SHOW GRANTS FOR 'username'@'host';
# DROP USER 'username'@'localhost';
# Fast login: "mysql -u sammy -p"

CREATE USER 'test1'@'localhost' IDENTIFIED BY 'test1';
#         username @ hostname                 password (caching_sha2_password)
CREATE SCHEMA MUSICDB9_1;
GRANT ALL PRIVILEGES ON MUSICDB9_1.* TO 'test1'@'localhost';
FLUSH PRIVILEGES;

CREATE USER 'test2'@'localhost' IDENTIFIED BY 'test2';
CREATE SCHEMA MUSICDB9_2;
GRANT ALL PRIVILEGES ON MUSICDB9_2.* TO 'test2'@'localhost';
FLUSH PRIVILEGES;


/*in case of java.sql.SQLException: The server timezone value 'UTC' is unrecognized or represents more than one timezone. */
SET GLOBAL time_zone = '+3:00';