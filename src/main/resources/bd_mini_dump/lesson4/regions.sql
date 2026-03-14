create table regions
(
    id             serial
        constraint regions_pk
            primary key,
    region_code    varchar(50)
        constraint regions_code_uniq
            unique,
    region_name_en varchar(50)
);

alter table regions
    owner to postgres;

--------------------------------
-- Data
--------------------------------
INSERT INTO public.regions (id, region_code, region_name_en) VALUES (2, '77', 'Moscow region');
INSERT INTO public.regions (id, region_code, region_name_en) VALUES (3, '666', 'Not Moscow');

