CREATE TABLE `employee` 
(
  
`Id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  
`first_name` varchar(25) NOT NULL,
  
`last_name` varchar(25) NOT NULL,
  
`address` varchar(45) NOT NULL,
  
`dob` date NOT NULL,
  
`mobile` varchar(45) NOT NULL,
  
`city` varchar(30) NOT NULL,
  
`email` varchar(45) NOT NULL,
  
`organization` varchar(45) NOT NULL
 
);