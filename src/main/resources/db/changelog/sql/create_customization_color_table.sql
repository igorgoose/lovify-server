create table customization_color
(
    id                 uuid,
    customization_type varchar(8) not null,
    hex                varchar(7) not null,
    constraint pk_color_id primary key (id),
    constraint fk_color_customization_type foreign key (customization_type) references customization (type)
);
