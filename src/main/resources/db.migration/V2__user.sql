drop table if exists user;

CREATE TABLE user (
                      id VARCHAR(36) NOT NULL,
                      email VARCHAR(30) NOT NULL,
                      password VARCHAR(100) NOT NULL,
                      first_name VARCHAR(20) NOT NULL,
                      last_name VARCHAR(20) NOT NULL,
                      role enum ('user', 'admin', 'critic') not null;
                      version INTEGER NOT NULL,
                      PRIMARY KEY (id)
);
