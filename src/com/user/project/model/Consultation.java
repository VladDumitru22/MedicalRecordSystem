package com.user.project.model;

public class Consultation extends MedicalEvent {
    private String diagnosis; //expected: "Sick" or "Healthy"

    public Consultation(int month, int year, String medicalDepartment, String diagnosis) {
        super(month, year, medicalDepartment);
        this.diagnosis = diagnosis;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    @Override
    public String getType() {
        return "Consultation";
    }

    @Override
    public String toString() {
        return super.toString() + ", Diagnosis: " + diagnosis;
    }

}