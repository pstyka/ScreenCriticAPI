drop table if exists movie;

create table movie (
    id varchar(36) not null,
    movie_name varchar(50) not null,
    movie_category smallint not null,
    movie_description varchar(300) not null,
    movie_director varchar(40) not null,
    movie_release_date integer,
    movie_avg_rating float,
    version integer,
    primary key (id)
) engine=InnoDB;