create table character
(
    id            uuid primary key,
    name          varchar(100) not null,
    gender        varchar(8)   not null,
    visual_config jsonb        not null
);