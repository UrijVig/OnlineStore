CREATE SCHEMA if not exists product;

CREATE TABLE product.flavoring (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) DEFAULT 'coming soon'
);

CREATE TABLE product.candlestick (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    volume INTEGER DEFAULT 200 CHECK (volume >= 0),
    material VARCHAR(255) DEFAULT 'coming soon',
    description VARCHAR(255) DEFAULT 'coming soon',
    lid BOOLEAN DEFAULT FALSE
);

CREATE TABLE product.wax (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) DEFAULT 'coming soon'
);

CREATE TABLE product.candles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) DEFAULT 'coming soon',
    candlestick_id INTEGER REFERENCES candlestick(id),
    flavoring_id INTEGER REFERENCES flavoring(id),
    wax_id INTEGER REFERENCES wax(id),
    image_link VARCHAR(255) DEFAULT 'https://basket-03.wbbasket.ru/vol338/part33862/33862848/images/big/1.webp',
    amount INTEGER DEFAULT 0 CHECK (amount >= 0),
    price float NOT NULL CHECK (price >= 0)
);

Create TABLE product.orders (
    id SERIAL PRIMARY KEY,
    username VARCHAR(25) NOT NULL,
    comment VARCHAR(100),
    status VARCHAR(20) NOT NULL,
    price float NOT NULL CHECK  (price  >=  0),

);

CREATE TABLE product.order_products  (
    id SERIAL PRIMARY KEY,
    order_id INTEGER REFERENCES orders(id) ON DELETE CASCADE,
    product_id INTEGER REFERENCES candles(id),
    quantity INT NOT NULL DEFAULT 1 CHECK  (quantity  >=  1)
);