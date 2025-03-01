create table cities
(
    id              serial primary key,
    code            varchar(15) not null,
    name            varchar(50) not null,
    english_name    varchar(50) not null,
    population      int
);