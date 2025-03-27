package com.example.firebase_5d9;

public class Student {
    private String roll, name, avg, grade;

    // Added default constructor required by Firebase
    public Student() {}

    public Student(String roll, String name, String avg, String grade) {
        this.roll = roll;
        this.name = name;
        this.avg = avg;
        this.grade = grade;
    }

    public String getRoll() { return roll; }
    public String getName() { return name; }
    public String getAvg() { return avg; }
    public String getGrade() { return grade; }

    // Added setters for updating
    public void setRoll(String roll) { this.roll = roll; }
    public void setName(String name) { this.name = name; }
    public void setAvg(String avg) { this.avg = avg; }
    public void setGrade(String grade) { this.grade = grade; }
}