-- HIBERNATE
CREATE SEQUENCE public.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE public.hibernate_sequence OWNER TO postgres;

INSERT INTO person (id, address, frist_name, gender, last_name) VALUES
	(1, 'Uberlândia - Minas Gerais - Brasil', 'Leandro', 'Male', 'Costa'),
	(2, 'Uberlândia - Minas Gerais - Brasil', 'Gabriela', 'Female', 'Costa'),
	(3, 'Patos de Minas - Minas Gerais - Brasil', 'Flávio', 'Male', 'Costa'),
	(4, 'Uberlândia - Minas Gerais - Brasil', 'Fernanda', 'Female', 'Cardoso da Silva'),
	(5, 'Patos de Minas - Minas Gerais - Brasil', 'Pedro', 'Male', 'Paulo'),
	(6, 'Patos de Minas - Minas Gerais - Brasil', 'Marcos', 'Male', 'Paulo');

ALTER SEQUENCE hibernate_sequence RESTART WITH 10;