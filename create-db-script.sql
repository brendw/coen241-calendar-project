create database calendarApp;
use calendarApp;

CREATE TABLE Users
(
    id  		int NOT NULL auto_increment primary key,
    username    varchar(45) NOT NULL,
    password    varchar(45) NOT NULL,
    email 		varchar(45) NOT NULL,
    UNIQUE (email)
);

CREATE TABLE Events
(
    eventId        int  NOT NULL auto_increment primary key,
    eventName	   varchar(45) NOT NULL,
    publisherId    int  NOT NULL,
    image    	   varchar(45) DEFAULT NULL,
    description    varchar(100) NOT NULL,
    location       varchar(45) NOT NULL,
    createDate     datetime DEFAULT current_timestamp,
	eventDate      varchar(20) NOT NULL,
    startTime      varchar(20) NOT NULL,
    endTime        varchar(20) NOT NULL,
    valid		   tinyint DEFAULT 1,
    
    FOREIGN KEY (publisherId) REFERENCES calendarApp.Users (id)
);

CREATE TABLE EventTags
(
    eventTagId	int NOT NULL AUTO_INCREMENT primary key,
    eventId     int NOT NULL,
    tagId       int NOT NULL,
    
	KEY eventId (eventId),
    KEY tagId (tagId),
    UNIQUE(eventId, tagId), 
    FOREIGN KEY (eventId) REFERENCES calendarApp.Events (eventId)
);


CREATE TABLE RSVP
(
    rsvpId	   int NOT NULL AUTO_INCREMENT primary key,
    eventId    int NOT NULL,
    userId     int NOT NULL,

	KEY eventId (eventId),
    KEY userId (userId),
    UNIQUE (eventId, userId),
    FOREIGN KEY (userId) REFERENCES calendarApp.Users (id),
    FOREIGN KEY (eventId) REFERENCES calendarApp.Events (eventId)
);

