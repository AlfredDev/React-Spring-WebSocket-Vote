
# React-Spring-WebSocket-Vote

## Overview

**React-Spring-WebSocket-Vote** is an application designed for creating and managing polls in real-time using WebSockets. This full-stack project leverages modern technologies like Spring Boot, React, and PostgreSQL to deliver a seamless user experience. The application allows users to participate in polls, see live updates, and ensure secure access with JWT authentication.

## Features

- **Real-Time Polling:** Leverages WebSockets to provide real-time updates to all participants as votes are cast.
- **User Authentication:** Secure authentication using JWT (JSON Web Token) to protect user sessions and data.
- **RESTful API:** Built with Spring Boot to handle the backend logic and database interactions.
- **Modern Frontend:** Developed using React with TypeScript for type-safe code and Axios for API requests.
- **Persistent Storage:** Uses PostgreSQL as the database to store user data, poll information, and vote counts.
- **Deployment:** The application is deployed with Render, ensuring scalable and reliable hosting for the frontend, backend, and database.

## Technologies

- **Frontend:**
  - React
  - TypeScript
  - Axios
  - Vit
  - Taiwind
- **Backend:**
  - Spring Boot
  - Java
  - WebSocket
  - JWT (JSON Web Token)
  - Swagger
- **Database:**
  - PostgreSQL
- **Deployment:**
  - Render (Frontend, Backend, Database)
  - Docker
  - GitHub Actions (CI/CD)

## Setup and Installation

To get the application up and running locally, follow these steps:

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/AlfredDev/React-Spring-WebSocket-Vote.git
   ```

2. **Backend:**
   - Navigate to the `Vote` directory.
   - Ensure you have Java and Maven installed.
   - Run the following command to start the Spring Boot application:
     ```bash
     mvn spring-boot:run
     ```
   - The backend will start on `http://localhost:8080`.

3. **Frontend:**
   - Navigate to the `votingWebSockets-Front` directory.
   - Ensure you have Node.js and npm installed.
   - Install the dependencies:
     ```bash
     npm install
     ```
   - Start the development server:
     ```bash
     npm run dev
     ```
   - The frontend will start on `http://localhost:3000`.

4. **Database:**
   - Ensure PostgreSQL is installed and running.
   - Create a database named `voting_app`.
   - Update the database configuration in the `application.properties` file located in the backend project.

5. **CI/CD and Deployment:**
   - Docker: The application is containerized using Docker. Ensure Docker is installed on your machine, and use the provided Dockerfile and docker-compose.yml for setting up the containers.
   - GitHub Actions: The project includes a CI/CD pipeline using GitHub Actions. The pipeline is configured to build, test, and deploy the application automatically.

## Contributing

Feel free to open issues or submit pull requests if you find bugs or have new features you'd like to add.

## License

This project is licensed under the MIT License.

---
