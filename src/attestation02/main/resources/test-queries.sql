-- Запросы на чтение данных

-- 1. Получить список всех товаров
SELECT * FROM product;

-- 2. Получить список всех покупателей
SELECT * FROM customer;

-- 3. Получить список всех заказов с информацией о товаре и покупателе
SELECT o.id, p.description, c.full_name, o.order_date, o.quantity
FROM order_info o
JOIN product p ON o.product_id = p.id
JOIN customer c ON o.customer_id = c.id;

-- 4. Получить топ-5 самых дорогих товаров
SELECT * FROM product ORDER BY price DESC LIMIT 5;

-- 5. Получить общую сумму всех заказов
SELECT SUM(p.price * o.quantity) AS total_sum FROM order_info o
JOIN product p ON o.product_id = p.id;

-- Запросы на изменение данных

-- 6. Изменить имя покупателя с id=1
UPDATE customer SET full_name = 'Иванов Иван Сергеевич' WHERE id = 1;

-- Запросы на удаление данных

-- 7. Удалить все заказы, сделанные до 2023-01-20
DELETE FROM order_info WHERE order_date < '2023-01-20';

