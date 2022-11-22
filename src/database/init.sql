create database venue_management;
use venue_management;

create table VenueManagers (
    emailId varchar(50) not null primary key, -- 'Stores email id'
    name varchar(50) not null, -- 'Stores name of the manager'
    password varchar(50) not null, -- 'Stores password of the manager'
    contactNumber varchar(10) not null, -- 'Stores contact number of the manager'
    hallName varchar(50) not null, -- 'Stores name of the hall'
    hallAddress varchar(200) not null, -- 'Stores address of the hall'
    hallCapacity int not null, -- 'Stores capacity of the hall'\
    hallDescription varchar(200) not null -- 'Stores description of the hall'
);

create table EventOrganizers (
    emailId varchar(50) not null primary key, -- 'Stores email id'
    name varchar(50) not null, -- 'Stores name of the organizer'
    password varchar(50) not null, -- 'Stores password of the organizer'
    contactNumber varchar(10) not null, -- 'Stores contact number of the organizer'
    organizationName varchar(50) not null, -- 'Stores name of the organization'
    organizationAddress varchar(200) not null -- 'Stores address of the organization'
);

create table Requests (
    requestId int not null primary key, -- 'Stores id of the request'
    eventName varchar(50) not null, -- 'Stores name of the event'
    organizerId varchar(50) not null, -- 'Stores email id of the organizer'
    managerId varchar(50) not null, -- 'Stores email id of the manager'
    bookingDescription varchar(200) not null, -- 'Stores description of the request'
    startTime datetime not null, -- 'Stores start time of the event'
    endTime datetime not null, -- 'Stores end time of the event'
    status enum('PENDING', 'ACCEPTED', 'REJECTED', 'CANCELLED') not null default 'PENDING', -- 'Stores status of the event'
    feedback varchar(200) null, -- 'Stores feedback of the event'
    foreign key (organizerId) references EventOrganizers(emailId),
    foreign key (managerId) references VenueManagers(emailId)
);