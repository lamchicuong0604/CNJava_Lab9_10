# Final_JavaTech

This is a Java Spring Boot project developed for a final project in Java Technologies course. The project is a simple web application that allows users to create, read, update, and delete (CRUD) products in a MySQL database.

## Requirements

To run this project, you need to have the following software installed on your machine:

- Java JDK 8 or higher
- Maven 3.6 or higher
- MySQL 5.6 or higher

## Installation

To install and run this project, follow these steps:

1. Clone the project repository to your local machine using the following command:
  **git clone https://github.com/hellfive123/Final_JavaTech.git**

2. Navigate to the project directory: **cd Final_JavaTech**.

3. Create a database named **webapp**.

4. Edit the application.properties file in the src/main/resources folder to match your MySQL database configuration:
  **spring.datasource.url=jdbc:mysql://localhost:3306/webapp<br />**
  **spring.datasource.username=your_database_username<br />**
  **spring.datasource.password=your_database_password<br />**
  
5. Build the project using Maven: **mvn clean install**.

6. Run the project using Maven: **mvn spring-boot:run**.

7. The project should now be running on `http://localhost:8080/login`. You can access the web application by visiting this URL in your web browser.






