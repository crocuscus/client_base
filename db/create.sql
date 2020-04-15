CREATE TABLE client(
  client_id SERIAL PRIMARY KEY,
  client_type BOOL NOT NULL
);
 
CREATE TABLE individual_client (
 client_id INT UNIQUE REFERENCES client,
 first_name VARCHAR(25) NOT NULL,
 second_name VARCHAR(25),
 surname VARCHAR(25) NOT NULL,
 passport CHAR(20) UNIQUE,
 passport_date DATE,
 passport_from_whom VARCHAR(100)
);
 
CREATE TABLE legal_client (
 client_id INT UNIQUE REFERENCES client,
 fullname VARCHAR(200) NOT NULL,
 short_name VARCHAR(50),
 tin VARCHAR(20) NOT NULL UNIQUE
);
 
CREATE TABLE client_contact (
 client_id INT REFERENCES client,
 contact_name VARCHAR(50),
 phone VARCHAR(20),
 email VARCHAR(30)
);
 
CREATE TABLE employee_status (
 status_id SMALLSERIAL PRIMARY KEY,
 status_name VARCHAR(20)
);
 
CREATE TABLE employee (
 employee_id SERIAL PRIMARY KEY,
 first_name VARCHAR(25) NOT NULL,
 second_name VARCHAR(25),
 surname VARCHAR(25) NOT NULL,
 passport CHAR(20) NOT NULL UNIQUE,
 passport_date DATE NOT NULL,
 passport_from_whom VARCHAR(100) NOT NULL,
 post VARCHAR(20),
 status_id SMALLINT REFERENCES employee_status,
 education VARCHAR(20),
 phone VARCHAR(20),
 email VARCHAR(30),
 address VARCHAR(70)
);
 
CREATE TABLE service (
 service_id SMALLSERIAL PRIMARY KEY,
 service_name VARCHAR(250) NOT NULL,
 price MONEY NOT NULL,
 prescence_flag BOOL
);
 
CREATE TABLE order_history (
 order_id SERIAL PRIMARY KEY,
 client_id INT REFERENCES client,
 service_id SMALLINT REFERENCES service,
 from_dttm TIMESTAMP NOT NULL,
 to_dttm TIMESTAMP
);
 
CREATE TABLE workload (
 order_id INT REFERENCES order_history,
 employee_id INT REFERENCES employee,
 UNIQUE (order_id, employee_id)
);
