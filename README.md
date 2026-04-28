# Student Management System (AI-Enhanced)

This Spring Boot API manages student records and automates academic feedback using Google Gemini. It handles the core logic for enrollments, grading, and performance analysis through a dedicated AI integration.

## Project Goal
The system is designed to move beyond simple data storage by using Large Language Models (LLMs) to support both students and faculty. It tracks the full student lifecycle—enrollment, attendance, and grading—while providing "Smart Study Paths" for students and "Class Performance Analytics" for teachers.

## Tech Stack
- **Backend:** Java 21, Spring Boot 3.4.x (Spring Boot 4.0.6-SNAPSHOT), Spring Data JPA
- **AI Integration:** Spring AI + Google Gemini
- **Security:** Spring Security + JWT (JSON Web Tokens)
- **Database:** H2 (Development) / PostgreSQL (Production)
- **Documentation:** Swagger / OpenAPI 3.0

## Prerequisites
- **JDK 21**
- **Maven 3.9+** (or use the included `./mvnw` wrapper)
- **Google Gemini API Key** (Available via [Google AI Studio](https://google.com))

## Access Control Matrix (RBAC)
The system enforces strict business rules through Role-Based Access Control:


| Feature                   | Admin | Teacher | Student |
| :------------------------ | :---: | :---: | :---: |
| Manage Users (CRUD)       | ✅    | ❌     | ❌     |
| Create Courses & Batches  | ✅    | ❌     | ❌     |
| Mark Daily Attendance     | ❌     | ✅     | ❌     |
| Input/Edit Grades         | ❌     | ✅     | ❌     |
| View Personal Records/GPA | ❌     | ❌     | ✅     |
| AI Performance Analysis   | ✅    | ✅     | ✅     |

## Entity Architecture
- **User & Role:** Unified account system with secure authentication.
- **Course:** Academic modules assigned to specific teachers.
- **Enrollment:** Persistence layer linking students to active courses.
- **Grade:** Performance data points used for AI-driven feedback loops.

## Project Roadmap
- [x] Initial Spring Boot & Dependency Setup
- [x] Secure Environment Variable Configuration
- [x] Core JPA Entities & Database Schema Design
- [ ] Repository Layer & Custom Queries
- [ ] Service Layer & Business Logic
- [ ] JWT Authentication & Security Configuration
- [ ] Google Gemini AI Service Integration


## Testing Strategy

To ensure a stable and bug-free system, the project follows a tiered testing approach:

- **Unit Testing (JUnit 5 & Mockito):** Testing business logic in the `Service` layer in isolation.
- **Integration Testing:** Verifying the `Repository` layer and H2 database interactions using `@DataJpaTest`.
- **API Testing:** Using `MockMvc` to test REST endpoints and ensure correct JSON responses and status codes.
- **Security Testing:** Verifying that JWT tokens correctly restrict unauthorized access to Admin/Teacher routes.


## Setup & Installation

1.  **Clone the repository:**

    ```bash
    git clone https://github.com/serventino-servenn/student-management-system.git
    ```
2.  **Set Environment Variables:**

    The API requires a Gemini key to run. Set this in your terminal:

    ```bash
    # Linux/Mac
    export GEMINI_API_KEY='your_actual_key_here'

    # Windows (PowerShell)
    $env:GEMINI_API_KEY="your_actual_key_here"
    ```
3.  **Run the Application:**

    ```bash
    ./mvnw spring-boot:run
    ```

## API Documentation (Swagger)
Once the server is running, you can access the interactive documentation and test the endpoints here:

🔗 **Swagger UI:** [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)

Use this interface to visualize REST endpoints, check request/response schemas, and execute live API calls against the local database.
