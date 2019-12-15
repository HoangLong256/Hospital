package service;

import model.VisitLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.VisitLogDTO;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class VisitLogService {
    @Autowired
    VisitLogDTO visitLogDTO;

    public int addVisitLog(VisitLog visitLog){
        return visitLogDTO.addVisitLog(visitLog);
    }
    public List<VisitLog> getAllVisitLogs(int page, int size){
        return visitLogDTO.getAllVisitLogs(page, size);
    }
    public List<VisitLog> searchByDate(String visitDate, int page, int size){
        return visitLogDTO.searchByDate(visitDate, page, size);
    }
    public VisitLog searchByID(int visitID){
        return visitLogDTO.searchByID(visitID);
    }
    public List<VisitLog> searchByPatientID(int patientID, int page, int size){
        return visitLogDTO.searchByPatientID(patientID, page, size);
    }

    public void deleteVisitLog(int visitID) {visitLogDTO.deleteVisitLog(visitID);}
}
