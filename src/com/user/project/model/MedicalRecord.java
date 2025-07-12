package com.user.project.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedicalRecord {
    private String patientName;
    private int numberOfComorbidities;
    private List<MedicalEvent> events;

    public MedicalRecord(String patientName, int numberOfComorbidities) {
        this.patientName = patientName;
        this.numberOfComorbidities = numberOfComorbidities;
        this.events = new ArrayList<>();
    }

    public void addEvent(MedicalEvent event) {
        events.add(event);
    }

    public void addNewEventInteractive() {
        Scanner scanner = new Scanner(System.in);
        String continueChoice;

        do {
            System.out.println("\n--- Add new event ---");
            System.out.println("Event Type:");
            System.out.println("1. Consultation");
            System.out.println("2. Hospitalization");
            System.out.print("Choose Option: ");
            int option = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Month: ");
            int month = scanner.nextInt();

            System.out.print("Year: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Medical Department: ");
            String department = scanner.nextLine();

            if (option == 1) {
                System.out.print("Diagnosis (Sick/Healthy): ");
                String diagnosis = scanner.nextLine();
                events.add(new Consultation(month, year, department, diagnosis));
            } else if (option == 2) {
                System.out.print("Number of Hospitalization days: ");
                int days = scanner.nextInt();
                scanner.nextLine();
                events.add(new Hospitalization(month, year, department, days));
            } else {
                System.out.println("Invalid Option.");
            }

            System.out.print("Do you want to add another event? (Y/N): ");
            continueChoice = scanner.nextLine();
        }while(continueChoice.equals("Y"));
    }

    public List<MedicalEvent> getEvents() {
        return events;
    }

    public String getPatientName() {
        return patientName;
    }

    public int getNumberOfComorbidities() {
        return numberOfComorbidities;
    }

    public void readFromInput(Scanner scanner) {
        System.out.print("Patient name: ");
        this.patientName = scanner.nextLine();

        System.out.print("Number of comorbidities: ");
        this.numberOfComorbidities = scanner.nextInt();

        System.out.print("Number of medical events: ");
        int numEvents = scanner.nextInt();

        for(int i = 0; i < numEvents; i++) {
            System.out.println("Event #" + (i + 1));
            System.out.print("Event Type (1 = Consultation, 2 = Hospitalization): ");
            int type = scanner.nextInt();

            System.out.print("Month: ");
            int month = scanner.nextInt();

            System.out.print("Year: ");
            int year = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Medical Department: ");
            String medicalDepartment = scanner.nextLine();

            if (type == 1) {
                System.out.print("Diagnosis (Sick/Healthy): ");
                String diagnosis = scanner.nextLine();
                events.add(new Consultation(month, year, medicalDepartment, diagnosis));
            } else if (type == 2) {
                System.out.print("Number of Hospitalization days: ");
                int numberOfDays = scanner.nextInt();
                events.add(new Hospitalization(month, year, medicalDepartment, numberOfDays));
            } else {
                System.out.print("Invalid Type");
            }
        }
    }

    public void displayRecord() {
        System.out.println("=== Medical file for " + patientName + " ===");
        System.out.println("Comorbidities: " + numberOfComorbidities);
        for (MedicalEvent event : events) {
            System.out.println(event);
        }
    }

    public void displayStatisticsForYear(int year) {
        int consultations = 0;
        int totalHospitalizationDays = 0;

        for (MedicalEvent event : events) {
            if(event.getYear() == year) {
                if(event instanceof Consultation) {
                    consultations++;
                } else if (event instanceof Hospitalization) {
                    Hospitalization h = (Hospitalization) event;
                    totalHospitalizationDays += h.getNumberOfDays();
                }
            }
        }
        System.out.println("\nStatistics for year " + year + ":");
        System.out.println("Number of consultations: " + consultations);
        System.out.println("Total days of hospitalization: " + totalHospitalizationDays);
    }

    public int calculateLaceScore() {
        int lengthOfStay = 0;
        int acuity = 0;

        for (MedicalEvent event : events) {
            if (event instanceof Hospitalization) {
                Hospitalization h = (Hospitalization) event;
                lengthOfStay += h.getNumberOfDays();
                acuity = 3;
            }
        }

        int comorbiditiesScore = numberOfComorbidities;
        int emergencyVisits = 0;

        int laceScore = lengthOfStay + acuity + comorbiditiesScore + emergencyVisits;

        System.out.println("\nLACE Score: " + laceScore);
        return laceScore;
    }

}