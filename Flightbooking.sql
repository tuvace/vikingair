begin 
;
create database FlightBooking;
use FlightBooking;

/*Tabellen skal holde på informasjon om kunden, og brukes ved innlogging.*/
create table Customer(
customerID int not null auto_increment,
firstName varchar(20) not null,
middleName varchar (20),
lastName varchar (20) not null, 
customerAddress varchar (50),
disabilities int,
gender varchar(8),
constraint Customerpk primary key (customerID));

/*Denne tabellen skal opprette de to rollene som man kan ha ved innlogging, kunde, eller admin.*/
create table Roles(
roleName varchar(20),
roleDescription varchar(300),
roleID int auto_increment,
constraint roles_pk primary key (roleName),
index(roleID));


create table UserRoles(
customerID int not null,
roleID int not null,
userPassword varchar(40),
constraint UserRoles_pk primary key (customerID, roleId),
constraint UserRoles_customer_fk foreign key(customerID)references Customer(customerID),
constraint UserRoles_roles_fk foreign key(roleID)references Roles(roleID));


create table Phone(
phoneNumber varchar(11) primary key,
customerID int not null);

create table email(
email varchar(50) primary key,
customerID int not null);

/* Legger inn customer_id som fk i phone tabellen */
ALTER TABLE phone
add foreign key (customerID) references customer(customerID);

/* Legger inn customer_id som fk i email tabellen */
ALTER TABLE email
add foreign key (customerID) references customer(customerID);

/*Holder informasjon om setene, og gir dem en id.*/
create table Seat(
seatRow int not null,
seatLetter varchar(10) not null,
class int,
seatID int auto_increment not null,
constraint seat_pk primary key (seatRow, seatLetter),
index (seatID));

/*Holder informasjon om en flyreise.*/
create table FlightDetails(
flightID int not null auto_increment,
flightDate datetime,
price int,
flightTo varchar(50),
flightFrom varchar(50),
airplaneType varchar (50),
duration int,
baggage_limit int,
constraint flightDetailspk primary key (flightID));

/*Holder informasjon som skal være på billetten*/
create table Ticket(
ticketID int not null auto_increment,
customerID int,
flightID int,
gate varchar(5),
seatID int not null,
constraint ticketpk primary key (ticketID),
constraint ticket_seat_fk foreign key (seatID) references Seat(seatID),
foreign key (customerID) references Customer(customerID),
foreign key (flightID) references FlightDetails(flightID));

/*Kunder*/
insert into Customer (firstName, middleName, lastName, customerAddress, disabilities, gender)
values ("Remi", "Rumineco", "Rudi", "Rudiveien 95", 75, 'Male');
INSERT INTO Phone(phoneNumber, customerID)
VALUES('15561677', last_insert_id());
INSERT INTO Email(email, customerID)
VALUES('ola@normann.no', last_insert_id());


insert into Customer (firstName, middleName, lastName, customerAddress, disabilities, gender)
values ("Laila", "Gunnersen", "Svendsen", "gata 12", 66, 'Female');
INSERT INTO Phone(phoneNumber, customerID)
VALUES('67288827', last_insert_id());
INSERT INTO Email(email, customerID)
VALUES('laila@gmail.com', last_insert_id());


insert into Customer (firstName, middleName, lastName, customerAddress, disabilities, gender)
values ("Ansgar", "Kristian", "Larsen", "veien 3", 78, 'Male');
INSERT INTO Phone(phoneNumber, customerID)
VALUES('7188333', last_insert_id());
INSERT INTO Email(email, customerID)
VALUES('ansgar@gmail.com', last_insert_id());

/*Legger inn de to mulige rollene.*/
insert into Roles(roleName, roleDescription)
values('Administrator', 'Kan administrere flyreiser og kunder.'),
		('Kunde', 'Kan bestille flyreiser.');

/* Må legge inn kunde og roller først, disse ID'ene skal inn i denne tabellen.*/
insert into UserRoles(customerID, roleID, userPassword)
values(1, 1, (SHA('mittpassord')));
insert into UserRoles(customerID, roleID, userPassword)
values(2, 2, (SHA('passord2')));
insert into UserRoles(customerID, roleID, userPassword)
values(3, 1, (SHA('passord3')));



/* FLyseter*/
INSERT INTO Seat(seatRow, seatLetter, class)
VALUES (1,'A',1),
(1,'B',1),
(1,'C',1),
(1,'D',1),
(1,'E',1),
(1,'F',1),
(2,'A',1),
(2,'B',1),
(2,'C',1),
(2,'D',1),
(2,'E',1),
(2,'F',1),
(3,'A',1),
(3,'B',1),
(3,'C',1),
(3,'D',1),
(3,'E',1),
(3,'F',1),
(4,'A',1),
(4,'B',1),
(4,'C',1),
(4,'D',1),
(4,'E',1),
(4,'F',1),
(5,'A',1),
(5,'B',1),
(5,'C',1),
(5,'D',1),
(5,'E',1),
(5,'F',1),
(6,'A',1),
(6,'B',1),
(6,'C',1),
(6,'D',1),
(6,'E',1),
(6,'F',1),
(7,'A',2),
(7,'B',2),
(7,'C',2),
(7,'D',2),
(7,'E',2),
(7,'F',2),
(8,'A',2),
(8,'B',2),
(8,'C',2),
(8,'D',2),
(8,'E',2),
(8,'F',2),
(9,'A',2),
(9,'B',2),
(9,'C',2),
(9,'D',2),
(9,'E',2),
(9,'F',2),
(10,'A',2),
(10,'B',2),
(10,'C',2),
(10,'D',2),
(10,'E',2),
(10,'F',2),
(11,'A',2),
(11,'B',2),
(11,'C',2),
(11,'D',2),
(11,'E',2),
(11,'F',2),
(12,'A',2),
(12,'B',2),
(12,'C',2),
(12,'D',2),
(12,'E',2),
(12,'F',2),
(13,'A',2),
(13,'B',2),
(13,'C',2),
(13,'D',2),
(13,'E',2),
(13,'F',2);


/*Flyreiser*/
insert into FlightDetails (flightDate, price, flightTo, flightFrom, airplaneType, duration, baggage_limit)
values ( '2019-02-22 23:59:59', 6969, "Gardermoen", "Kjevik", "Boeing", 3, 100000);

insert into FlightDetails (flightDate, price, flightTo, flightFrom, airplaneType, duration, baggage_limit)
values ( '2019-02-22 23:59:59', 6969, "Gardermoen", "Flesland", "Boeing", 1, 200000);

/*Billett bestillinger*/
insert into Ticket(customerID, flightID,  gate, seatID)
values(1, 1, '4B',1);

insert into Ticket(customerID, flightID, gate, seatID)
values(2, 2, '4B',2);

insert into Ticket(customerID, flightID, gate, seatID)
values(3, 1,'4C',2);


select *
from Customer;

select*
from seat;

select *
from customer, seat;

select *
from ticket;

select sha(userPassword)
from UserRoles;


select *
from flightdetails;

drop table customer;
drop table seat;
drop table flightDetails;
drop table Ticket;
drop database FlightBooking;
