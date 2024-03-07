# DATABASE-SYSTEM-LAB

# To start the php server 

php -S localhost:8000

# To start the apache server 
sudo systemctl start httpd.service

# To stop the apache server 

sudo systemctl stop httpd.service


# To enter into the databse

sudo mysql -u root -p

password:1234

# To see database 

SHOW DATABASES;

# To create databse 

CREATE DATABASE IF NOT EXISTS new_database;

# To see the tables in that database 

SHOW TABLES;

# To see the structure of the particular table

DESCRIBE users(table name)

# To see the values in the tables 

SELECT * FROM users

# To enter into that database;

USE new_database;

# To SEE THWE PORT on which  runing
SHOW VARIABLES LIKE 'port';
