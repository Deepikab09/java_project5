CREATE DATABASE IF NOT EXISTS student_management;

USE student_management;

CREATE TABLE IF NOT EXISTS students (

    id INT PRIMARY KEY AUTO_INCREMENT,

    name VARCHAR(100) NOT NULL,

    email VARCHAR(120) NOT NULL UNIQUE,

    course VARCHAR(100) NOT NULL,

    age INT NOT NULL,

    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    CONSTRAINT chk_student_age CHECK (age BETWEEN 1 AND 120)
);

-- Sample record

INSERT INTO students(name, email, course, age)
VALUES (
    'Demo Student',
    'demo@example.com',
    'Computer Science',
    20
)
ON DUPLICATE KEY UPDATE name = VALUES(name);
