create table cities
(
    id         serial
        constraint cities_pk
            primary key,
    code       varchar(50)
        constraint cities_code_uidx
            unique,
    name_en    varchar(50),
    name_ru    varchar(50),
    population bigint,
    region_id  integer
        constraint cities_regions_id_fk
            references regions
);

alter table cities
    owner to postgres;

--------------------------------
-- Data
--------------------------------
INSERT INTO public.cities (id, code, name_en, name_ru, population, region_id) VALUES (3, '495', 'Moskva', 'Москва', 13300000, 999);
INSERT INTO public.cities (id, code, name_en, name_ru, population, region_id) VALUES (1, '4912', 'Razan', 'Рязань', 539290, 62);

