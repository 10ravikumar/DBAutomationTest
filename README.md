# DBAutomationTest
Database Automation Testing using JOOQ library in End 2 End Automation.


##### Prerequisite
1. maven
2. openJDK 16+
3. H2 database up & running and execute below SQL script.
```
CREATE TABLE Persons (
    PersonID int,
    LastName varchar(255),
    FirstName varchar(255),
    Address varchar(255),
    City varchar(255)
);

INSERT INTO PERSONS (PersonID, LastName, FirstName, Address,City) VALUES (1, 'TOM', 'CHERRY', 'NOIDA','DELHI');
INSERT INTO PERSONS (PersonID, LastName, FirstName, Address, City) VALUES (2, 'TOMMY', 'SUNNY', 'NOIDA','DELHI');
```

Open your terminal and follow below steps.

#### Steps

Download the source code
```sh
$ git clone https://github.com/10ravikumar/DBAutomationTest.git
```
Go inside the folder
```sh
$ cd DBAutomationTest
```

Build the project code
```sh
$ mvn compile
```

Execute Database automation test.
```sh
$ mvn clean verify
```
