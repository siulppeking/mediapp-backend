INSERT INTO Role (id_role, name, description) VALUES (4, 'HOTEL', 'Hotel');

INSERT INTO user_data(id_user, username, password, enabled) values (3, 'luis34@gmail.com', '$2a$10$ju20i95JTDkRa7Sua63JWOChSBc0MNFtG/6Sps2ahFFqN.HCCUMW.', '1');
INSERT INTO user_role (id_user, id_role) VALUES (3, 4);

INSERT INTO menu(id_menu, name, icon, url) VALUES (9, 'Rooms', 'room', '/pages/room');
INSERT INTO menu(id_menu, name, icon, url) VALUES (10, 'Reservation', 'calendar', '/pages/reservation');

INSERT INTO menu_role (id_menu, id_role) VALUES (9, 4);
INSERT INTO menu_role (id_menu, id_role) VALUES (10, 4);