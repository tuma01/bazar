CREATE USER 'tuma'@'localhost' IDENTIFIED BY 'bolivia';
GRANT ALL PRIVILEGES ON *.* TO 'tuma'@'localhost' WITH GRANT OPTION;
CREATE USER 'tuma'@'127.0.0.1' IDENTIFIED BY 'bolivia';
GRANT ALL PRIVILEGES ON *.* TO 'tuma'@'127.0.0.1' WITH GRANT OPTION;
commit;