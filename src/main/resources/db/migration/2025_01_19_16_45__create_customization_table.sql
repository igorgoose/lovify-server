create table customization
(
    id       uuid primary key,
    gender   varchar(8)   not null,
    type     varchar(32)  not null,
    icon_url varchar(255) not null
);
