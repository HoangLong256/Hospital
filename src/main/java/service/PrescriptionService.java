package service;

import model.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PrescriptionDTO;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PrescriptionService {
    @Autowired
    PrescriptionDTO prescriptionDTO;

    public void addPrescription( Prescription prescription){
        prescriptionDTO.addPrescription(prescription);
    }

    public List<Prescription> getAllPrescription(int page, int size){
        return prescriptionDTO.getAllPrescription(page, size);
    }

    public List<Prescription> getPrescriptionByPatientID(int id, int page, int size){
        return prescriptionDTO.getPrescriptionByPatientID(id, page, size);
    }
//    public void deletePrescription(int id) {prescriptionDTO.deletePrescription(id);}
    public Prescription getPrescriptionByID(int id){
        return prescriptionDTO.getPrescriptionByID(id);
    }
}
