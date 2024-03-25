
    drop table if exists category;

    drop table if exists movie;

    drop table if exists user;

    create table category (
        id varchar(36) not null,
        name varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table movie (
        movie_average_rating float(23) not null,
        movie_release_date integer not null,
        version integer,
        id varchar(36) not null,
        movie_director varchar(40) not null,
        movie_name varchar(100) not null,
        movie_description varchar(300) not null,
        movie_category_id varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table user (
        id varchar(36) not null,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        username varchar(255),
        role enum ('USER','ADMIN','CRITIC'),
        primary key (id)
    ) engine=InnoDB;

    drop table if exists category;

    drop table if exists movie;

    drop table if exists user;

    create table category (
        id varchar(36) not null,
        name varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table movie (
        movie_average_rating float(23) not null,
        movie_release_date integer not null,
        version integer,
        id varchar(36) not null,
        movie_director varchar(40) not null,
        movie_name varchar(100) not null,
        movie_description varchar(300) not null,
        movie_category_id varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table user (
        id varchar(36) not null,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        username varchar(255),
        role enum ('USER','ADMIN','CRITIC'),
        primary key (id)
    ) engine=InnoDB;

    drop table if exists category;

    drop table if exists movie;

    drop table if exists user;

    create table category (
        id varchar(36) not null,
        name varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table movie (
        movie_average_rating float(23) not null,
        movie_release_date integer not null,
        version integer,
        id varchar(36) not null,
        movie_director varchar(40) not null,
        movie_name varchar(100) not null,
        movie_description varchar(300) not null,
        movie_category_id varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table user (
        id varchar(36) not null,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        username varchar(255),
        role enum ('USER','ADMIN','CRITIC'),
        primary key (id)
    ) engine=InnoDB;

    drop table if exists category;

    drop table if exists movie;

    drop table if exists user;

    create table category (
        id varchar(36) not null,
        name varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table movie (
        movie_average_rating float(23) not null,
        movie_release_date integer not null,
        version integer,
        id varchar(36) not null,
        movie_director varchar(40) not null,
        movie_name varchar(100) not null,
        movie_description varchar(300) not null,
        movie_category_id varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table user (
        id varchar(36) not null,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        username varchar(255),
        role enum ('USER','ADMIN','CRITIC'),
        primary key (id)
    ) engine=InnoDB;

    drop table if exists category;

    drop table if exists movie;

    drop table if exists user;

    create table category (
        id varchar(36) not null,
        name varchar(50) not null,
        primary key (id)
    ) engine=InnoDB;

    create table movie (
        movie_average_rating float(23) not null,
        movie_release_date integer not null,
        version integer,
        id varchar(36) not null,
        movie_director varchar(40) not null,
        movie_name varchar(100) not null,
        movie_description varchar(300) not null,
        movie_category_id varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table user (
        id varchar(36) not null,
        first_name varchar(255),
        last_name varchar(255),
        password varchar(255),
        username varchar(255),
        role enum ('USER','ADMIN','CRITIC'),
        primary key (id)
    ) engine=InnoDB;
