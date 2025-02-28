create table customization_color
(
    id                  uuid,
    customization_type varchar(32) not null,
    hex                 varchar(7)  not null,
    constraint pk_color_id primary key (id),
    constraint unique_color_for_type unique (customization_type, hex)
);
