CREATE TABLE person (
  id SERIAL,
  address varchar(100) NOT NULL,
  frist_name varchar(80) NOT NULL,
  gender varchar(6) NOT NULL,
  last_name varchar(80) NOT NULL,
  PRIMARY KEY (id)
);