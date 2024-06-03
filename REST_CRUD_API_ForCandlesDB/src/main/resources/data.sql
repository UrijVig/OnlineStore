INSERT INTO wax (name) values
('coconut'),
('soy');

INSERT INTO candlestick (name) values
('gypsum'),
('glass');

INSERT INTO flavoring (name) values
('vanila'),
('granat');

INSERT INTO candles (name, candlestick_id, flavoring_id, wax_id, price) VALUES
('Lavanda',1,1,1, 5.7),
('Vanila',1,1,1, 2.4),
('Rose',1,1,1, 1.1),
('Pancake',1,1,1, 0.5);