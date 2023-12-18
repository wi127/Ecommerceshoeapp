Urban Gear Ecommerce Platform Documentation
Project Repository Name: UrbanGear-Ecommerce
Table of Contents
1.	Introduction
2.	Project Requirements
3.	Project Plan
4.	Source Code
5.	Database Schema
6.	User Documentation
7.	Technical Documentation
8.	Screenshots
o	Welcome Page
o	Login Page
o	Registration Page
o	User Homepage
o	Checkout Page
o	Success Order Page
o	Admin Welcome Page
o	Admin Insert Item Page
o	Admin Items List Page
o	Admin Contact Form Page
________________________________________
1. Introduction
Welcome to the documentation for the Urban Gear Ecommerce Platform, an innovative and feature-rich web application developed for Urban Gear's shoe collection. This document provides a comprehensive guide to the project, including its requirements, design, implementation details, and usage instructions.
2. Project Requirements
2.1 Purpose of the Project
The purpose of the Urban Gear Ecommerce Platform is to provide users with a seamless and secure online shopping experience for Urban Gear's shoe collection. The platform includes both user and admin dashboards, ensuring a personalized and efficient journey for clients and administrators.
2.2 Expected Outcomes
•	User-friendly interfaces for both clients and administrators.
•	Secure user authentication and authorization mechanisms.
•	Efficient management of product listings, orders, and client inquiries.
•	Seamless payment processing and order fulfillment.
•	Robust error handling and graceful user feedback.
2.3 Specific Constraints or Limitations
•	Session duration limited to 5 minutes of inactivity.
•	Passwords are encrypted during user registration for enhanced security.
3. Project Plan
The project plan outlines the scope, timeline, and resources used to complete the Urban Gear Ecommerce Platform. It includes the following phases:
•	Requirement Identification
•	Database Design
•	Spring Boot Project Setup
•	Database Setup
•	Domain Model Creation
•	Service Layer Implementation
•	Controller Layer Implementation
•	View Layer Implementation
•	Testing
•	Deployment
•	Authentication and Authorization
•	Validation
•	Pagination
•	Search and Filtering
•	Error Handling
•	Caching
•	File Upload and Download
4. Source Code
4.1 Maven Spring Boot Application
Prerequisites
Before running the application, ensure you have the following installed:
•	Java Development Kit (JDK)
•	Maven
•	MySQL Server
•	Redis Server
To run the application, execute the following Maven command in the terminal:
mvn spring-boot:run
4.2 Start Redis Server
Ensure Redis is installed and start the server using the following command:
redis-server
4.3 Start MySQL Server
Start the MySQL server using your preferred method or the following command:
mysql.server start
6. User Documentation
6.1 User Journey
1.	Login and Registration:
o	Navigate to the login or registration page.
o	Provide credentials for login or fill in the registration form.
o	Click "Submit" to proceed.
2.	Browsing and Adding to Cart:
o	Explore the user homepage showcasing available shoe collections.
o	Click on a shoe to view details.
o	Add desired items to the cart.
o	Navigate to the cart to review and modify selections.
3.	Checkout and Payment:
o	Proceed to checkout.
o	Review items and modify the cart if needed.
o	Enter payment information in the form.
o	Click "Complete Purchase" to confirm.
4.	Order Confirmation:
o	Receive a confirmation email.
o	View the success order page for details.
5.	Contact Form:
o	Use the navbar to access the contact form.
o	Submit inquiries or requests.
6.	Logout:
o	Terminate the session by clicking "Logout."
7. Technical Documentation
7.1 Technology Stack
•	Frontend: HTML, CSS, Bootstrap, Javascript,jQuery
•	Backend: Java, Spring Boot
•	Database: MySQL
•	Dependencies: Spring Data JPA, Spring Web, Spring Boot DevTools, Lombok, Spring Boot Test, Spring Boot Data Redis, Spring Session Data Redis, Spring Boot Mail
•	Server: Redis Cache Server
7.2 Implementation Steps
I followed these steps to implement the Urban Gear Ecommerce Platform:
1.	Identify Requirements
2.	Design Database
3.	Create Spring Boot Project
4.	Set Up Database
5.	Create Domain Model
6.	Implement Service Layer
7.	Implement Controller Layer
8.	Implement View Layer
9.	Test Web Application
10.	Deploy on GitHub
5. Database Schema Entity Relationships
5.1 Entity Relationships
The project involves three main entities: User, Shoe, and Order but not limited to ContactForm entity.
7.	Screenshots

Welcome Page
  

Login Page
  

Registration Page
  
User Homepage
  


Checkout Page
  


Success Order Page
  

Admin Welcome Page
 
 
Admin Insert Item Page
  

Admin Items List Page
 
 
Admin Contact Form Page
 
 
________________________________________
Conclusion
This comprehensive documentation outlines the project scope, plan, stack, and user/admin journeys. Follow the setup steps to run the application and ensure a smooth user experience. Any further enhancements or modifications can be incorporated based on the evolving requirements of the Urban Gear Shoes E-commerce platform.

