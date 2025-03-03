# Surabi API

# Overview
Surabi is a RESTful API built using Spring Boot, Spring Security, JWT authentication, and Swagger for API documentation.

# How to Set Up and Run the Application Locally

# Step 1: Clone the Repository
git clone https://github.com/Aacgectyuoki/Surabi_Restaurant.git
cd surabi-api

# Step 2: Open the Project in IntelliJ IDEA
Open IntelliJ IDEA (or your preferred IDE).
Click File → Open → Select the surabi-api folder.
Wait for Maven dependencies to load.

# Step 3: Configure Application Properties
Navigate to src/main/resources/application.properties.
Update the following values:
properties
Copy
Edit
spring.application.name=Surabi

# Database Configuration (H2 In-Memory)
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Logging
logging.level.root=DEBUG
logging.level.org.springframework=DEBUG
logging.level.org.springframework.web=DEBUG

# Security Configuration
spring.security.user.name=your_admin_username
spring.security.user.password=your_admin_password

# JWT Secret Key
jwt.secret=your-secret-key

# Swagger Configuration
springdoc.api-docs.enabled=true
springdoc.swagger-ui.enabled=true
springdoc.swagger-ui.oauth.client-id=swagger
springdoc.swagger-ui.oauth.client-secret=swagger-secret
springdoc.swagger-ui.persistAuthorization=true
Step 4: Run the Application
Method 1: Using IntelliJ
Open SurabiApplication.java.
Click Run or press Shift + F10.
Method 2: Using Terminal
Open the terminal in IntelliJ.
Run the following command:
sh
Copy
Edit
mvn spring-boot:run
How to Test the API
Step 5: Test with Postman
Open Postman.

Login to get a JWT Token:

POST http://localhost:8080/auth/login
Body (JSON):
json
Copy
Edit
{
  "username": "your_admin_username",
  "password": "your_admin_password"
}
Copy the JWT token from the response.
Use the Token for Authenticated Requests:

Go to Authorization → Select Bearer Token.
Paste the copied JWT token.
Example API calls:
Get Users: GET http://localhost:8080/api/users
Create User: POST http://localhost:8080/api/users
Update User: PUT http://localhost:8080/api/users/{id}
Delete User: DELETE http://localhost:8080/api/users/{id}
Step 6: Test with Swagger UI
Open Swagger UI in your browser:
bash
Copy
Edit
http://localhost:8080/swagger-ui/index.html
Click on the Authorize button.
Enter the JWT token from Postman.
Test different endpoints directly from Swagger.
Step 7: Access H2 Database Console
Open H2 Console in your browser:
bash
Copy
Edit
http://localhost:8080/h2-console
Enter the following credentials (from application.properties):
JDBC URL: jdbc:h2:mem:testdb
Username: your_db_username
Password: your_db_password
Click Connect to view the database.
