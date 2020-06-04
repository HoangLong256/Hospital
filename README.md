# Hospital Management

## Introduction
A web service for hospital management with full CRUD functions 

## Languages:
Java Spring, Hibernate, and SpringMVC 

## Description:
1. Patient management:
- Information of a patient includes id, name, birthdate, gender, address

2. Visit:
- Each time patient comes to the clinic, info of the visit must be logged, including date, time.
- When a patient sees a doctor, he/she will tell his/her problems (fever, headache etc). Often, a patient has more than 1 problem but can be separated by a comma.
- The doctor will also give the patient a prescription. So prescription will link with each visit. One prescription will belong to 1 visit. One visit can have 0, 1, or many prescriptions.
- Information of a prescription includes drug name, quantity, dose (3 tablets per day.... ), how to use (after a meal...)

3. Advanced API:
- API to add a visit for a new patient and API to add visit for a returning patient
- API to find patients by name or id or birthdate
- API to find visits by days, by patient
- API to search drugs
- Pagination
