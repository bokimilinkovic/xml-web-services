insert into users(id, cart, approved, blocked, email, first_name, last_name, business_number, company_name, address, authorities, password) values (1, 1, true, false, 'user', 'Joseph', 'Joestar', '1', '', 'some address', 'ROLE_CLIENT;READ_ADS;SEND_RENT_REQUEST;READ_USER_PRIVILEGES;UPDATE_CART;DELETE_FROM_CART;READ_CART;CREATE_BOOKING;ACCEPT_BOOKING;CANCEL_BOOKING;READ_BOOKINGS', '$2a$10$GuztdmZFDUgqX/FvWCMPdu/lUfkHxxs8bkJvw6IxvSJv3T54SU6ea');
insert into users(id, approved, blocked, email, first_name, last_name, business_number, company_name, address, authorities, password) values (2, true, false, 'company1', '', '', '2', 'some company name', 'some address', 'ROLE_COMPANY;READ_ADS;SEND_RENT_REQUEST;READ_USER_PRIVILEGES', '$2a$10$GuztdmZFDUgqX/FvWCMPdu/lUfkHxxs8bkJvw6IxvSJv3T54SU6ea');
insert into users(id, approved, blocked, email, first_name, last_name, business_number, company_name, address, authorities, password) values (3, true, false, 'admin1', 'Johh', 'Doe', '3', '', 'some address', 'ROLE_ADMIN;READ_USER_PRIVILEGES;UPDATE_USER_PRIVILEGES;READ_CLIENTS;UPDATE_CLIENT_BLOCK;DELETE_CLIENT;ADD_AGENT;ADD_COMPANY;READ_CODEBOOK;UPDATE_CODEBOOK;READ_PENDING_COMMENTS;UPDATE_PENDING_COMMENTS;READ_USER_PRIVILEGES;UPDATE_USER_PRIVILEGES', '$2a$10$GuztdmZFDUgqX/FvWCMPdu/lUfkHxxs8bkJvw6IxvSJv3T54SU6ea');
insert into users(id, cart, approved, blocked, email, first_name, last_name, business_number, company_name, address, authorities, password) values (4, 2, true, false, 'user1', 'Johny', 'Joestar', '4', '', 'some address', 'ROLE_CLIENT;READ_ADS;SEND_RENT_REQUEST;READ_USER_PRIVILEGES;UPDATE_CART;DELETE_FROM_CART;READ_CART;CREATE_BOOKING;ACCEPT_BOOKING;CANCEL_BOOKING;READ_BOOKINGS', '$2a$10$GuztdmZFDUgqX/FvWCMPdu/lUfkHxxs8bkJvw6IxvSJv3T54SU6ea');

alter sequence user_id_seq RESTART with 5;


-- cart
insert into cart(id, user_id) values (1, 1);
insert into cart(id, user_id) values (2, 4);
alter sequence cart_id_seq RESTART with 3;


-- brands
insert into brand(id, name) values (1, 'Opel');
insert into brand(id, name) values (2, 'Audi');
insert into brand(id, name) values (3, 'BMW');
insert into brand(id, name) values (4, 'Fiat');
insert into brand(id, name) values (5, 'Ford');
insert into brand(id, name) values (6, 'Honda');
insert into brand(id, name) values (7, 'Toyota');

alter sequence brand_id_seq RESTART with 8;


-- models
insert into model(id, name, brand_id) values (1, 'Astra', 1);
insert into model(id, name, brand_id) values (2, 'Zafira', 1);
insert into model(id, name, brand_id) values (3, 'Vectra', 1);

insert into model(id, name, brand_id) values (4, 'A6', 2);
insert into model(id, name, brand_id) values (5, 'Q3', 2);
insert into model(id, name, brand_id) values (6, 'R8', 2);

insert into model(id, name, brand_id) values (7, 'I8', 3);
insert into model(id, name, brand_id) values (8, 'X6', 3);
insert into model(id, name, brand_id) values (9, 'Z7', 3);

insert into model(id, name, brand_id) values (10, 'Panda', 4);
insert into model(id, name, brand_id) values (11, 'Punto', 4);
insert into model(id, name, brand_id) values (12, 'Stilo', 4);

insert into model(id, name, brand_id) values (13, 'Granada', 5);
insert into model(id, name, brand_id) values (14, 'Fiesta', 5);
insert into model(id, name, brand_id) values (15, 'Taunus', 5);

insert into model(id, name, brand_id) values (16, 'Accord', 6);
insert into model(id, name, brand_id) values (17, 'Civic', 6);
insert into model(id, name, brand_id) values (18, 'Legend', 6);

insert into model(id, name, brand_id) values (19, 'Corona', 7);
insert into model(id, name, brand_id) values (20, 'Dyna', 7);
insert into model(id, name, brand_id) values (21, 'Prius', 7);

alter sequence model_id_seq RESTART with 22;


-- car Classes
insert into class(id, name) values (1, 'Microcar');
insert into class(id, name) values (2, 'Minicompact');
insert into class(id, name) values (3, 'Subcompact');
insert into class(id, name) values (4, 'Compact');
insert into class(id, name) values (5, 'Mid-size');
insert into class(id, name) values (6, 'Full-size');
insert into class(id, name) values (7, 'Minivan');
insert into class(id, name) values (8, 'Sports car');
insert into class(id, name) values (9, 'Sports sedan');
insert into class(id, name) values (10, 'Supercar');
insert into class(id, name) values (11, 'Caravan');

alter sequence car_class_id_seq RESTART with 12;

-- fuels
insert into fuel(id, name) values (1, 'Gasoline');
insert into fuel(id, name) values (2, 'Diesel');
insert into fuel(id, name) values (3, 'Liquified Petroleum');
insert into fuel(id, name) values (4, 'Compressed Natural Gas');
insert into fuel(id, name) values (5, 'Ethanol');
insert into fuel(id, name) values (6, 'Bio-Diesel');

alter sequence fuel_id_seq RESTART with 7;


-- transmissions
insert into transmission(id, name) values (1, 'Automatic');
insert into transmission(id, name) values (2, 'Manual');

alter sequence transmission_id_seq RESTART with 3;


-- images of cars
insert into image(id, car_id, encoded64_image) values (1, 1, 'data:image/jpeg;base64,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');

alter sequence image_id_seq RESTART with 2;


-- cars
insert into car(id, total_mileage, allowed_mileage, children_seats, description, col_dam_protection, owner, brand, model, fuel, transmission, car_class)
        values (1, 1000, 2000, 2, 'Car Description', true, 'user', 'Opel', 'Astra', 'Diesel', 'Automatic', 'Compact');

insert into car(id, total_mileage, allowed_mileage, children_seats, description, col_dam_protection, owner, brand, model, fuel, transmission, car_class)
        values (2, 8000, 2000, 1, 'Car Description', true, 'user', 'Opel', 'Zafira', 'Diesel', 'Manual', 'Caravan');

insert into car(id, total_mileage, allowed_mileage, children_seats, description, col_dam_protection, owner, brand, model, fuel, transmission, car_class)
        values (3, 25060, 8000, 0, 'Car Description', true, 'user', 'Opel', 'Vectra', 'Gasoline', 'Automatic', 'Microcar');

insert into car(id, total_mileage, allowed_mileage, children_seats, description, col_dam_protection, owner, brand, model, fuel, transmission, car_class)
        values (4, 5060, 6000, 2, 'Car Description', true, 'user1', 'Audi', 'Q3', 'Gasoline', 'Automatic', 'Microcar');

alter sequence car_id_seq RESTART with 5;

insert into user_cars(user_id, car_id) values (1, 1);
insert into user_cars(user_id, car_id) values (1, 2);
insert into user_cars(user_id, car_id) values (1, 3);
insert into user_cars(user_id, car_id) values (4, 4);

--insert into car_images values (1, 1);

-- comments
--insert into comment(id, created, body, approved, car_id, user_id) values (1, '2020-01-25T21:34:55', 'nesto', false, 1, 4);
--insert into comment(id, created, body, approved, car_id, user_id) values (2, '2020-01-25T21:34:55', 'nesto drugo', false, 1, 4);

-- ads
insert into ad(id, car_id, start_date, end_date, place, owner_id, active) values (1, 1, '2020-05-19T00:00:00', '2020-05-30T00:00:00', 'Novi Sad', 1, true);
insert into ad(id, car_id, start_date, end_date, place, owner_id, active) values (2, 1, '2020-07-19T00:00:00', '2020-07-30T00:00:00', 'Beograd', 1, false);
insert into ad(id, car_id, start_date, end_date, place, owner_id, active) values (3, 2, '2020-09-19T00:00:00', '2020-09-30T00:00:00', 'Sabac', 1, false);
insert into ad(id, car_id, start_date, end_date, place, owner_id, active) values (4, 3, '2020-09-19T00:00:00', '2020-09-30T00:00:00', 'Nis', 1, true);
insert into ad(id, car_id, start_date, end_date, place, owner_id, active) values (5, 4, '2020-09-19T00:00:00', '2020-09-30T00:00:00', 'Sabac', 4, true);


alter sequence ad_id_seq RESTART with 6;


