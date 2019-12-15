package service;

import model.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DrugDTO;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class DrugService {

    @Autowired
    DrugDTO drugDTO;

    public void addNewDrug(Drug newDrug) {
        drugDTO.addNewDrug(newDrug);
    }

    public List<Drug> getAllDrugs(int page, int size) {
        return drugDTO.getAllDrugs(page,size);

    }

    public void updateDrug(Drug drug, int id){
        drugDTO.updateDrug(drug,id);
    }

    public Drug getDrugByID(int id){
        return drugDTO.getDrugByID(id);
    }

    public List<Drug> getDrugByName(String name, int page, int size){
        return drugDTO.getDrugByName(name, page, size);
    }

    public void deleteDrug(int id) {
        drugDTO.deleteDrug(id);
    }


}
