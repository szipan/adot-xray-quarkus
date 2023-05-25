create DATABASE test;

use test;

CREATE TABLE IF NOT EXISTS `students`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100) NOT NULL,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO students ( name )
VALUES( "Tom" );