# Tasks schema
 
# --- !Ups

CREATE SEQUENCE task_id_seq;
CREATE TABLE task (
    id INT NOT NULL DEFAULT nextval('task_id_seq'),
    label VARCHAR(255)
);

CREATE SEQUENCE movement_id_seq;
CREATE TABLE movement (
	id INT NOT NULL DEFAULT nextval('movement_id_seq'),
	concept VARCHAR(255) NOT NULL,
	date BIGINT NOT NULL,
	amount BIGINT NOT NULL
);

INSERT INTO movement (concept, date, amount) VALUES ('primer conceto', 1122334455, 12345);
INSERT INTO movement (concept, date, amount) VALUES ('secondo conceto', 1122334457, 54321);

# --- !Downs
 
DROP TABLE task;
DROP SEQUENCE task_id_seq;

DROP TABLE movement;
DROP SEQUENCE movement_id_seq;
