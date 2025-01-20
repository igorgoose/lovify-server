create table character
(
    id            uuid,
    name          varchar(100) not null,
    gender        varchar(8)   not null,
    visual_config jsonb        not null,
    constraint pk_character_id primary key (id)
);
