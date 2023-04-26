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

## Usage

Once you have the project up and running, you can use the web application to perform CRUD operations on the products in your MySQL database.

1. To create a new product, click the "New Product" button on the homepage and fill out the form.
2. To view all products, click the "All Products" button on the homepage.
3. To update a product, click the "Edit" button next to the product you want to update and fill out the form.
4. To delete a product, click the "Delete" button next to the product you want to delete.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.




