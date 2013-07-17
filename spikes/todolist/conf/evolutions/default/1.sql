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
	concept VARCHAR(255) NOT NULL
);

INSERT INTO movement (concept) VALUES ('primer conceto');
INSERT INTO movement (concept) VALUES ('secondo conceto');

# --- !Downs
 
DROP TABLE task;
DROP SEQUENCE task_id_seq;

DROP TABLE movement;
DROP SEQUENCE movement_id_seq;
