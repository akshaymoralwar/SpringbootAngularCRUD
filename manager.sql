CREATE TABLE `manager` 
(
  
`id` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  
`first_name` varchar(25) NOT NULL,
  
`last_name` varchar(25) NOT NULL,
  
`address` varchar(45) NOT NULL,
  
`dob` date NOT NULL,
  
`organization` varchar(45) NOT NULL,
  
`password` varchar(45) NOT NULL,
  
`email` varchar(45) NOT NULL,
  
`city` varchar(255) DEFAULT NULL,
  
`mobile` varchar(255) DEFAULT NULL

);