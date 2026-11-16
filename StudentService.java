package com.deepika.studentmanagement;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class StudentService {

    private final StudentDAO dao;

    public StudentService(StudentDAO dao) {
        this.dao = dao;
    }

    // Add student
    public Student addStudent(
            String name, String email, String course, int age)
            throws SQLException {

        Student student = new Student(name, email, course, age);
        return dao.addStudent(student);
    }

    // View all students
    public List<Student> getAllStudents() throws SQLException {
        return dao.getAllStudents();
    }

    // Search student
    public Optional<Student> getStudent(int id) throws SQLException {
        checkId(id);
        return dao.getStudentById(id);
    }

    // Update student
    public boolean updateStudent(
            int id, String name, String email, String course, int age)
            throws SQLException {

        checkId(id);

        Student student = new Student(id, name, email, course, age);

        return dao.updateStudent(student);
    }

    // Delete student
    public boolean deleteStudent(int id) throws SQLException {
        checkId(id);
        return dao.deleteStudent(id);
    }

    // Validate ID
    private void checkId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                "Student ID must be positive."
            );
        }
    }
}
