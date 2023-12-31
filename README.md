## Urban Gear Ecommerce Platform Documentation

## Project Repository Name: UrbanGear-Ecommerce

### Table of Contents
1. [Introduction](#introduction)
2. [Project Requirements](#project-requirements)
3. [Project Plan](#project-plan)
4. [Source Code](#source-code)
5. [Database Schema](#database-schema)
6. [User Documentation](#user-documentation)
7. [Technical Documentation](#technical-documentation)
8. [Screenshots](#screenshots)
   - [Welcome Page](#welcome-page)
   - [Login Page](#login-page)
   - [Registration Page](#registration-page)
   - [User Homepage](#user-homepage)
   - [Checkout Page](#checkout-page)
   - [Success Order Page](#success-order-page)
   - [Admin Welcome Page](#admin-welcome-page)
   - [Admin Insert Item Page](#admin-insert-item-page)
   - [Admin Items List Page](#admin-items-list-page)
   - [Admin Contact Form Page](#admin-Contact-Form-page)

---

### 1. Introduction<a name="introduction"></a>

Welcome to the documentation for the **Urban Gear Ecommerce Platform**, an innovative and feature-rich web application developed for Urban Gear's shoe collection. This document provides a comprehensive guide to the project, including its requirements, design, implementation details, and usage instructions.

### 2. Project Requirements<a name="project-requirements"></a>

#### 2.1 Purpose of the Project
The purpose of the Urban Gear Ecommerce Platform is to provide users with a seamless and secure online shopping experience for Urban Gear's shoe collection. The platform includes both user and admin dashboards, ensuring a personalized and efficient journey for clients and administrators.

#### 2.2 Expected Outcomes
- User-friendly interfaces for both clients and administrators.
- Secure user authentication and authorization mechanisms.
- Efficient management of product listings, orders, and client inquiries.
- Seamless payment processing and order fulfillment.
- Robust error handling and graceful user feedback.

#### 2.3 Specific Constraints or Limitations
- Session duration limited to 5 minutes of inactivity.
- Passwords are encrypted during user registration for enhanced security.

### 3. Project Plan<a name="project-plan"></a>

The project plan outlines the scope, timeline, and resources used to complete the Urban Gear Ecommerce Platform. It includes the following phases:
- Requirement Identification
- Database Design
- Spring Boot Project Setup
- Database Setup
- Domain Model Creation
- Service Layer Implementation
- Controller Layer Implementation
- View Layer Implementation
- Testing
- Deployment
- Authentication and Authorization
- Validation
- Pagination
- Search and Filtering
- Error Handling
- Caching
- File Upload and Download

### 4. Source Code<a name="source-code"></a>

#### 4.1 Maven Spring Boot Application

### Prerequisites

Before running the application, ensure you have the following installed:

- Java Development Kit (JDK)
- Maven
- MySQL Server
- Redis Server

To run the application, execute the following Maven command in the terminal:

```bash
mvn spring-boot:run
```

#### 4.2 Start Redis Server
Ensure Redis is installed and start the server using the following command:

```bash
redis-server
```

#### 4.3 Start MySQL Server
Start the MySQL server using your preferred method or the following command:

```bash
mysql.server start
```


### 6. User Documentation<a name="user-documentation"></a>

#### 6.1 User Journey
1. **Login and Registration:**
   - Navigate to the login or registration page.
   - Provide credentials for login or fill in the registration form.
   - Click "Submit" to proceed.

2. **Browsing and Adding to Cart:**
   - Explore the user homepage showcasing available shoe collections.
   - Click on a shoe to view details.
   - Add desired items to the cart.
   - Navigate to the cart to review and modify selections.

3. **Checkout and Payment:**
   - Proceed to checkout.
   - Review items and modify the cart if needed.
   - Enter payment information in the form.
   - Click "Complete Purchase" to confirm.

4. **Order Confirmation:**
   - Receive a confirmation email.
   - View the success order page for details.

5. **Contact Form:**
   - Use the navbar to access the contact form.
   - Submit inquiries or requests.

6. **Logout:**
   - Terminate the session by clicking "Logout."

### 7. Technical Documentation<a name="technical-documentation"></a>

#### 7.1 Technology Stack
- Frontend: HTML, CSS, Bootstrap, Javascript,jQuery
- Backend: Java, Spring Boot
- Database: MySQL
- Dependencies: Spring Data JPA, Spring Web, Spring Boot DevTools, Lombok, Spring Boot Test, Spring Boot Data Redis, Spring Session Data Redis, Spring Boot Mail
- Server: Redis Cache Server

#### 7.2 Implementation Steps
I followed these steps to implement the Urban Gear Ecommerce Platform:
1. Identify Requirements
2. Design Database
3. Create Spring Boot Project
4. Set Up Database
5. Create Domain Model
6. Implement Service Layer
7. Implement Controller Layer
8. Implement View Layer
9. Test Web Application
10. Deploy on GitHub



### 5. Database Schema<a name="database-schema"></a> Entity Relationships

#### 5.1 Entity Relationships
The project involves three main entities: User, Shoe, and Order but not limited to ContactForm entity.

### 6. Screenshots<a name="screenshots"></a>

Welcome Page
  ![image](https://github.com/wi127/Ecommerceshoeapp/assets/114063736/13393e6e-f040-43ba-afcf-0fc0ef0aa5d6)


Login Page
  
![image](https://github.com/wi127/Ecommerceshoeapp/assets/114063736/dba544e0-4438-4204-bc60-c6f84d33dab9)

Registration Page
  ![image](https://github.com/wi127/Ecommerceshoeapp/assets/114063736/3865c50b-fd34-49ab-addd-5bce7fc08265)

User Homepage
  
![image](https://github.com/wi127/Ecommerceshoeapp/assets/114063736/48bfd042-dc4b-44a5-b948-8e7ef6ab7557)


Checkout Page
  ![image](https://github.com/wi127/Ecommerceshoeapp/assets/114063736/8dc3b0df-1a39-4c7d-84af-aca8d7923a6f)



Success Order Page
  ![image](https://github.com/wi127/Ecommerceshoeapp/assets/114063736/3e1f4573-46bc-4868-bc95-88f4a219a567)


Admin Welcome Page
 ![image](https://github.com/wi127/Ecommerceshoeapp/assets/114063736/b9fbfdd8-443b-40dd-8b05-0a95eec49f6c)

 
Admin Insert Item Page
  
![image](https://github.com/wi127/Ecommerceshoeapp/assets/114063736/a66e5f31-b5cd-465e-9982-1658395487ff)

Admin Items List Page
 ![image](https://github.com/wi127/Ecommerceshoeapp/assets/114063736/b36830fc-00c0-4411-a905-0ca6ee833aca)

 
Admin Contact Form Page
 
 ![image](https://github.com/wi127/Ecommerceshoeapp/assets/114063736/8725e5cd-e729-4111-b5ec-daa274282c7a)

________________________________________
Conclusion
This comprehensive documentation outlines the project scope, plan, stack, and user/admin journeys. Follow the setup steps to run the application and ensure a smooth user experience. Any further enhancements or modifications can be incorporated based on the evolving requirements of the Urban Gear Shoes E-commerce platform.

