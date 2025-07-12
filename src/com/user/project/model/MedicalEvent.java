package com.user.project.model;

public abstract class MedicalEvent {
    protected int month;
    protected int year;
    protected String medicalDepartment;

    public MedicalEvent(int month, int year, String medicalDepartment) {
        this.month = month;
        this.year = year;
        this.medicalDepartment = medicalDepartment;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getMedicalDepartment() {
        return medicalDepartment;
    }

    public abstract String getType(); //used for identification

    @Override
    public String toString() {
        return year + " " + String.format("%02d", month) + ", Department: " + medicalDepartment;
    }
}