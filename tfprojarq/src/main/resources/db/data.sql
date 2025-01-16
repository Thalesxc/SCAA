INSERT INTO customers (id, email, name) VALUES
(1, 'cliente1@example.com', 'Cliente 1'),
(2, 'cliente2@example.com', 'Cliente 2'),
(3, 'cliente3@example.com', 'Cliente 3'),
(4, 'cliente4@example.com', 'Cliente 4'),
(5, 'cliente5@example.com', 'Cliente 5'),
(6, 'cliente6@example.com', 'Cliente 6'),
(7, 'cliente7@example.com', 'Cliente 7'),
(8, 'cliente8@example.com', 'Cliente 8'),
(9, 'cliente9@example.com', 'Cliente 9'),
(10, 'cliente10@example.com', 'Cliente 10')
ON CONFLICT (id) DO NOTHING;


INSERT INTO applications (monthly_cost,id , name) VALUES
(29.99, 1, 'App 1'),
(19.99, 2, 'App 2'),
(9.99, 3, 'App 3'),
(14.99, 4, 'App 4'),
(24.99, 5, 'App 5')
ON CONFLICT (id) DO NOTHING;


INSERT INTO subscription (end_date, start_date, application_id, customer_id, id) VALUES
('2021-12-31', '2021-12-01', 1, 1, 1),
('2021-12-31', '2021-12-01', 2, 2, 2),
('2021-12-31', '2021-12-01', 3, 3, 3),
('2021-12-31', '2021-12-01', 4, 4, 4),
('2021-12-31', '2021-12-01', 5, 5, 5)
ON CONFLICT (id) DO NOTHING;
