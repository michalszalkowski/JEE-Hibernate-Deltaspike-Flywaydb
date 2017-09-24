CREATE TABLE post (
	id serial NOT NULL,
	name character varying NOT NULL,
	CONSTRAINT standard_text_pk PRIMARY KEY (id)
) WITH (
	OIDS=FALSE
);
ALTER TABLE post OWNER TO postgres;