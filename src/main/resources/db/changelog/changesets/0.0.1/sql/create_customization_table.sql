create table customization
(
    id       uuid,
    gender   varchar(8)   not null,
    type     varchar(32)  not null,
    icon_url varchar(255) not null,
    params   jsonb        not null,
    constraint pk_customization_id primary key (id)
);
