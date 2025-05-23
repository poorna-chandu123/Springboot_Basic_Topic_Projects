CREATE TABLE users (
    username VARCHAR(50) COLLATE NOCASE NOT NULL PRIMARY KEY,
    password VARCHAR(500) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
    username VARCHAR(50) COLLATE NOCASE NOT NULL,
    authority VARCHAR(50) COLLATE NOCASE NOT NULL,
    CONSTRAINT fk_authorities_users 
        FOREIGN KEY(username) 
        REFERENCES users(username) 
        ON DELETE CASCADE
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);
