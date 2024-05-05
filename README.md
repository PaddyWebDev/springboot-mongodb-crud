# Spring Boot MongoDB CRUD Application

This repository contains a CRUD (Create, Read, Update, Delete) application built with Spring Boot and MongoDB. It provides a comprehensive backend solution for managing data in a MongoDB database using the Spring Boot framework.

## Features

- **Create**: Allows users to create new records in the MongoDB database.
- **Read**: Enables users to retrieve and view existing records from the MongoDB database.
- **Update**: Provides functionality to update existing records in the MongoDB database.
- **Delete**: Allows users to delete records from the MongoDB database.

## Prerequisites

Before running the application, ensure that you have the following prerequisites installed:

- Java Development Kit (JDK) 22
- Maven
- MongoDB

## Getting Started

Follow these steps to get the application up and running on your local machine:

1. Clone this repository to your local machine.
2. Configure the MongoDB connection settings in the `application.properties` file.
3. Build the project using Maven: `mvn clean install`.
4. Run the application: `mvn spring-boot:run`.

## Usage

Once the application is running, you can perform CRUD operations using HTTP requests. Here are the endpoints available:

- **Create**: `POST /users/create`
- **Read**: `GET /users/get/{id}` (for retrieving a single resource) or `GET /users/get` (for retrieving all resources)
- **Update**: `PUT /users/update/{id}`
- **Delete**: `DELETE /users/delete/{id}`


## Contributing

Contributions are welcome! Feel free to open issues or submit pull requests to contribute to this project.

