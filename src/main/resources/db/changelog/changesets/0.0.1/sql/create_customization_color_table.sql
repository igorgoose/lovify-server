create table customization_color
(
    id                  uuid,
    customization_types varchar(32) not null,
    hex                 varchar(7)  not null,
    constraint pk_color_id primary key (id),
    constraint uq_customization_type unique (customization_types)
);
