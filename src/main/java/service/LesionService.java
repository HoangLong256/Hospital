package service;

import model.Lesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DrugDTO;
import repository.LesionDTO;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class LesionService {

    @Autowired
    LesionDTO lesionDTO;

    public void addNewLesion(Lesion newLesion) {
        lesionDTO.addNewLesion(newLesion);
    }

    public List<Lesion> getAllLesions(int page, int size) {
        return lesionDTO.getAllLesion(page,size);

    }

    public void updateLesion(Lesion lesion, int id){
        lesionDTO.updateLesion(lesion,id);
    }

    public Lesion getLesionByID(int id){
        return lesionDTO.getLesionByID(id);
    }

//
//    public List<Drug> getDrugByName(String name, int page, int size){
//        return drugDTO.getDrugByName(name, page, size);
//    }
//
//    public void deleteDrug(int id) {
//        drugDTO.deleteDrug(id);
//    }


}
