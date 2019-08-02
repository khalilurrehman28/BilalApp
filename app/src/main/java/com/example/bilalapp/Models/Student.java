package com.example.bilalapp.Models;

public class Student {

    private Integer rollNumber;
    private Integer sClass;
    private String Name;

    public Integer getRollNumber() {
        return rollNumber;
    }

    public Integer getsClass() {
        return sClass;
    }

    public String getName() {
        return Name;
    }

    public Student(Integer rollNumber, Integer sClass, String name) {
        this.rollNumber = rollNumber;
        this.sClass = sClass;
        Name = name;
    }
}
