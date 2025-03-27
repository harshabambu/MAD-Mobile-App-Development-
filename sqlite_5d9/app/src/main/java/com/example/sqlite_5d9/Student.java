package com.example.sqlite_5d9;

public class Student {
    private int rollno;
    private String name;
    private float avg;
    private String grade;

    public Student(int rollno, String name, float avg, String grade) {
        this.rollno = rollno;
        this.name = name;
        this.avg = avg;
        this.grade = grade;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}