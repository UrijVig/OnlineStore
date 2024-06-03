CREATE TABLE flavoring (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) DEFAULT 'coming soon'
);

CREATE TABLE candlestick (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    volume INTEGER DEFAULT 200,
    material VARCHAR(255) DEFAULT 'coming soon',
    description VARCHAR(255) DEFAULT 'coming soon',
    lid BOOLEAN DEFAULT FALSE
);

CREATE TABLE wax (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) DEFAULT 'coming soon'
);

CREATE TABLE candles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) DEFAULT 'coming soon',
    candlestick_id INTEGER REFERENCES candlestick(id),
    flavoring_id INTEGER REFERENCES flavoring(id),
    wax_id INTEGER REFERENCES wax(id),
    image_link VARCHAR(255) DEFAULT 'https://basket-03.wbbasket.ru/vol338/part33862/33862848/images/big/1.webp',
    amount INTEGER DEFAULT 0,
    price float NOT NULL
);
