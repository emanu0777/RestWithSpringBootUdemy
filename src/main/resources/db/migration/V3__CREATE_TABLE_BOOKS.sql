CREATE TABLE books (
  id SERIAL,
  author text NOT NULL,
  launch_date timestamp NOT NULL,
  price numeric(65,2) NOT NULL,
  title text NOT NULL,
  PRIMARY KEY (id)
);