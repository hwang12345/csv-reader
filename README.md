# csv-reader
Java application which reads and parses data from a CSV file and inserts it into a local MySQL database. Multithreaded to improve reading/inserting performance.

### Prerequisites
The web application utilises a local MySQL database to store the CSV data. I recommend MySQL workbench -

MySQL Installer (MySQL Workbench, MySQL Server)- https://dev.mysql.com/downloads/installer/

You'll need to specify the corresponding MySQL (local) database details into the DAO file (Controller package) in order to successfully connect the application with the database.

You'll also need to create a table in MySQL called "Employees" with the corresponding fields listed.

``
If you wish to use your own custom CSV file, place your chosen CSV file under the resources folder and change the file path name in the EmployeeManager (Controller package).
``

## Built With
* [Maven](https://maven.apache.org/) - Dependency Management
* [JDBC API (javax.sql)](https://docs.oracle.com/javase/8/docs/technotes/guides/jdbc/) - Database connector
* [MySQL](https://dev.mysql.com/downloads/installer/) - Datastore
* [Log4J](https://mvnrepository.com/artifact/log4j/log4j) 
