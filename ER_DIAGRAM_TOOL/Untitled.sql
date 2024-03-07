CREATE TABLE `department` (
  `dname` varchar(25) NOT NULL,
  `dnumber` integer PRIMARY KEY,
  `mgrssn` char(9) NOT NULL,
  `mgrstartdate` date
);

CREATE TABLE `dept_locations` (
  `dnumber` integer,
  `dlocation` varchar(15),
  PRIMARY KEY (`dnumber`, `dlocation`)
);

CREATE TABLE `employee` (
  `fname` varchar(15) NOT NULL,
  `minit` varchar(1),
  `lname` varchar(15) NOT NULL,
  `ssn` char(9) PRIMARY KEY NOT NULL,
  `bdate` date,
  `address` varchar(50),
  `sex` char,
  `salary` decimal(10,2),
  `superssn` char(9),
  `dno` integer
);

CREATE TABLE `project` (
  `pname` varchar(25) NOT NULL,
  `pnumber` integer PRIMARY KEY,
  `plocation` varchar(15),
  `dnum` integer NOT NULL
);

CREATE TABLE `dependentperson` (
  `essn` char(9),
  `dependent_name` varchar(15),
  `sex` char,
  `bdate` date,
  `relationship` varchar(8),
  PRIMARY KEY (`essn`, `dependent_name`)
);

CREATE TABLE `works_on` (
  `essn` char(9),
  `pno` integer,
  `hours` decimal(4,1),
  PRIMARY KEY (`essn`, `pno`)
);

CREATE UNIQUE INDEX `department_index_0` ON `department` (`dname`);

CREATE UNIQUE INDEX `project_index_1` ON `project` (`pname`);

ALTER TABLE `dept_locations` ADD FOREIGN KEY (`dnumber`) REFERENCES `department` (`dnumber`);

ALTER TABLE `employee` ADD FOREIGN KEY (`dno`) REFERENCES `department` (`dnumber`);

ALTER TABLE `employee` ADD FOREIGN KEY (`superssn`) REFERENCES `employee` (`ssn`) ON DELETE NO ACTION;

ALTER TABLE `project` ADD FOREIGN KEY (`dnum`) REFERENCES `department` (`dnumber`);

ALTER TABLE `dependentperson` ADD FOREIGN KEY (`essn`) REFERENCES `employee` (`ssn`);

ALTER TABLE `works_on` ADD FOREIGN KEY (`essn`) REFERENCES `employee` (`ssn`);

ALTER TABLE `works_on` ADD FOREIGN KEY (`pno`) REFERENCES `project` (`pnumber`);
