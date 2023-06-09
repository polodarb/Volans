BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "client" (
	"client_code"	INTEGER,
	"client_pib"	TEXT NOT NULL,
	"client_passport"	TEXT NOT NULL,
	"client_phone"	TEXT NOT NULL,
	PRIMARY KEY("client_code" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "employee" (
	"employee_code"	INTEGER,
	"employee_pib"	TEXT NOT NULL,
	"employee_position"	TEXT NOT NULL,
	PRIMARY KEY("employee_code" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "airport" (
	"airport_code"	INTEGER,
	"airport_name"	TEXT NOT NULL,
	"airport_country"	TEXT NOT NULL,
	"airport_city"	TEXT NOT NULL,
	PRIMARY KEY("airport_code" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "place" (
	"place_code"	INTEGER,
	"place_status"	TEXT NOT NULL,
	PRIMARY KEY("place_code" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "ticket" (
	"ticket_number"	INTEGER,
	"flight_code"	INTEGER NOT NULL,
	"client_code"	INTEGER NOT NULL,
	"ticket_buy_date"	TEXT NOT NULL,
	"place_number"	INTEGER NOT NULL,
	"ticket_insurance"	INTEGER NOT NULL,
	FOREIGN KEY("flight_code") REFERENCES "flight"("flight_code"),
	FOREIGN KEY("place_number") REFERENCES "place"("place_code"),
	FOREIGN KEY("client_code") REFERENCES "client"("client_code"),
	PRIMARY KEY("ticket_number" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "flight" (
	"flight_code"	INTEGER,
	"departure_code"	INTEGER NOT NULL,
	"arrival_code"	INTEGER NOT NULL,
	"departure_date"	TEXT NOT NULL,
	"arrival_date"	TEXT NOT NULL,
	"departure_time"	TEXT NOT NULL,
	"arrival_time"	TEXT NOT NULL,
	"price"	REAL NOT NULL,
	FOREIGN KEY("departure_code") REFERENCES "airport"("airport_code"),
	FOREIGN KEY("arrival_code") REFERENCES "airport"("airport_code"),
	PRIMARY KEY("flight_code" AUTOINCREMENT)
);
INSERT INTO "client" VALUES (3,'John Smith','1234567890','9876543210');
INSERT INTO "client" VALUES (4,'Alice Johnson','2345678901','8765432109');
INSERT INTO "client" VALUES (5,'Michael Williams','3456789012','7654321098');
INSERT INTO "client" VALUES (6,'Jennifer Brown','4567890123','6543210987');
INSERT INTO "client" VALUES (7,'Christopher Davis','5678901234','5432109876');
INSERT INTO "client" VALUES (8,'Jessica Miller','6789012345','4321098765');
INSERT INTO "client" VALUES (9,'Matthew Wilson','7890123456','3210987654');
INSERT INTO "client" VALUES (10,'Emily Taylor','8901234567','2109876543');
INSERT INTO "client" VALUES (11,'Daniel Anderson','9012345678','1098765432');
INSERT INTO "client" VALUES (12,'Olivia Thomas','1023456789','987654321');
INSERT INTO "client" VALUES (13,'David Martinez','2134567890','9876543210');
INSERT INTO "client" VALUES (14,'Sophia Hernandez','3245678901','8765432109');
INSERT INTO "client" VALUES (15,'Andrew Smith','4356789012','7654321098');
INSERT INTO "client" VALUES (16,'Mia Johnson','5467890123','6543210987');
INSERT INTO "client" VALUES (17,'Joseph Williams','6578901234','5432109876');
INSERT INTO "client" VALUES (18,'Abigail Brown','7689012345','4321098765');
INSERT INTO "client" VALUES (19,'James Davis','8790123456','3210987654');
INSERT INTO "client" VALUES (20,'Emma Miller','9801234567','2109876543');
INSERT INTO "client" VALUES (21,'Benjamin Wilson','9012345678','1098765432');
INSERT INTO "client" VALUES (22,'Ava Taylor','1123456789','987654321');
INSERT INTO "client" VALUES (23,'Alexander Anderson','2234567890','9876543210');
INSERT INTO "client" VALUES (24,'Samantha Thomas','3345678901','8765432109');
INSERT INTO "client" VALUES (25,'William Martinez','4456789012','7654321098');
INSERT INTO "client" VALUES (26,'Isabella Hernandez','5567890123','6543210987');
INSERT INTO "client" VALUES (27,'Ethan Smith','6678901234','5432109876');
INSERT INTO "client" VALUES (28,'Charlotte Johnson','7789012345','4321098765');
INSERT INTO "client" VALUES (29,'Daniel Williams','8890123456','3210987654');
INSERT INTO "client" VALUES (30,'Amelia Brown','9901234567','2109876543');
INSERT INTO "client" VALUES (31,'Michael Davis','1012345678','1098765432');
INSERT INTO "client" VALUES (32,'Liam Miller','1123456789','987654321');
INSERT INTO "client" VALUES (33,'Olivia Wilson','2234567890','9876543210');
INSERT INTO "client" VALUES (34,'Emily Taylor','3345678901','8765432109');
INSERT INTO "client" VALUES (35,'Noah Anderson','4456789012','7654321098');
INSERT INTO "client" VALUES (36,'Emma Hernandez','5567890123','6543210987');
INSERT INTO "client" VALUES (37,'Sophia Smith','6678901234','5432109876');
INSERT INTO "client" VALUES (38,'Liam Johnson','7789012345','4321098765');
INSERT INTO "client" VALUES (39,'Ava Williams','8890123456','3210987654');
INSERT INTO "client" VALUES (40,'Jackson Brown','9901234567','2109876543');
INSERT INTO "client" VALUES (41,'Isabella Davis','1012345678','1098765432');
INSERT INTO "client" VALUES (42,'Lucas Miller','1123456789','987654321');
INSERT INTO "client" VALUES (43,'Mia Wilson','2234567890','9876543210');
INSERT INTO "client" VALUES (44,'Aiden Taylor','3345678901','8765432109');
INSERT INTO "client" VALUES (45,'Logan Anderson','4456789012','7654321098');
INSERT INTO "client" VALUES (46,'Charlotte Hernandez','5567890123','6543210987');
INSERT INTO "client" VALUES (47,'Mateo Smith','6678901234','5432109876');
INSERT INTO "client" VALUES (48,'Ella Johnson','7789012345','4321098765');
INSERT INTO "client" VALUES (49,'Jayden Williams','8890123456','3210987654');
INSERT INTO "client" VALUES (50,'Scarlett Brown','9901234567','2109876543');
INSERT INTO "client" VALUES (51,'Jack Davis','1012345678','1098765432');
INSERT INTO "client" VALUES (52,'Grace Miller','1123456789','987654321');
INSERT INTO "employee" VALUES (1,'John Smith','Manager');
INSERT INTO "employee" VALUES (2,'Alice Johnson','Assistant Manager');
INSERT INTO "employee" VALUES (3,'Michael Williams','Sales Representative');
INSERT INTO "employee" VALUES (4,'Jennifer Brown','HR Manager');
INSERT INTO "employee" VALUES (5,'Christopher Davis','Accountant');
INSERT INTO "employee" VALUES (6,'Jessica Miller','Marketing Specialist');
INSERT INTO "employee" VALUES (7,'Matthew Wilson','IT Administrator');
INSERT INTO "employee" VALUES (8,'Emily Taylor','Customer Service Representative');
INSERT INTO "employee" VALUES (9,'Daniel Anderson','Operations Manager');
INSERT INTO "employee" VALUES (10,'Olivia Thomas','Finance Analyst');
INSERT INTO "employee" VALUES (11,'David Martinez','Project Coordinator');
INSERT INTO "employee" VALUES (12,'Sophia Hernandez','Administrative Assistant');
INSERT INTO "airport" VALUES (1,'[KHA]','Ukraine','Kharkiv');
INSERT INTO "airport" VALUES (2,'[IEV]','Ukraine','Kiev');
INSERT INTO "airport" VALUES (3,'[LON]','United Kingdom','London');
INSERT INTO "airport" VALUES (4,'[NYC]','United States','New York');
INSERT INTO "airport" VALUES (5,'[PAR]','France','Paris');
INSERT INTO "airport" VALUES (6,'[BER]','Germany','Berlin');
INSERT INTO "airport" VALUES (7,'[ROM]','Italy','Rome');
INSERT INTO "airport" VALUES (8,'[AMS]','Netherlands','Amsterdam');
INSERT INTO "airport" VALUES (9,'[MAD]','Spain','Madrid');
INSERT INTO "airport" VALUES (10,'[SYD]','Australia','Sydney');
INSERT INTO "airport" VALUES (11,'[TYO]','Japan','Tokyo');
INSERT INTO "airport" VALUES (12,'[IST]','Turkey','Istanbul');
INSERT INTO "airport" VALUES (13,'[CAI]','Egypt','Cairo');
INSERT INTO "airport" VALUES (14,'[ATH]','Greece','Athens');
INSERT INTO "airport" VALUES (15,'[DEL]','India','Delhi');
INSERT INTO "airport" VALUES (16,'[BEY]','Lebanon','Beirut');
INSERT INTO "airport" VALUES (17,'[MEX]','Mexico','Mexico City');
INSERT INTO "airport" VALUES (18,'[TOR]','Canada','Toronto');
INSERT INTO "airport" VALUES (19,'[BUE]','Argentina','Buenos Aires');
INSERT INTO "airport" VALUES (20,'[SAO]','Brazil','Sao Paulo');
INSERT INTO "airport" VALUES (21,'[CPT]','South Africa','Cape Town');
INSERT INTO "airport" VALUES (22,'[NBO]','Kenya','Nairobi');
INSERT INTO "airport" VALUES (23,'[JKT]','Indonesia','Jakarta');
INSERT INTO "airport" VALUES (24,'[BKK]','Thailand','Bangkok');
INSERT INTO "airport" VALUES (25,'[SGP]','Singapore','Singapore');
INSERT INTO "airport" VALUES (26,'[DXB]','United Arab Emirates','Dubai');
INSERT INTO "airport" VALUES (27,'[IST]','Turkey','Istanbul');
INSERT INTO "airport" VALUES (28,'[ZRH]','Switzerland','Zurich');
INSERT INTO "airport" VALUES (29,'[VIE]','Austria','Vienna');
INSERT INTO "airport" VALUES (30,'[CPH]','Denmark','Copenhagen');
INSERT INTO "airport" VALUES (31,'[BER]','Germany','Berlin');
INSERT INTO "airport" VALUES (32,'[AMS]','Netherlands','Amsterdam');
INSERT INTO "airport" VALUES (33,'[MAD]','Spain','Madrid');
INSERT INTO "airport" VALUES (34,'[SYD]','Australia','Sydney');
INSERT INTO "airport" VALUES (35,'[TYO]','Japan','Tokyo');
INSERT INTO "airport" VALUES (36,'[IST]','Turkey','Istanbul');
INSERT INTO "airport" VALUES (37,'[CAI]','Egypt','Cairo');
INSERT INTO "airport" VALUES (38,'[ATH]','Greece','Athens');
INSERT INTO "airport" VALUES (39,'[DEL]','India','Delhi');
INSERT INTO "airport" VALUES (40,'[BEY]','Lebanon','Beirut');
INSERT INTO "airport" VALUES (41,'[MEX]','Mexico','Mexico City');
INSERT INTO "airport" VALUES (42,'[TOR]','Canada','Toronto');
INSERT INTO "airport" VALUES (43,'[BUE]','Argentina','Buenos Aires');
INSERT INTO "airport" VALUES (44,'[SAO]','Brazil','Sao Paulo');
INSERT INTO "airport" VALUES (45,'[CPT]','South Africa','Cape Town');
INSERT INTO "airport" VALUES (46,'[NBO]','Kenya','Nairobi');
INSERT INTO "airport" VALUES (47,'[JKT]','Indonesia','Jakarta');
INSERT INTO "airport" VALUES (48,'[BKK]','Thailand','Bangkok');
INSERT INTO "airport" VALUES (49,'[SGP]','Singapore','Singapore');
INSERT INTO "airport" VALUES (50,'[DXB]','United Arab Emirates','Dubai');
INSERT INTO "airport" VALUES (51,'[ZRH]','Switzerland','Zurich');
INSERT INTO "airport" VALUES (52,'[VIE]','Austria','Vienna');
INSERT INTO "airport" VALUES (53,'[CPH]','Denmark','Copenhagen');
INSERT INTO "airport" VALUES (54,'[OSL]','Norway','Oslo');
INSERT INTO "airport" VALUES (55,'[STO]','Sweden','Stockholm');
INSERT INTO "airport" VALUES (56,'[HEL]','Finland','Helsinki');
INSERT INTO "airport" VALUES (57,'[PAR]','France','Paris');
INSERT INTO "airport" VALUES (58,'[ROM]','Italy','Rome');
INSERT INTO "airport" VALUES (59,'[LIS]','Portugal','Lisbon');
INSERT INTO "airport" VALUES (60,'[DUB]','Ireland','Dublin');
INSERT INTO "place" VALUES (1,'Business');
INSERT INTO "place" VALUES (2,'Business');
INSERT INTO "place" VALUES (3,'Economy');
INSERT INTO "place" VALUES (4,'Economy');
INSERT INTO "place" VALUES (5,'Economy');
INSERT INTO "place" VALUES (6,'Economy');
INSERT INTO "place" VALUES (7,'Economy');
INSERT INTO "place" VALUES (8,'Economy');
INSERT INTO "place" VALUES (9,'Economy');
INSERT INTO "place" VALUES (10,'Economy');
INSERT INTO "place" VALUES (11,'Business');
INSERT INTO "place" VALUES (12,'Economy');
INSERT INTO "place" VALUES (13,'Economy');
INSERT INTO "place" VALUES (14,'Economy');
INSERT INTO "place" VALUES (15,'Business');
INSERT INTO "place" VALUES (16,'Economy');
INSERT INTO "place" VALUES (17,'Economy');
INSERT INTO "place" VALUES (18,'Economy');
INSERT INTO "place" VALUES (19,'Economy');
INSERT INTO "place" VALUES (20,'Economy');
INSERT INTO "place" VALUES (21,'Business');
INSERT INTO "place" VALUES (22,'Economy');
INSERT INTO "place" VALUES (23,'Economy');
INSERT INTO "place" VALUES (24,'Economy');
INSERT INTO "place" VALUES (25,'Business');
INSERT INTO "place" VALUES (26,'Economy');
INSERT INTO "place" VALUES (27,'Economy');
INSERT INTO "place" VALUES (28,'Economy');
INSERT INTO "place" VALUES (29,'Economy');
INSERT INTO "place" VALUES (30,'Economy');
INSERT INTO "place" VALUES (31,'Business');
INSERT INTO "place" VALUES (32,'Economy');
INSERT INTO "place" VALUES (33,'Economy');
INSERT INTO "place" VALUES (34,'Economy');
INSERT INTO "place" VALUES (35,'Business');
INSERT INTO "place" VALUES (36,'Economy');
INSERT INTO "place" VALUES (37,'Economy');
INSERT INTO "place" VALUES (38,'Economy');
INSERT INTO "place" VALUES (39,'Economy');
INSERT INTO "place" VALUES (40,'Economy');
INSERT INTO "place" VALUES (41,'Business');
INSERT INTO "place" VALUES (42,'Economy');
INSERT INTO "place" VALUES (43,'Economy');
INSERT INTO "place" VALUES (44,'Economy');
INSERT INTO "place" VALUES (45,'Economy');
INSERT INTO "place" VALUES (46,'Economy');
INSERT INTO "place" VALUES (47,'Economy');
INSERT INTO "place" VALUES (48,'Business');
INSERT INTO "place" VALUES (49,'Economy');
INSERT INTO "place" VALUES (50,'Economy');
INSERT INTO "ticket" VALUES (3,3,3,'2023-06-17',3,1);
INSERT INTO "ticket" VALUES (4,4,4,'2023-06-18',4,0);
INSERT INTO "ticket" VALUES (5,5,5,'2023-06-19',5,1);
INSERT INTO "ticket" VALUES (6,6,6,'2023-06-20',6,0);
INSERT INTO "ticket" VALUES (7,7,7,'2023-06-21',7,1);
INSERT INTO "ticket" VALUES (8,8,8,'2023-06-22',8,0);
INSERT INTO "ticket" VALUES (9,9,9,'2023-06-23',9,1);
INSERT INTO "ticket" VALUES (10,10,10,'2023-06-24',10,0);
INSERT INTO "ticket" VALUES (11,11,11,'2023-06-25',11,1);
INSERT INTO "ticket" VALUES (12,12,12,'2023-06-26',12,0);
INSERT INTO "ticket" VALUES (13,13,13,'2023-06-27',13,1);
INSERT INTO "ticket" VALUES (14,14,14,'2023-06-28',14,0);
INSERT INTO "ticket" VALUES (15,15,15,'2023-06-29',15,1);
INSERT INTO "ticket" VALUES (16,16,16,'2023-06-30',16,0);
INSERT INTO "ticket" VALUES (17,17,17,'2023-07-01',17,1);
INSERT INTO "ticket" VALUES (18,18,18,'2023-07-02',18,0);
INSERT INTO "ticket" VALUES (19,19,19,'2023-07-03',19,1);
INSERT INTO "ticket" VALUES (20,20,20,'2023-07-04',20,0);
INSERT INTO "ticket" VALUES (21,21,21,'2023-07-05',21,1);
INSERT INTO "ticket" VALUES (22,22,22,'2023-07-06',22,0);
INSERT INTO "ticket" VALUES (23,23,23,'2023-07-07',23,1);
INSERT INTO "ticket" VALUES (24,24,24,'2023-07-08',24,0);
INSERT INTO "ticket" VALUES (25,25,25,'2023-07-09',25,1);
INSERT INTO "ticket" VALUES (26,26,26,'2023-07-10',26,0);
INSERT INTO "ticket" VALUES (27,27,27,'2023-07-11',27,1);
INSERT INTO "ticket" VALUES (28,28,28,'2023-07-12',28,0);
INSERT INTO "ticket" VALUES (29,29,29,'2023-07-13',29,1);
INSERT INTO "ticket" VALUES (30,30,30,'2023-07-14',30,0);
INSERT INTO "ticket" VALUES (31,31,31,'2023-07-15',31,1);
INSERT INTO "ticket" VALUES (32,32,32,'2023-07-16',32,0);
INSERT INTO "ticket" VALUES (33,33,33,'2023-07-17',33,1);
INSERT INTO "ticket" VALUES (34,34,34,'2023-07-18',34,0);
INSERT INTO "ticket" VALUES (35,35,35,'2023-07-19',35,1);
INSERT INTO "ticket" VALUES (36,36,36,'2023-07-20',36,0);
INSERT INTO "ticket" VALUES (37,37,37,'2023-07-21',37,1);
INSERT INTO "ticket" VALUES (38,38,38,'2023-07-22',38,0);
INSERT INTO "ticket" VALUES (39,39,39,'2023-07-23',39,1);
INSERT INTO "ticket" VALUES (40,40,40,'2023-07-24',40,0);
INSERT INTO "ticket" VALUES (41,41,41,'2023-07-25',41,1);
INSERT INTO "ticket" VALUES (42,42,42,'2023-07-26',42,0);
INSERT INTO "ticket" VALUES (43,43,43,'2023-07-27',43,1);
INSERT INTO "ticket" VALUES (44,44,44,'2023-07-28',44,0);
INSERT INTO "ticket" VALUES (45,45,45,'2023-07-29',45,1);
INSERT INTO "ticket" VALUES (46,46,46,'2023-07-30',46,0);
INSERT INTO "ticket" VALUES (47,47,47,'2023-07-31',47,1);
INSERT INTO "ticket" VALUES (48,48,48,'2023-08-01',48,0);
INSERT INTO "ticket" VALUES (49,49,49,'2023-08-02',49,1);
INSERT INTO "flight" VALUES (1,1,2,'2023-06-10','09:00:00','12:00:00',100.0);
INSERT INTO "flight" VALUES (2,2,3,'2023-06-11','10:30:00','13:30:00',120.5);
INSERT INTO "flight" VALUES (3,3,4,'2023-06-12','14:15:00','17:15:00',150.75);
INSERT INTO "flight" VALUES (4,4,5,'2023-06-13','16:45:00','19:45:00',130.25);
INSERT INTO "flight" VALUES (5,5,6,'2023-06-14','08:00:00','11:00:00',110.5);
INSERT INTO "flight" VALUES (6,6,7,'2023-06-15','11:30:00','14:30:00',135.0);
INSERT INTO "flight" VALUES (7,7,8,'2023-06-16','15:45:00','18:45:00',145.75);
INSERT INTO "flight" VALUES (8,8,9,'2023-06-17','17:30:00','20:30:00',125.5);
INSERT INTO "flight" VALUES (9,9,10,'2023-06-18','09:15:00','12:15:00',115.25);
INSERT INTO "flight" VALUES (10,10,11,'2023-06-19','12:45:00','15:45:00',155.0);
INSERT INTO "flight" VALUES (11,11,12,'2023-06-20','14:30:00','17:30:00',145.75);
INSERT INTO "flight" VALUES (12,12,13,'2023-06-21','18:00:00','21:00:00',135.5);
INSERT INTO "flight" VALUES (13,13,14,'2023-06-22','08:45:00','11:45:00',125.25);
INSERT INTO "flight" VALUES (14,14,15,'2023-06-23','11:15:00','14:15:00',165.0);
INSERT INTO "flight" VALUES (15,15,16,'2023-06-24','16:30:00','19:30:00',155.75);
INSERT INTO "flight" VALUES (16,16,17,'2023-06-25','17:45:00','20:45:00',145.5);
INSERT INTO "flight" VALUES (17,17,18,'2023-06-26','10:00:00','13:00:00',135.25);
INSERT INTO "flight" VALUES (18,18,19,'2023-06-27','12:30:00','15:30:00',175.0);
INSERT INTO "flight" VALUES (19,19,20,'2023-06-28','15:00:00','18:00:00',165.5);
INSERT INTO "flight" VALUES (20,20,21,'2023-06-29','08:30:00','11:30:00',155.25);
INSERT INTO "flight" VALUES (21,21,22,'2023-06-30','11:45:00','14:45:00',195.0);
INSERT INTO "flight" VALUES (22,22,23,'2023-07-01','14:15:00','17:15:00',185.75);
INSERT INTO "flight" VALUES (23,23,24,'2023-07-02','17:30:00','20:30:00',175.5);
INSERT INTO "flight" VALUES (24,24,25,'2023-07-03','10:15:00','13:15:00',165.25);
INSERT INTO "flight" VALUES (25,25,26,'2023-07-04','13:45:00','16:45:00',205.0);
INSERT INTO "flight" VALUES (26,26,27,'2023-07-05','16:30:00','19:30:00',195.75);
INSERT INTO "flight" VALUES (27,27,28,'2023-07-06','09:00:00','12:00:00',185.5);
INSERT INTO "flight" VALUES (28,28,29,'2023-07-07','11:30:00','14:30:00',175.25);
INSERT INTO "flight" VALUES (29,29,30,'2023-07-08','14:00:00','17:00:00',215.0);
INSERT INTO "flight" VALUES (30,30,31,'2023-07-09','17:15:00','20:15:00',205.75);
INSERT INTO "flight" VALUES (31,31,32,'2023-07-10','10:30:00','13:30:00',195.5);
INSERT INTO "flight" VALUES (32,32,33,'2023-07-11','13:00:00','16:00:00',235.25);
INSERT INTO "flight" VALUES (33,33,34,'2023-07-12','16:45:00','19:45:00',225.0);
INSERT INTO "flight" VALUES (34,34,35,'2023-07-13','09:15:00','12:15:00',215.75);
INSERT INTO "flight" VALUES (35,35,36,'2023-07-14','11:45:00','14:45:00',205.5);
INSERT INTO "flight" VALUES (36,36,37,'2023-07-15','14:30:00','17:30:00',245.25);
INSERT INTO "flight" VALUES (37,37,38,'2023-07-16','17:00:00','20:00:00',235.0);
INSERT INTO "flight" VALUES (38,38,39,'2023-07-17','09:45:00','12:45:00',224.75);
INSERT INTO "flight" VALUES (39,39,40,'2023-07-18','12:15:00','15:15:00',264.5);
INSERT INTO "flight" VALUES (40,40,41,'2023-07-19','15:45:00','18:45:00',254.25);
INSERT INTO "flight" VALUES (41,41,42,'2023-07-20','08:30:00','11:30:00',244.0);
INSERT INTO "flight" VALUES (42,42,43,'2023-07-21','11:00:00','14:00:00',283.75);
INSERT INTO "flight" VALUES (43,43,44,'2023-07-22','14:15:00','17:15:00',273.5);
INSERT INTO "flight" VALUES (44,44,45,'2023-07-23','18:30:00','21:30:00',263.25);
INSERT INTO "flight" VALUES (45,45,46,'2023-07-24','09:45:00','12:45:00',253.0);
INSERT INTO "flight" VALUES (46,46,47,'2023-07-25','12:30:00','15:30:00',292.75);
INSERT INTO "flight" VALUES (47,47,48,'2023-07-26','15:00:00','18:00:00',282.5);
INSERT INTO "flight" VALUES (48,48,49,'2023-07-27','08:15:00','11:15:00',272.25);
INSERT INTO "flight" VALUES (49,49,50,'2023-07-28','11:30:00','14:30:00',312.0);
COMMIT;
