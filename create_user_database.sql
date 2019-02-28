Create database runthecode;
CREATE USER 'admin'@'localhost' IDENTIFIED BY 'adminuser';
grant select, insert, delete, update on runthecode.* to 'admin'@'localhost';
GRANT ALL ON *.* TO  'admin'@'localhost';