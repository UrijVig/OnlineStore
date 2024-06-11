CREATE TABLE users.flavoring (
    id SERIAL PRIMARY KEY,
    username VARCHAR(25) NOT NULL unique,
    password VARCHAR(25) NOT NULL,
    roles VARCHAR(25) DEFAULT 'USER',
);