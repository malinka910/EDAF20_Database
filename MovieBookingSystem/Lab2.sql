-- Delete the tables if they exist. To be able to drop
-- them in arbitrary order, disable foreign key checks.

-- Turn of key checks
set foreign_key_checks = 0;

-- Drop tables in arbitrary order
drop table if exists Users;
drop table if exists Theaters;
drop table if exists Showing;
drop table if exists Bookings;

-- Turn on key checks
set foreign_key_checks = 1;

-- Create the tables
CREATE TABLE Users(
userName varchar(20),
name varchar(40),
telephone char(10),
address varchar(60),
PRIMARY KEY(userName)
);

CREATE TABLE Theaters(
theaterName varchar(20),
seats int					NOT NULL,
PRIMARY KEY (theaterName)
);

CREATE TABLE Showing(
movie varchar(20),
freeSeats int,
showday date,
theaterName varchar(20)		NOT NULL,
PRIMARY KEY(movie, showday),
FOREIGN KEY (theaterName)
REFERENCES Theaters (theaterName)
);

CREATE TABLE Bookings(
nbr integer auto_increment,
userName varchar(20)	NOT NULL,
movie varchar(20)		NOT NULL,
showday date			NOT NULL,
PRIMARY KEY (nbr),
FOREIGN KEY (movie, showday)
REFERENCES Showing (movie, showday),
FOREIGN KEY (userName) 
REFERENCES Users(userName)
);

-- Insert data into tables

-- Users
insert into Users values('Greg423' , 'Gregory Austin', 1234567890, '123 something road');
insert into Users values('Andreas985' , 'Andreas Mrdn', 1234567890, '123 something road');
insert into Users values('CarlR534' , 'Carl Rikner', 1234567890, '123 something road');
insert into Users values('Benjamin123' , 'Benjamin Holmqvist', 1234567890, '123 something road');
insert into Users values('Marlina42' , 'Marlina Degirmenci', 1234567890, '123 something road');
insert into Users values('Richard1801' , 'Richard Elvhammar', 1234567890, '123 something road');
insert into Users values('CarlG3071' , 'Carl Gustavsson', 1234567890, '123 something road');
insert into Users values('Sebastian2017' , 'Sebastian Bergdahl', 1234567890, '123 something road');

-- Theaters
insert into Theaters values('Chinese' , 100);
insert into Theaters values('Aztec' , 40);
insert into Theaters values('Sundance' , 60);

-- Showings
insert into Showing values('Casablanca', 100, 20170214 , 'Chinese');
insert into Showing values('Citizen Kane', 100, 20170214 , 'Chinese');
insert into Showing values('North by Northwest', 100, 20170214 , 'Chinese');
insert into Showing values('Shichinin No Samurai', 100, 20170214 , 'Chinese');
insert into Showing values('Das Cabinet', 100, 20170215 , 'Chinese');
insert into Showing values('The Maltese Falcon', 100, 20170215 , 'Chinese');
insert into Showing values('Modern Times', 100, 20170215 , 'Chinese');
insert into Showing values('North by Northwest', 100, 20170215 , 'Chinese');
insert into Showing values('Casablanca', 100, 20170216 , 'Chinese');
insert into Showing values('Sunset Boulevard', 100, 20170216 , 'Chinese');
insert into Showing values('Modern Times', 100, 20170216 , 'Chinese');
insert into Showing values('Red Lion', 100, 20170216 , 'Chinese');
insert into Showing values('Citizen Kane', 100, 20170217 , 'Chinese');
insert into Showing values('Das Cabinet', 100, 20170217 , 'Chinese');
insert into Showing values('Psycho', 100, 20170217 , 'Chinese');
insert into Showing values('Shichinin No Samurai', 100, 20170217 , 'Chinese');
insert into Showing values('Modern Times', 40, 20170214 , 'Aztec');
insert into Showing values('Psycho', 40, 20170214 , 'Aztec');
insert into Showing values('Vertigo', 40, 20170214 , 'Aztec');
insert into Showing values('Pulp Fiction', 40, 20170214 , 'Aztec');
insert into Showing values('Sunset Boulevard', 40, 20170215 , 'Aztec');
insert into Showing values('Lawrence of Arabia', 40, 20170215 , 'Aztec');
insert into Showing values('Citizen Kane', 40, 20170215 , 'Aztec');
insert into Showing values('12 Angry Men', 40, 20170215 , 'Aztec');
insert into Showing values('Pulp Fiction', 40, 20170216 , 'Aztec');
insert into Showing values('Psycho', 40, 20170216 , 'Aztec');
insert into Showing values('Fight Club', 40, 20170216 , 'Aztec');
insert into Showing values('Gone With The Wind', 40, 20170216 , 'Aztec');
insert into Showing values('North by Northwest', 40, 20170217 , 'Aztec');
insert into Showing values('Fight Club', 40, 20170217 , 'Aztec');
insert into Showing values('Sunset Boulevard', 40, 20170217 , 'Aztec');
insert into Showing values('Casablanca', 40, 20170217 , 'Aztec');
insert into Showing values('Fight Club', 60, 20170214 , 'Sundance');
insert into Showing values('Gone With The Wind', 60, 20170214 , 'Sundance');
insert into Showing values('Annie Hall', 60, 20170214 , 'Sundance');
insert into Showing values('The Usual Suspects', 60, 20170214 , 'Sundance');
insert into Showing values('Vertigo', 60, 20170215 , 'Sundance');
insert into Showing values('Casablanca', 60, 20170215 , 'Sundance');
insert into Showing values('The Usual Suspects', 60, 20170215 , 'Sundance');
insert into Showing values('Shichinin No Samurai', 60, 20170215 , 'Sundance');
insert into Showing values('Citizen Kane', 60, 20170216 , 'Sundance');
insert into Showing values('12 Angry Men', 60, 20170216 , 'Sundance');
insert into Showing values('Lawrence of Arabia', 60, 20170216 , 'Sundance');
insert into Showing values('The Maltese Falcon', 60, 20170216 , 'Sundance');
insert into Showing values('Annie Hall', 60, 20170217 , 'Sundance');
insert into Showing values('The Usual Suspects', 60, 20170217 , 'Sundance');
insert into Showing values('Forrest Gump', 60, 20170217 , 'Sundance');
insert into Showing values('Gran Torino', 60, 20170217 , 'Sundance');



-- Bookings


