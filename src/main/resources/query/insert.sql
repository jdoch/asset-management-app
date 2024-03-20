insert into address values ('efdba0c7-9531-499d-afb9-1fdd1b0d19c2', '7', '30', '12345', 'Lipowa');
insert into address values ('647a858a-31fd-4e86-b7e4-c4132fc1b7e4', '1', '3', '12345', 'Akacjowa');
insert into address values ('ddcd66ff-64aa-4235-8f97-447fc32868d2', '2', '2', '12345', 'Brzowowa');
insert into address values ('8e0bb2b9-ea75-462a-b993-8dc7b4c842bb', '3', '1', '12345','Granitowa');
insert into address values ('431d159c-5cf7-4432-9159-ec1e4da3c576', '4', '7', '12345','Marmurowa');
insert into address values ('74283e9f-d162-4e3b-8051-a456a67ea8f8', '5', '8', '12345','Miedziana');
insert into address values ('5e1dc34b-90b3-4e5a-83e7-9a36fcd165b0', '6', '5', '12345','Stalowa');
insert into address values ('2007b3e3-54d7-4b3c-b8b8-1500ad35a592', '7', '2', '12345','Hutnicza');

insert into customer values ('efdba0c7-9531-499d-afb9-1fdd1b0d19c2', '54c12dc2-f337-48aa-84e6-f4ede9653203', 'Jan', 'Kowalski');
insert into customer values ('647a858a-31fd-4e86-b7e4-c4132fc1b7e4', '9da568e8-ef8e-4952-9058-288a8f8c7e5d', 'Damian', 'Bąk');
insert into customer values ('ddcd66ff-64aa-4235-8f97-447fc32868d2', '293c7970-276d-488e-9dce-c8d554d2c6bf', 'Józef', 'Kowal');
insert into customer values ('8e0bb2b9-ea75-462a-b993-8dc7b4c842bb', '69d5a2ad-65a3-4e09-9f64-e4f2f18dab42', 'Stefan', 'Kowalski');
insert into customer values ('431d159c-5cf7-4432-9159-ec1e4da3c576', 'fb21e76c-e6bb-4bbf-9fb8-3b4244d1e9cf', 'Jan', 'Brzechwa');

insert into company values ('74283e9f-d162-4e3b-8051-a456a67ea8f8', '11c0d0ed-ee05-4f9b-97d1-9a71150e0c95', 'Company A');
insert into company values ('5e1dc34b-90b3-4e5a-83e7-9a36fcd165b0', '26ac7870-b3e2-47f6-8821-c43ad024ce1d', 'Company B');
insert into company values ('2007b3e3-54d7-4b3c-b8b8-1500ad35a592', '8d7eb146-a356-401c-8315-679d26fd88a3', 'Company C');

insert into customer_companies values ('11c0d0ed-ee05-4f9b-97d1-9a71150e0c95', '54c12dc2-f337-48aa-84e6-f4ede9653203');
insert into customer_companies values ('26ac7870-b3e2-47f6-8821-c43ad024ce1d', '54c12dc2-f337-48aa-84e6-f4ede9653203');
insert into customer_companies values ('8d7eb146-a356-401c-8315-679d26fd88a3', '54c12dc2-f337-48aa-84e6-f4ede9653203');
insert into customer_companies values ('11c0d0ed-ee05-4f9b-97d1-9a71150e0c95', '9da568e8-ef8e-4952-9058-288a8f8c7e5d');
insert into customer_companies values ('26ac7870-b3e2-47f6-8821-c43ad024ce1d', '293c7970-276d-488e-9dce-c8d554d2c6bf');
insert into customer_companies values ('11c0d0ed-ee05-4f9b-97d1-9a71150e0c95', '69d5a2ad-65a3-4e09-9f64-e4f2f18dab42');
insert into customer_companies values ('8d7eb146-a356-401c-8315-679d26fd88a3', '69d5a2ad-65a3-4e09-9f64-e4f2f18dab42');

insert into asset values (1.0, '1', '11c0d0ed-ee05-4f9b-97d1-9a71150e0c95', 'cb3edc03-6e84-41dc-8d98-38210886aca0', 'Aseet A');
insert into asset values (11.0, '1', '11c0d0ed-ee05-4f9b-97d1-9a71150e0c95', '504374f7-232a-4b0b-96c6-a4e56b13f7fe', 'Aseet B');
insert into asset values (12.0, '1', '11c0d0ed-ee05-4f9b-97d1-9a71150e0c95', '335421ba-4608-46d6-9fba-401013b99e42', 'Aseet C');
insert into asset values (31.0, '1', '26ac7870-b3e2-47f6-8821-c43ad024ce1d', '68cdf8be-2f5a-4a19-bae0-04a36558d864', 'Aseet D');
insert into asset values (51.0, '1', '26ac7870-b3e2-47f6-8821-c43ad024ce1d', '5e50071a-655d-44be-8262-bbd826f4e752', 'Aseet E');
insert into asset values (10.0, '1', '8d7eb146-a356-401c-8315-679d26fd88a3', '9bf8ab6e-41ed-40fe-9ec8-fae54dabc6fe', 'Aseet F');


