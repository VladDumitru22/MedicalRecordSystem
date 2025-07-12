package com.user.project;

import com.user.project.model.MedicalRecord;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MedicalRecord record = new MedicalRecord("", 0);
        record.readFromInput(scanner);
        record.displayRecord();

        System.out.print("\nEnter the year you want statistics for: ");
        int year = scanner.nextInt();
        record.displayStatisticsForYear(year);
    }
}