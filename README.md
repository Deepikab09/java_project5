

## 📌 Project Overview

The **Student Management System** is a console-based Java application integrated with a MySQL database using JDBC.

This project helps manage student information efficiently by performing database operations such as adding, viewing, searching, updating, and deleting student records.

## 🎯 Project Objectives

- Understand database concepts and SQL fundamentals.
- Learn JDBC architecture and database connectivity.
- Implement CRUD operations using Java and MySQL.
- Understand PreparedStatement and ResultSet.
- Implement database transaction handling.

## ✨ Features

- ➕ Add new student records.
- 📋 View all student details.
- 🔍 Search students using Student ID.
- ✏️ Update existing student information.
- 🗑️ Delete student records.
- 🔗 Connect Java applications with MySQL.
- 🔒 Use PreparedStatements for secure SQL execution.
- ⚡ Handle database transactions using Commit and Rollback.

## 🛠️ Technologies Used

- **Programming Language:** Java
- **Database:** MySQL
- **Connectivity:** JDBC
- **Build Tool:** Maven
- **IDE:** IntelliJ IDEA / Eclipse
- **Database Driver:** MySQL Connector/J

## 📂 Project Structure

```text
Java-MySQL-Student-Management-System/
│
├── database/
│   └── schema.sql
│
├── src/main/java/com/deepika/studentmanagement/
│   ├── Main.java
│   ├── Student.java
│   ├── StudentDAO.java
│   ├── StudentService.java
│   └── DatabaseConnection.java
│
├── docs/
│   ├── DESIGN_DOCUMENT.md
│   └── UML_CLASS_DIAGRAM.md
│
├── pom.xml
├── README.md
└── .gitignore
```

## 🗄️ Database Design

Database Name: `student_management`

Table Name: `students`

| Column | Data Type |
|---|---|
| id | INT (Primary Key) |
| name | VARCHAR(100) |
| email | VARCHAR(120) |
| course | VARCHAR(100) |
| age | INT |
| created_at | TIMESTAMP |

## ⚙️ How to Run the Project

**Step 1:** Install Java JDK 17, MySQL and Maven.

**Step 2:** Execute the `database/schema.sql` file in MySQL Workbench.

**Step 3:** Configure your MySQL database username and password using environment variables.

**Step 4:** Open the project in your Java IDE.

**Step 5:** Run the following commands:

```bash
mvn clean compile
mvn exec:java
```

## 💻 Application Menu

```text
JAVA + MYSQL STUDENT MANAGEMENT

1. Add Student
2. View All Students
3. Search Student by ID
4. Update Student
5. Delete Student
0. Exit
```

## 📚 Concepts Learned

- Java Database Connectivity (JDBC)
- SQL Queries
- CRUD Operations
- PreparedStatement
- ResultSet
- Database Connection Management
- Exception Handling
- Transaction Management
- Java Object-Oriented Programming

## 🚀 Future Enhancements

- Student login and authentication.
- Graphical User Interface (GUI).
- Student attendance management.
- Report generation.
- Advanced search and filtering.

## 👩‍💻 Author

**Deepika B**

B.Tech – Artificial Intelligence and Data Science

## ⭐ Conclusion

This project provided practical experience in integrating Java with MySQL using JDBC. It strengthened my understanding of database connectivity, SQL operations, and real-world Java application development.

---

⭐ If you find this project useful, feel free to explore the repository!
