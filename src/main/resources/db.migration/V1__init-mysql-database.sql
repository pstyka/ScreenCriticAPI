drop table if exists movie;
drop table if exists category;

CREATE TABLE category (
                          id VARCHAR(36) NOT NULL,
                          name VARCHAR(50) NOT NULL,
                          PRIMARY KEY (id)
);

CREATE TABLE movie (
                       id VARCHAR(36) NOT NULL,
                       movie_name VARCHAR(30) NOT NULL,
                       movie_description VARCHAR(300) NOT NULL,
                       movie_director VARCHAR(40) NOT NULL,
                       movie_release_date INT,
                       movie_average_rating FLOAT,
                       version INT,
                       movie_category_id VARCHAR(36),
                       PRIMARY KEY (id),
                       CONSTRAINT fk_movie_category FOREIGN KEY (movie_category_id) REFERENCES category(id)
);