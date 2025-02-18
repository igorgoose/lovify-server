create table default_config
(
    gender        VARCHAR(8) NOT NULL,
    visual_config jsonb      NOT NULL,
    constraint pk_default_config_id primary key (gender)
);