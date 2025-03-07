package com.example.firebase_5d9;

public class Student {
    private String roll,name,avg,grade;

    public Student(String roll,String name,String avg,String grade){
        this.roll=roll;
        this.name=name;
        this.avg=avg;
        this.grade=grade;
    }
    public String getRoll(){
        return roll;
    }
    public String getName(){
        return name;
    }
    public String getAvg(){
        return avg;
    }
    public String getGrade(){
        return grade;
    }
}

