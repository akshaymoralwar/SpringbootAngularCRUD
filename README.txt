CRUD Operations using Angular and Spring Boot

In this project the CRUD operations are carried out with angular as frontend and Java spring boot as server side
programming and MySQL as database.

Prerequisites:

Java 1.8 installed
Eclipse or Spring Tool Suite (STS) IDE
MySQL
Angular setup.

Steps to run the project,

a) Run the .sql scripts in the mysql workbench or mysql shell to create the database and the required tables.

b) 	1. For angular to run, go to the 'crudclient' folder and open a command prompt (terminal)
	2. run the command ng serve to start angular enviornment. 
	3. The an enviornment should be running on http://localhost:4200 
	4. Strictly do not close or quit the command prompt.
	
c) To run the java server, follow the steps given below:
	1. Open an IDE (eclipse or STS)
	2. Go to File -> Import -> Existing Maven project -> Location of 'CRUDDEMO' folder
		(CRUDDEMO is the folder where server side code sits.)
	3. Right click on the root folder in the IDE and select Maven -> Update Project
		(to update the project to local machine settings and repositories. If required update by selecting the 
		Force update to Snapshots\Releases.)
	4. After updating the project, Open the 'CrudDemoApplication', Right click in the editor and Select Run As -> Spring Boot Application.
	5.	The server shall be running on the http://localhost:8090/.
	
d) To run the application, follow the steps:
	1. Open browser (Google Chrome, Firefox, etc.)
	2. Go to http://localhost:4200 url. The application should be running now.

