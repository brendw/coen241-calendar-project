create database if not exists calendarApp;
use calendarApp;

CREATE TABLE if not exists Users
(
    id  		int NOT NULL auto_increment primary key,
    username    varchar(45) NOT NULL,
    password    varchar(45) NOT NULL,
    email 		varchar(45) NOT NULL,
    UNIQUE (email)
);

CREATE TABLE if not exists Events
(
    event_id        int  NOT NULL auto_increment primary key,
    event_name	   varchar(45) NOT NULL,
    publisher_id    int  NOT NULL,
    image    	   varchar(45) DEFAULT NULL,
    description    varchar(100) NOT NULL,
    location       varchar(45) NOT NULL,
    create_date     datetime DEFAULT current_timestamp,
    event_date      date NOT NULL,
    start_date      time NOT NULL,
    end_date        time NOT NULL,
    valid		   tinyint DEFAULT 1,  #default 1 is valid event

    FOREIGN KEY (publisher_id) REFERENCES calendarApp.Users (id)
);

# CREATE TABLE if not exists EventTags
# (
#     eventTagId	int NOT NULL AUTO_INCREMENT primary key,
#     eventId     int NOT NULL,
#     tagId       int NOT NULL,
#
#     KEY eventId (eventId),
#     KEY tagId (tagId),
#     UNIQUE(eventId, tagId),
#     FOREIGN KEY (eventId) REFERENCES calendarApp.Events (eventId)
# );


# CREATE TABLE if not exists RSVP
# (
#     rsvpId	   int NOT NULL AUTO_INCREMENT primary key,
#     eventId    int NOT NULL,
#     userId     int NOT NULL,
#
#     KEY eventId (eventId),
#     KEY userId (userId),
#     UNIQUE (eventId, userId),
#     FOREIGN KEY (userId) REFERENCES calendarApp.Users (id),
#     FOREIGN KEY (eventId) REFERENCES calendarApp.Events (eventId)
# );

