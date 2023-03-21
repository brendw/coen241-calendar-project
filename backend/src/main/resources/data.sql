# sample data
use calendarApp;

INSERT INTO Users (username, password, email)
VALUES ('seanchoi', 'pw', 'schoi@scu.edu');

INSERT INTO Users (username, password, email)
VALUES ("alice", 'pw', 'atam@scu.edu');

INSERT INTO Users (username, password, email)
VALUES ("lemontea", 'pw', "ltea@scu.edu");

INSERT INTO Users (username, password, email)
VALUES ("scu_sports", 'pw', "sports@scu.edu");

INSERT INTO Users (username, password, email)
VALUES ("performingarts", 'pw', "perform@scu.edu");

INSERT INTO Users (username, password, email)
VALUES ("LeaveyBusiness", 'pw', "business@scu.edu");

INSERT INTO Users (username, password, email)
VALUES ("clayton_wiley", 'pw', "cdwiley@scu.edu");

INSERT INTO Users (username, password, email)
VALUES ("Katy Korsmeyer", 'pw', "kkorsmeyer@scu.edu");

INSERT INTO Events (event_name, publisher, image, description, location, event_date, start_time, end_time, valid, url, tag)
VALUES ("Cloud Computing Study Session", "seanchoi", "https://cloudacademy.com/wp-content/uploads/2017/01/2022-10-14-Blog-Feature-What-is-Cloud-Computing-1-1200x620.png", "Last class! Time to study for final!", "Library", "2023-03-15", "19:00:00", "21:00:00", 1, "https://www.scu.edu/library/hours/", "Academic");

INSERT INTO Events (event_name, publisher, image, description, location, event_date, start_time, end_time, valid, url, tag)
VALUES ("ONLINE Cloud Computing Study Session", "seanchoi", "https://cloudacademy.com/wp-content/uploads/2017/01/2022-10-14-Blog-Feature-What-is-Cloud-Computing-1-1200x620.png", "This is an online study session. Feel free to ask questions! Time to study for final!", "Zoom", "2023-03-17", "19:00:00", "21:00:00", 1, null, "Online");

INSERT INTO Events (event_name, publisher, image, description, location, event_date, start_time, end_time, valid, url, tag)
VALUES ("Pizza Party", "alice", "https://images.unsplash.com/photo-1513104890138-7c749659a591?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8MXx8fGVufDB8fHx8&w=1000&q=80", "FREE pizza and more snacks!! We love pizza! Registration for this event is not needed.", "SCDI Lobby", "2023-03-17", "12:00:00", "14:00:00", 1, null, "Party" );

INSERT INTO Events (event_name, publisher, image, description, location, event_date, start_time, end_time, valid, url, tag)
VALUES ("Card Game Club", "lemontea", "https://thehawkeye.org/wp-content/uploads/2015/09/Cards-2-900x600.jpg", "Bored? Let's play big 2! Registration for this event is not needed.", "Lucas Hall", "2023-03-17", "15:00:00", "17:00:00", 1, null, "Party");

INSERT INTO Events (event_name, publisher, image, description, location, event_date, start_time, end_time, valid, url, tag)
VALUES ("Sunday Mass", "scu_sports", "https://lwcal.scu.edu/live/image/scale/2x/gid/20/width/200/height/200/crop/1/src_region/0,0,1080,1080/5864_Livewhale_Squares_4.rev.1645150122.webp", "Sunday Service starts at 10AM!", "SCU Church", "2023-03-19", "10:00:00", "12:00:00", 1, null, "Theology");

INSERT INTO Events (event_name, publisher, image, description, location, event_date, start_time, end_time, valid, url, tag)
VALUES ("Concerto Aria", "performingarts", "https://lwcal.scu.edu/live/image/gid/10/width/250/6329_Option_3_0.rev.1663014557.webp", "Bask in the prodigious talents of the Concerto Aria Competition in this awe-inspiring concert with the SCU Orchestra and Wind Ensemble.", "SCU Church", "2023-03-16", "18:30:00", "21:00:00", 1, null, "Art & Music");

INSERT INTO Events (event_name, publisher, image, description, location, event_date, start_time, end_time, valid, url, tag)
VALUES ("EMBA, MBA and MS Programs Info Session", "LeaveyBusiness", "https://i.ytimg.com/vi/7HxhJMyAdM0/maxresdefault.jpg", "Lead change in Silicon Valley. Learn about Santa Clara University, The Leavey School of Business, and our Evening MBA, Online MBA and Executive MBA Programs. Register online.", "Leavey Center", "2023-04-12", "18:00:00", "20:00:00", 1, "https://slate.scu.edu/register/?id=f5a43755-fac4-480f-a376-40eacc6a3130", "Academic");

INSERT INTO Events (event_name, publisher, image, description, location, event_date, start_time, end_time, valid, url, tag)
VALUES ("OPT Workshop", "LeaveyBusiness", "https://lwcal.scu.edu/live/image/scale/2x/gid/7/width/250/6837_ISS_-_Immigration_Workshop_1.rev.1677020729.webp", "Are you graduating this year? Join us for an OPT Workshop for an overview of the process. Learn more about post-completion Optional Practical Training (OPT). This is an in person session for F-1 students who will be graduating this year (2023)", "Leavey Center", "2023-03-16", "16:00:00", "18:00:00", 1, null, "Academic" );

INSERT INTO Events (event_name, publisher, image, description, location, event_date, start_time, end_time, valid, url, tag)
VALUES ("Into the Woods Video Audition", "clayton_wiley", "https://www.mtishows.com/sites/default/files/styles/hero_responsive_wide/public/show/hero/000106_hero.jpg?itok=Mqgff3UC", "Auditions are being held for Into the Woods, the iconic musical by Stephen Sondheim and James Lapine, directed by Jeffrey Bracco, musical direction by Scot Hanna-Weir,  choreography by Pauline Locsin-Kanter and presented by the Department of Theatre and Dance.", "Lucas Hall", "2023-03-17", "12:00:00", "17:00:00", 1, "https://www.mtishows.com/into-the-woods", "Art & Music");

INSERT INTO Events (event_name, publisher, image, description, location, event_date, start_time, end_time, valid, url, tag)
VALUES ("(Women’s Water Polo) SDSU vs. SCU", "scu_sports", "https://www.santaclarabroncos.com/sports/w-wpolo/2022-23/photos/220218_morrisonDJR36619.jpg?max_width=1160&max_height=652&crop=true&useS3=true", "Santa Clara Women’s Water Polo hosts San Diego State at 4:30pm.", "Sullivan Aquatic Center", "2023-03-31", "16:30:00", "19:30:00", 1, "https://www.santaclarabroncos.com/sports/w-wpolo/index", "Sports");

INSERT INTO Events (event_name, publisher, image, description, location, event_date, start_time, end_time, valid, url, tag)
VALUES ("REAL Program Info Session (Virtual)", "lemontea", "https://lwcal.scu.edu/live/image/scale/2x/gid/10/width/250/5779_REAL_Logo_-_White_Background.rev.1643400445.webp", "The REAL Program, which stands for Real Experience, Applied Learning, awards stipends of up to $6,000 to CAS students conducting research, internships, or creative projects with a CAS faculty member, or, an internship in industry or a non-profit organization sponsor.", "Zoom", "2023-03-16", "19:00:00", "19:45:00", 1, "https://scu.zoom.us/j/94297913405?pwd=ZzBSVmZ3OUdXU2F2NHF3QWZSamNpQT09", "Online");

INSERT INTO Events (event_name, publisher, image, description, location, event_date, start_time, end_time, valid, url, tag)
VALUES ("Garden Volunteer Workday Hours", "lemontea", "https://lwcal.scu.edu/live/image/scale/2x/gid/34/width/250/6515_Forge_volunteer_hours_1.rev.1666851703.webp", "All are welcome to drop by The Forge Garden during our volunteer work hours. Possible activities include planting crops, building compost piles, spreading mulch, harvesting and seeding in the greenhouse.", "Forge Garden", "2023-03-17", "09:30:00", "11:30:00", 1, null, "Volunteer");

INSERT INTO Events (event_name, publisher, image, description, location, event_date, start_time, end_time, valid, url, tag)
VALUES ("JST Annual Talent Show", "lemontea", "https://lwcal.scu.edu/live/image/scale/2x/gid/46/width/250/6782_Spring_Events_12.rev.1675445557.webp", "Come share your talents at the JST Annual Talent Show! Your talent does not have to be a live performance! You can cook, bake, present your art, or share your talents with us another way. Sign up below to share your talent:", "Lucas Hall", "2023-03-17", "19:30:00", "21:00:00", 1, "https://forms.gle/ZRvKBNsSYubSRyQw6", "JST");
