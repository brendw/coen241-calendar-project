drop database calendarApp;

create database calendarApp;
use calendarApp;

CREATE TABLE Users
(
    id  		int NOT NULL auto_increment primary key,
    username    varchar(45) NOT NULL,
    password    varchar(45) NOT NULL,
    email 		varchar(45) NOT NULL,
    UNIQUE (username),
    UNIQUE (email)
);

CREATE TABLE Events
(
    event_id        int  NOT NULL auto_increment primary key,
    event_name	   varchar(75) NOT NULL,
    publisher      varchar(45) NOT NULL,
    image    	   varchar(150) DEFAULT NULL,
    description    varchar(300) NOT NULL,
    location       varchar(50) NOT NULL,
    create_date     datetime DEFAULT current_timestamp,
	event_date      date NOT NULL,
    start_time      time NOT NULL,
    end_time        time NOT NULL,
    valid		   tinyint DEFAULT 1,  #default 1 is valid event
    
    FOREIGN KEY (publisher) REFERENCES calendarApp.Users (username)
);

CREATE TABLE EventTags
(
    event_tag_id	int NOT NULL AUTO_INCREMENT primary key,
    event_id     int NOT NULL,
    tag_id       int NOT NULL,
    
	KEY event_id (event_id),
    KEY tag_id (tag_id),
    UNIQUE(event_id, tag_id), 
    FOREIGN KEY (event_id) REFERENCES calendarApp.Events (event_id)
);


CREATE TABLE RSVP
(
    rsvp_id	   int NOT NULL AUTO_INCREMENT primary key,
    event_id    int NOT NULL,
    username     varchar(45) NOT NULL,

	KEY event_id (event_id),
    KEY username (username),
    UNIQUE (event_id, username),
    FOREIGN KEY (username) REFERENCES calendarApp.Users (username),
    FOREIGN KEY (event_id) REFERENCES calendarApp.Events (event_id)
);

