create table classes
(
    id         serial primary key,
    short_name varchar not null,
    name       varchar not null
);

create table types
(
    id         serial primary key,
    short_name varchar not null,
    name       varchar not null
);

create table methods
(
    id             serial primary key,
    class          bigint  not null
        constraint methods_classes_id_fk references classes,
    short_name     varchar not null,
    name           varchar not null,
    type           bigint  not null
        constraint methods_types_id_fk references types,
    launched_users boolean
);

alter table methods add constraint unique_methods unique (class, short_name);

/*******************************************************/

insert into types (id, short_name, name)
values (0, 'simple', 'Простая');

insert into types (id, short_name, name)
values (1, 'group', 'Групповая');

insert into types (id, short_name, name)
values (2, 'list', 'Списочная');

/*******************************************************/

insert into classes (id, short_name, name)
values (0, 'accounts', 'Счета');

insert into classes (id, short_name, name)
values (1, 'clients', 'Клиенты');

insert into classes (id, short_name, name)
values (2, 'addresses', 'Адреса');

/*******************************************************/

insert into methods (id, class, short_name, name, type, launched_users)
values (0, 0, 'add', 'Добавить счёт', 0, true);

insert into methods (id, class, short_name, name, type, launched_users)
values (1, 0, 'delete', 'Удалить счёт', 0, true);

insert into methods (id, class, short_name, name, type, launched_users)
values (2, 0, 'report', 'Отчёт по счетам (групповая)', 1, false);

insert into methods (id, class, short_name, name, type, launched_users)
values (3, 0, 'reports', 'Отчёт по счетам (списочная)', 2, true);

/*******************************************************/

insert into methods (id, class, short_name, name, type, launched_users)
values (4, 1, 'add', 'Добавить клиента', 0, true);

insert into methods (id, class, short_name, name, type, launched_users)
values (5, 1, 'edit', 'Изменить клиента', 0, true);


select cl.name, met.name, typ.name
from methods met
join classes cl on met.class = cl.id
join types typ on met.type = typ.id
where met.launched_users = false;

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
where met.launched_users = true;