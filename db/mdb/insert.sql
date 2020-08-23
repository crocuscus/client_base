INSERT INTO client (client_id, client_type, fullname) VALUES(1, false, 'Карл Фридрих Гаусс');
INSERT INTO client (client_id, client_type, fullname) VALUES(2, false, 'Август Фердинанд Мебиус');
INSERT INTO client (client_id, client_type, fullname) VALUES(3, false, 'Петер Густав Дирихле');
INSERT INTO client (client_id, client_type, fullname) VALUES(4, false, 'Симеон Дени Пуассон');
INSERT INTO client (client_id, client_type, fullname) VALUES(5, true, 'ООО Магнитогорский металлургический комбинат');
INSERT INTO client (client_id, client_type, fullname) VALUES(6, true, 'OOO Московский нефтеперерабатывающий завод');
INSERT INTO client (client_id, client_type, fullname) VALUES(7, true, 'Eli Lilly and Company');
INSERT INTO client (client_id, client_type, fullname) VALUES(8, true, 'Intel Corporation');

INSERT INTO individual_client (client_id, first_name, second_name, surname) VALUES
(1, 'Карл', 'Фридрих', 'Гаусс');
INSERT INTO individual_client (client_id, first_name, second_name, surname) VALUES
(2, 'Август', 'Фердинанд', 'Мебиус');
INSERT INTO individual_client (client_id, first_name, second_name, surname) VALUES
(3, 'Петер', 'Густав', 'Дирихле');
INSERT INTO individual_client (client_id, first_name, second_name, surname) VALUES
(4, 'Симеон', 'Дени', 'Пуассон');

INSERT INTO legal_client (client_id, tin) VALUES
(5, '31415926535');
INSERT INTO legal_client (client_id, tin) VALUES
(6, '8979323846');
INSERT INTO legal_client (client_id, tin) VALUES
(7, '2643383279');
INSERT INTO legal_client (client_id, tin) VALUES
(8, '5028841971');

INSERT INTO client_contact (client_id, contact_name, phone, email) VALUES
(1, NULL, NULL, 'gauss@gmail.com');
INSERT INTO client_contact (client_id, contact_name, phone, email) VALUES
(7, 'David J. Marbaugh', '(317) 277-5620', NULL);
INSERT INTO client_contact (client_id, contact_name, phone, email) VALUES
(7, 'Karen Glowacki', '(317) 433-9100', NULL);
INSERT INTO client_contact (client_id, contact_name, phone, email) VALUES
(6, NULL, '+7(495)7349200', 'MNPZ@gazprom-neft.ru');

INSERT INTO employee_status (status_id, status_name) VALUES 
(1, 'Работает');
INSERT INTO employee_status (status_id, status_name) VALUES 
(2, 'Уволен');
INSERT INTO employee_status (status_id, status_name) VALUES 
(3, 'В отпуске');
INSERT INTO employee_status (status_id, status_name) VALUES 
(4, 'В декрете');


INSERT INTO employee (employee_id, first_name, second_name, surname, 
	passport, passport_date, passport_from_whom) VALUES
(1, 'Макс', 'Отто', 'фон Штирлиц',
	'7182818284', '08.10.1914', 'Петербург');
INSERT INTO employee (employee_id, first_name, second_name, surname, 
	passport, passport_date, passport_from_whom) VALUES
(2, 'Генри', NULL, 'Мюллер',	
	'5904523536', '28.04.1914', 'Мюнхен');
INSERT INTO employee (employee_id, first_name, second_name, surname, 
	passport, passport_date, passport_from_whom) VALUES
(3, 'Василий', 'Иванович', 'Чапаев',
	'0287471352', '28.01.1901', 'Будайка, Чебоксарская волость');
INSERT INTO employee (employee_id, first_name, second_name, surname, 
	passport, passport_date, passport_from_whom) VALUES
(4, 'Пауль', 'Йозеф', 'Геббельс',
	'6624977572', '29.10.1901', 'Райдт, Пруссия');

INSERT INTO service (service_id, service_name, prescence_flag, price) 
VALUES (1, 'Письменная консультация', true, '1000');
INSERT INTO service (service_id, service_name, prescence_flag, price)
VALUES (2, 'Судебные возражения', true, '3000');
INSERT INTO service (service_id, service_name, prescence_flag, price)
VALUES (3, 'Кассационная жалоба', true, '4000');
INSERT INTO service (service_id, service_name, prescence_flag, price) 
VALUES (4, 'Представительство в суде', true, '7000');

INSERT INTO order_history(order_id, client_id, service_id, from_dttm)
VALUES (1, 1, 1, '23.02.2020');
INSERT INTO order_history(order_id, client_id, service_id, from_dttm)
VALUES (2, 2, 2, '24.02.2020');
INSERT INTO order_history(order_id, client_id, service_id, from_dttm)
VALUES (3, 3, 3, '25.02.2020');
INSERT INTO order_history(order_id, client_id, service_id, from_dttm)
VALUES (4, 4, 3, '26.02.2020');

INSERT INTO workload (order_id, employee_id) VALUES (1, 1);
INSERT INTO workload (order_id, employee_id) VALUES (2, 1);
INSERT INTO workload (order_id, employee_id) VALUES (1, 2);
INSERT INTO workload (order_id, employee_id) VALUES (3, 4);
