CREATE TABLE IF NOT EXISTS your_table
(
    id              UUID            NOT NULL,
    creation_time   TIMESTAMP       NOT NULL    DEFAULT now(),
    update_time     TIMESTAMP       NOT NULL    DEFAULT now(),
    CONSTRAINT email_pk PRIMARY KEY (id)
);
