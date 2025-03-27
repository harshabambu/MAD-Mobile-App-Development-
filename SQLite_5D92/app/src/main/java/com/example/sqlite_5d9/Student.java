package com.example.sqlite_5d9;
public class Student {
    private String roll;
    private String name;
    private String avg;
    private String grade;

    public Student(String roll, String name, String avg, String grade) {
        this.roll = roll;
        this.name = name;
        this.avg = avg;
        this.grade = grade;
    }

    // Getters and Setters
    public String getRoll() { return roll; }
    public void setRoll(String roll) { this.roll = roll; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAvg() { return avg; }
    public void setAvg(String avg) { this.avg = avg; }
    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}
