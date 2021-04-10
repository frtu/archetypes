create table if not exists your_table
(
    id              long            primary key,
    creation_time   timestamp       not null,
    update_time     timestamp       not null
);
