CREATE TABLE address
(
  addressname character varying(255) NOT NULL,
  street character varying(255) NOT NULL,
  postcode character varying(6) NOT NULL
)
WITH (
  OIDS=FALSE
);
ALTER TABLE address
  OWNER TO postgres;