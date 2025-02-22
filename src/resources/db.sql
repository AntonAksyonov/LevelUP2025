create table classes
(
    id         serial primary key,
    short_name varchar(15) not null,
    name       varchar(50) not null
);

create table types
(
    id         serial primary key,
    short_name varchar(15) not null,
    name       varchar(50) not null
);

create table methods
(
    id             serial primary key,
    class          bigint  not null
        constraint methods_classes_id_fk references classes,
    short_name     varchar(15) not null,
    name           varchar(50) not null,
    type           bigint  not null
        constraint methods_types_id_fk references types,
    launched_users boolean
);

alter table methods add constraint unique_methods unique (class, short_name);

/*******************************************************/

insert into types (short_name, name)
values ('simple', 'Простая');

insert into types (short_name, name)
values ('group', 'Групповая');

insert into types (short_name, name)
values ('list', 'Списочная');

/*******************************************************/

insert into classes (short_name, name)
values ('accounts', 'Счета');

insert into classes (short_name, name)
values ('clients', 'Клиенты');

insert into classes (short_name, name)
values ('addresses', 'Адреса');

/*******************************************************/

insert into methods (class, short_name, name, type, launched_users)
values (1, 'add', 'Добавить счёт', 1, true);

insert into methods (class, short_name, name, type, launched_users)
values (1, 'delete', 'Удалить счёт', 1, true);

insert into methods (class, short_name, name, type, launched_users)
values (1, 'report', 'Отчёт по счетам (групповая)', 2, false);

insert into methods (class, short_name, name, type, launched_users)
values (1, 'reports', 'Отчёт по счетам (списочная)', 3, true);

/*******************************************************/

insert into methods (class, short_name, name, type, launched_users)
values (2, 'add', 'Добавить клиента', 1, true);

insert into methods (class, short_name, name, type, launched_users)
values (2, 'edit', 'Изменить клиента', 1, true);


select cl.name, met.name, typ.name
from methods met
         join classes cl on met.class = cl.id
         join types typ on met.type = typ.id
where met.launched_users is false;

select cl.name, met.*
from classes cl
         left join methods met on met.class = cl.id
         left join types typ on met.type = typ.id;

select
    cl.name as "Класс",
    met.name as "Операция",
    typ.name as "Тип операции",
    count(met.id) over (partition by met.class, met.type) as "Количество операций типа в классе"
from methods met
         join classes cl on met.class = cl.id
         join types typ on met.type = typ.id
where met.launched_users is true;