package service;

import model.LesionHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.LesionHistoryDTO;
import repository.PrescribedDrugDTO;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class LesionHistoryService {
    @Autowired
    LesionHistoryDTO lesionHistoryDTO;
    public List<LesionHistory> getAllLesionsHistory(int page, int size){
        return lesionHistoryDTO.getAllLesionsHistory(page, size);
    }
    public LesionHistory getLesionHistoryByID(int id){
        return lesionHistoryDTO.getLesionHistoryByID(id);
    }

    public void addNewLesionHistory (LesionHistory lesionHistory){ lesionHistoryDTO.addNewLesionHistory(lesionHistory);}
}
