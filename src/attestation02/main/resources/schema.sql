-- Создание таблицы Товар Товар (id, описание, стоимость, количество)
CREATE TABLE IF NOT EXISTS product (
    id SERIAL PRIMARY KEY,
    description VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INTEGER NOT NULL
);

COMMENT ON TABLE product IS 'Таблица для хранения информации о товарах';

-- Создание таблицы Покупатель (id, имя/фамилия)
CREATE TABLE IF NOT EXISTS customer (
    id SERIAL PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL
);

COMMENT ON TABLE customer IS 'Таблица для хранения информации о покупателях';

-- Создание таблицы Заказ (id-товара (внешний ключ), id-заказчика (внешний ключ), дата заказа, количество товаров)
CREATE TABLE IF NOT EXISTS order_info (
    id SERIAL PRIMARY KEY,
    product_id INTEGER REFERENCES product(id),
    customer_id INTEGER REFERENCES customer(id),
    order_date DATE NOT NULL DEFAULT CURRENT_DATE,
    quantity INTEGER NOT NULL
);

COMMENT ON TABLE order_info IS 'Таблица для хранения информации о заказах';

-- Заполнение таблицы Товар
INSERT INTO product (description, price, quantity) VALUES
('Ноутбук', 50000.00, 10),
('Смартфон', 30000.00, 15),
('Наушники', 5000.00, 20),
('Клавиатура', 2000.00, 30),
('Мышь', 1000.00, 40),
('Монитор', 25000.00, 8),
('Принтер', 15000.00, 5),
('Сканер', 12000.00, 7),
('Флеш-накопитель', 800.00, 50),
('Внешний жесткий диск', 5000.00, 12);

-- Заполнение таблицы Покупатель
INSERT INTO customer (full_name) VALUES
('Иванов Иван Иванович'),
('Петров Петр Петрович'),
('Сидорова Анна Михайловна'),
('Кузнецова Елена Владимировна'),
('Смирнов Алексей Дмитриевич'),
('Васильева Ольга Сергеевна'),
('Николаев Денис Андреевич'),
('Павлова Марина Олеговна'),
('Федоров Сергей Николаевич'),
('Александрова Татьяна Игоревна');

-- Заполнение таблицы Заказ
INSERT INTO order_info (product_id, customer_id, order_date, quantity) VALUES
(1, 1, '2023-01-15', 1),
(2, 2, '2023-01-16', 2),
(3, 3, '2023-01-17', 1),
(4, 4, '2023-01-18', 3),
(5, 5, '2023-01-19', 2),
(6, 6, '2023-01-20', 1),
(7, 7, '2023-01-21', 1),
(8, 8, '2023-01-22', 1),
(9, 9, '2023-01-23', 5),
(10, 10, '2023-01-24', 2);