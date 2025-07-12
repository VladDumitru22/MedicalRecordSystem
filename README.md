# Medical Record Management System

## Description

This is a Java project for managing patients' medical records, created to learn object-oriented programming (OOP) concepts, real-world project structure, and industry best practices.

The application allows creating and managing medical records with events such as consultations and hospitalizations, as well as calculating relevant statistics (e.g., the LACE score). The project is developed using IntelliJ IDEA.

---

## Features implemented so far
- Abstract class `MedicalEvent` with common attributes (month, year, medical department)
- Derived classes `Consultation` (with diagnosis: Sick / Healthy) and `Hospitalization` (with number of days hospitalized)
- `MedicalRecord` class containing:
  - Patient name
  - Number of comorbidities
  - List of medical events
- Reading all data from keyboard input
- Displaying the full medical record with all events
- Calculating statistics for consultations and hospitalization days by year
- Calculating the LACE score
- Sorting hospitalizations in descending order by the number of days

---

## Object-Oriented Programming (OOP) Principles Used

This project applies key OOP principles to design a clean, maintainable, and extensible system:

### 1. Encapsulation

- Each class (e.g., `MedicalEvent`, `Consultation`, `Hospitalization`, `MedicalRecord`) hides its internal data (private fields) and exposes public methods (getters/setters) to access and modify that data.
- This protects the internal state and enforces controlled access to attributes.

### 2. Inheritance

- The abstract class `MedicalEvent` serves as a base class for `Consultation` and `Hospitalization`.
- Derived classes inherit common attributes and behaviors, avoiding code duplication.
- This enables treating all medical events uniformly through polymorphic references.

### 3. Polymorphism

- Polymorphism allows using a list of `MedicalEvent` references that can point to different subclasses (`Consultation` or `Hospitalization`).


## Planned features (next steps)

### Additional features:
- Add, modify, and delete medical events after record creation
- Advanced search in medical records by:
  - Time period (month-year interval)
  - Event type (consultation/hospitalization)
  - Diagnosis (Sick/Healthy)
  - Department name
- Export medical records to `.txt` and `.csv` files

### Advanced features:
- User authentication with roles (doctor, nurse, patient) and role-based permissions
- Audit logging of changes (what, when, by whom)
- Managing multiple patients within a Hospital class
- Interactive CLI menu interface
- GUI interface with JavaFX
- Unit tests with JUnit for key methods

---

