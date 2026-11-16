package com.deepika.studentmanagement;

public class Student {
    private int id;
    private String name, email, course;
    private int age;

    public Student(int id, String name, String email, String course, int age) {
        this.id = id;
        setName(name);
        setEmail(email);
        setCourse(course);
        setAge(age);
    }

    public Student(String name, String email, String course, int age) {
        this(0, name, email, course, age);
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getCourse() { return course; }
    public int getAge() { return age; }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name is required.");
        this.name = name.trim();
    }

    public void setEmail(String email) {
        if (email == null || !email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$"))
            throw new IllegalArgumentException("Enter a valid email.");
        this.email = email.trim();
    }

    public void setCourse(String course) {
        if (course == null || course.isBlank())
            throw new IllegalArgumentException("Course is required.");
        this.course = course.trim();
    }

    public void setAge(int age) {
        if (age < 1 || age > 120)
            throw new IllegalArgumentException("Age must be between 1 and 120.");
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format(
            "ID: %d | Name: %s | Email: %s | Course: %s | Age: %d",
            id, name, email, course, age
        );
    }
}
