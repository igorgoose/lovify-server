create table customization
(
    id       uuid,
    gender   varchar(8)   not null,
    type     varchar(32)  not null,
    icon_url varchar(255) not null,
    constraint pk_customization_id primary key (id),
    constraint uq_customization_type unique (type)
);
