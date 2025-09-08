UFC Fight Explorer
A full-stack web application for exploring UFC fight statistics and fighter data.
Tech Stack
Backend

Spring Boot 3.5.5 - REST API framework
Java 21 - Programming language
Maven - Dependency management
OpenCSV - CSV data processing

Frontend

Next.js 15 - React framework
TypeScript - Type-safe JavaScript
Tailwind CSS - Utility-first CSS framework

Database

PostgreSQL - Relational database
pgAdmin - Database management interface

Data Processing

Python - Data exploration and analysis
pandas - Data manipulation library

Development Tools

Git/GitHub - Version control
VS Code - Code editor
Node.js & npm - JavaScript runtime and package manager

API Endpoints

GET /api/fighters - Retrieve all fighters
GET /api/fighters/search?name={name} - Search fighters by name
GET /api/test - API health check

Features

RESTful API serving UFC fighter statistics
Fighter search functionality with query parameters
Responsive web interface with search capabilities
CSV data processing (6,500+ fight records)
Error handling and data validation

Setup
Backend
bashcd backend
./mvnw spring-boot:run
Frontend
bashcd frontend
npm run dev
Access the application at http://localhost:3000
API available at http://localhost:8080/api
