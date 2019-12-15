package service;

import model.PrescribedDrug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PrescribedDrugDTO;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PrescribedDrugService {
    @Autowired
    PrescribedDrugDTO prescribedDrugDTO;
    public List<PrescribedDrug> getAllPrescribedDrug(int page, int size){
        return prescribedDrugDTO.getAllPrescribedDrug(page, size);
    }
    public PrescribedDrug getPrescribedDrugByID(int id){
        return prescribedDrugDTO.getPrescribedDrugByID(id);
    }
    public void updatePrescribedDrug(PrescribedDrug prescribedDrug, int id){
        prescribedDrugDTO.updatePrescribedDrug(prescribedDrug, id);
    }
}
