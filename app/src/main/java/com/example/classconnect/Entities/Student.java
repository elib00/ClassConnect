package com.example.classconnect.Entities;

import android.location.Address;

import java.time.LocalDate;

public class Student {
    private String name;
    private String lrn;
    private String grade;
    private String section;
    private LocalDate birthdate;

    private int age;
    private String gender;
    private String address;
    private String guardian;

    //empty private constructor
    private Student(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLRN() {
        return lrn;
    }

    public void setLRN(String lrn) {
        this.lrn = lrn;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGuardian() {
        return guardian;
    }

    public void setGuardian(String guardian) {
        this.guardian = guardian;
    }

    public static class StudentBuilder {
        private Student student;

        public StudentBuilder() {
            student = new Student();
            student.name = "N/A";
            student.lrn = "N/A";
            student.grade = "N/A";
            student.section = "N/A";
            student.birthdate = LocalDate.now();  // Default to today
            student.age = 0;
            student.gender = "Others";
            student.address = "N/A";
            student.guardian = "N/A";
        }

        public StudentBuilder setStudentName(String name) {
            student.name = name;
            return this;
        }

        public StudentBuilder setLrn(String lrn) {
            student.lrn = lrn;
            return this;
        }

        public StudentBuilder setGrade(String grade) {
            student.grade = grade;
            return this;
        }

        public StudentBuilder setSection(String section) {
            student.section = section;
            return this;
        }

        public StudentBuilder setBirthdate(LocalDate birthdate) {
            student.birthdate = birthdate;
            return this;
        }

        public StudentBuilder setAge(int age){
            student.age = age;
            return this;
        }

        public StudentBuilder setGender(String gender) {
            student.gender = gender;
            return this;
        }

        public StudentBuilder setAddress(String address) {
            student.address = address;
            return this;
        }

        public StudentBuilder setGuardian(String guardian) {
            student.guardian = guardian;
            return this;
        }

        public Student build() {
            return student;
        }
    }
}
