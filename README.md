# eMutuelle - Electronic Mutuelle de Sante Management System

## Description
eMutuelle is a Spring Boot REST API for managing Rwanda's health insurance system (Mutuelle de Sante). It implements the full Rwanda administrative structure and allows health insurance members to be registered and managed.

## Student Information
- **University:** Adventist University of Central Africa (AUCA)
- **Course:** Web Technology and Internet
- **Year:** 2026

## Tech Stack
- Java 17
- Spring Boot 3.2
- PostgreSQL
- Maven
- Spring Data JPA

## Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/emutuelle
spring.datasource.username=postgres
spring.datasource.password=your_password

## Entity Relationship Diagram
The system uses 8 tables with the following relationships:

### Location Hierarchy (One-to-Many)
Province → District → Sector → Cell → Village → Member

### Other Relationships
- Member ↔ MemberCard (One-to-One)
- Member ↔ HealthPackage (Many-to-Many via member_health_package)

## API Endpoints

### Province
- POST /api/provinces - Create province
- GET /api/provinces - Get all provinces

### District
- POST /api/districts - Create district
- GET /api/districts - Get all districts

### Sector
- POST /api/sectors - Create sector
- GET /api/sectors - Get all sectors

### Cell
- POST /api/cells - Create cell
- GET /api/cells - Get all cells

### Village
- POST /api/villages - Create village
- GET /api/villages - Get all villages

### Health Package
- POST /api/packages - Create health package
- GET /api/packages - Get all packages

### Member
- POST /api/members - Register member (links to Village only)
- GET /api/members?page=0&size=5&sortBy=lastName&direction=ASC - Get members with pagination and sorting
- GET /api/members/province/code/{code} - Get members by province code
- GET /api/members/province/name/{name} - Get members by province name
- POST /api/members/{memberId}/packages/{packageId} - Assign health package to member

## How to Run
1. Make sure PostgreSQL is running
2. Create database named 'emutuelle'
3. Run the application:
mvn clean package -DskipTests
java -jar target/emutuelle-0.0.1-SNAPSHOT.jar
4. API is available at http://localhost:8080

## Key Features
- Full Rwanda administrative structure (Province → District → Sector → Cell → Village)
- Members are registered using Village only - automatically linked to full location chain
- Pagination and sorting for member retrieval
- Auto-generated MemberCard on member registration
- Duplicate check using existsByNationalId() and existsByEmail()
- Many-to-Many relationship between Member and HealthPackage
- One-to-One relationship between Member and MemberCard