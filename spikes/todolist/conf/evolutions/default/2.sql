# Movements schema
 
# --- !Ups

CREATE SEQUENCE movement_id_seq;
CREATE TABLE movement (
	id INT NOT NULL DEFAULT nextval('movement_id_seq'),
	concept VARCHAR(255) NOT NULL,
	date BIGINT NOT NULL,
	amount BIGINT NOT NULL
);

# --- !Downs
 
DROP TABLE movement;
DROP SEQUENCE movement_id_seq;
