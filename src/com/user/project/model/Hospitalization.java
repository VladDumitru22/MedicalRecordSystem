package com.user.project.model;

public class Hospitalization extends MedicalEvent {
    private int numberOfDays;

    public Hospitalization(int month, int year, String medicalDepartment, int numberOfDays) {
        super(month, year, medicalDepartment);
        this.numberOfDays = numberOfDays;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    @Override
    public String getType() {
        return "Hospitalization";
    }

    @Override
    public String toString() {
        return super.toString() + ", Hospitalization Days: " + numberOfDays;
    }
}