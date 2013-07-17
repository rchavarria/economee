# Tasks schema
 
# --- !Ups

CREATE SEQUENCE task_id_seq;
CREATE TABLE task (
    id INT NOT NULL DEFAULT nextval('task_id_seq'),
    label VARCHAR(255)
);

# --- !Downs
 
DROP TABLE task;
DROP SEQUENCE task_id_seq;
