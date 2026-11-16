package com.deepika.studentmanagement;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private final Scanner in = new Scanner(System.in);

    private final StudentService service =
        new StudentService(new StudentDAO());

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        System.out.println("======================================");
        System.out.println(" JAVA + MYSQL STUDENT MANAGEMENT");
        System.out.println("======================================");

        boolean running = true;

        while (running) {

            menu();

            String choice = in.nextLine().trim();

            try {

                switch (choice) {

                    case "1":
                        add();
                        break;

                    case "2":
                        list();
                        break;

                    case "3":
                        search();
                        break;

                    case "4":
                        update();
                        break;

                    case "5":
                        delete();
                        break;

                    case "0":
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (IllegalArgumentException e) {

                System.out.println("Validation error: " + e.getMessage());

            } catch (SQLException e) {

                System.out.println("Database error: " + e.getMessage());
                System.out.println(
                    "Check MySQL and DB_URL, DB_USER, DB_PASSWORD."
                );
            }
        }

        System.out.println("Application closed.");
    }

    // Display menu
    private void menu() {

        System.out.println("\n1. Add Student");
        System.out.println("2. View All Students");
        System.out.println("3. Search Student by ID");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("0. Exit");

        System.out.print("Enter your choice: ");
    }

    // Add student
    private void add() throws SQLException {

        Student student = service.addStudent(
            text("Enter Name: "),
            text("Enter Email: "),
            text("Enter Course: "),
            number("Enter Age: ")
        );

        System.out.println(
            "Student added successfully! ID: " + student.getId()
        );
    }

    // View all students
    private void list() throws SQLException {

        List<Student> students = service.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            students.forEach(System.out::println);
        }
    }

    // Search student
    private void search() throws SQLException {

        int id = number("Enter Student ID: ");

        service.getStudent(id).ifPresentOrElse(
            System.out::println,
            () -> System.out.println("Student not found.")
        );
    }

    // Update student
    private void update() throws SQLException {

        int id = number("Enter Student ID to update: ");

        boolean updated = service.updateStudent(
            id,
            text("Enter New Name: "),
            text("Enter New Email: "),
            text("Enter New Course: "),
            number("Enter New Age: ")
        );

        System.out.println(
            updated ? "Student updated successfully."
                    : "Student not found."
        );
    }

    // Delete student
    private void delete() throws SQLException {

        int id = number("Enter Student ID to delete: ");

        System.out.println(
            service.deleteStudent(id)
                ? "Student deleted successfully."
                : "Student not found."
        );
    }

    // Read text input
    private String text(String label) {

        System.out.print(label);
        return in.nextLine().trim();
    }

    // Read integer input
    private int number(String label) {

        System.out.print(label);

        try {
            return Integer.parseInt(in.nextLine().trim());

        } catch (NumberFormatException e) {

            throw new IllegalArgumentException(
                "Please enter a valid whole number."
            );
        }
    }
}
