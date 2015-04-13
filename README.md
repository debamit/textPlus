# textPlus
Text plus project

Database Scripts

Use test;

CREATE TABLE member (member_id int(20) NOT NULL AUTO_INCREMENT,
		     name VARCHAR(255) unique,
		     email VARCHAR(255),
		     phone VARCHAR(255),primary key(member_id));


Running Locally (Spring Boot project)

Clone repo git clone https://github.com/debamit/textPlus.git.

If: maven installed : mvn clean spring-boot:run. 
Else: Run main method as Java Application under MgoProjectApplication

Rest end points

//Create member

http://localhost:8080/api/members/create

Eg:

curl -H "Content-Type: application/json" -X POST -d '{"email":"test3@test.com","name":"test3","phone":"310-333-3333"}' http://localhost:8080/api/members/create


// Find All members

http://localhost:8080/api/members