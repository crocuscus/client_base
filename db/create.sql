DROP TABLE IF EXISTS client, individual_client, legal_client, client_contact, employee_status, employee, employee_status, service, order_history, workload;
DROP SEQUENCE IF EXISTS Client_ID_seq, ClientContact_ID_seq, Employee_ID_seq, EmployeeStatus_ID_seq, OrderHistory_ID_seq, Service_ID_seq;


CREATE TABLE client(
  client_id SERIAL PRIMARY KEY,
  client_type BOOL NOT NULL,
  fullname VARCHAR NOT NULL
);
 
CREATE TABLE individual_client (
 client_id INT UNIQUE REFERENCES client,
 first_name VARCHAR NOT NULL,
 second_name VARCHAR,
 surname VARCHAR NOT NULL,
 passport VARCHAR UNIQUE,
 passport_date DATE,
 passport_from_whom VARCHAR
);
 
CREATE TABLE legal_client (
 client_id INT UNIQUE REFERENCES client,
 short_name VARCHAR,
 tin VARCHAR NOT NULL UNIQUE
);
 
CREATE TABLE client_contact (
 contact_id SERIAL PRIMARY KEY,
 client_id INT REFERENCES client,
 contact_name VARCHAR,
 phone VARCHAR,
 email VARCHAR
);
 
CREATE TABLE employee_status (
 status_id SMALLSERIAL PRIMARY KEY,
 status_name VARCHAR
);
 
CREATE TABLE employee (
 employee_id SERIAL PRIMARY KEY,
 first_name VARCHAR NOT NULL,
 second_name VARCHAR,
 surname VARCHAR NOT NULL,
 passport VARCHAR NOT NULL UNIQUE,
 passport_date DATE NOT NULL,
 passport_from_whom VARCHAR NOT NULL,
 post VARCHAR,
 status_id SMALLINT REFERENCES employee_status,
 education VARCHAR,
 phone VARCHAR,
 email VARCHAR,
 address VARCHAR
);
 
CREATE TABLE service (
 service_id SMALLSERIAL PRIMARY KEY,
 service_name VARCHAR NOT NULL,
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

CREATE SEQUENCE Client_ID_seq RESTART WITH 100;
CREATE SEQUENCE ClientContact_ID_seq RESTART WITH 100;
CREATE SEQUENCE Employee_ID_seq RESTART WITH 100;
CREATE SEQUENCE EmployeeStatus_ID_seq RESTART WITH 100;
CREATE SEQUENCE OrderHistory_ID_seq RESTART WITH 100;
CREATE SEQUENCE Service_ID_seq RESTART WITH 100;