package service;

import model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PatientDTO;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PatientService {
    @Autowired
    PatientDTO patientDTO;

    public void addNewPatient( Patient newPatient){
        patientDTO.addNewPatient(newPatient);
    }
    public void updatePatient(Patient patient, int id){
        patientDTO.updatePatient(patient, id);
    }
    public List<Patient> getAllPatients(int page, int size){
        return patientDTO.getAllPatients(page,size);
    }
    public Patient getPatientByID(int id){
        return patientDTO.getPatientByID(id);
    }
    public List<Patient> getPatientsByLastName(String lastName, int page, int size){
        return patientDTO.getPatientsByLastName(lastName, page, size);
    }
    public void deletePatient(int id){patientDTO.deletePatient(id);}

//    public List<Patient> getPatientsByBirthday(String birthday, int page, int size){
//        return patientDTO.getPatientsByBirthday(birthday, page, size);
//    }
}
