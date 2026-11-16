package com.deepika.studentmanagement;

import java.sql.*;
import java.util.*;

public class StudentDAO {

    // CREATE: Add student
    public Student addStudent(Student student) throws SQLException {

        String sql = "INSERT INTO students(name,email,course,age) VALUES(?,?,?,?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                 sql, Statement.RETURN_GENERATED_KEYS)) {

            bindStudent(ps, student);
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    student.setId(rs.getInt(1));
                }
            }
        }

        return student;
    }

    // READ: Display all students
    public List<Student> getAllStudents() throws SQLException {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT id,name,email,course,age FROM students ORDER BY id";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                students.add(map(rs));
            }
        }

        return students;
    }

    // READ: Search student by ID
    public Optional<Student> getStudentById(int id) throws SQLException {

        String sql = "SELECT id,name,email,course,age FROM students WHERE id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next()
                    ? Optional.of(map(rs))
                    : Optional.empty();
            }
        }
    }

    // UPDATE: Modify student
    public boolean updateStudent(Student student) throws SQLException {

        String sql = "UPDATE students SET name=?,email=?,course=?,age=? WHERE id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            bindStudent(ps, student);
            ps.setInt(5, student.getId());

            return ps.executeUpdate() == 1;
        }
    }

    // DELETE: Remove student
    public boolean deleteStudent(int id) throws SQLException {

        String sql = "DELETE FROM students WHERE id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        }
    }

    // Transaction handling: Batch insertion
    public void addStudentsAsBatch(List<Student> students) throws SQLException {

        String sql = "INSERT INTO students(name,email,course,age) VALUES(?,?,?,?)";

        try (Connection con = DatabaseConnection.getConnection()) {

            con.setAutoCommit(false);

            try (PreparedStatement ps = con.prepareStatement(sql)) {

                for (Student student : students) {
                    bindStudent(ps, student);
                    ps.addBatch();
                }

                ps.executeBatch();
                con.commit();

            } catch (SQLException ex) {
                con.rollback();
                throw ex;

            } finally {
                con.setAutoCommit(true);
            }
        }
    }

    // Bind student values to SQL parameters
    private void bindStudent(PreparedStatement ps, Student student)
            throws SQLException {

        ps.setString(1, student.getName());
        ps.setString(2, student.getEmail());
        ps.setString(3, student.getCourse());
        ps.setInt(4, student.getAge());
    }

    // Convert database row into Student object
    private Student map(ResultSet rs) throws SQLException {

        return new Student(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("email"),
            rs.getString("course"),
            rs.getInt("age")
        );
    }
}
