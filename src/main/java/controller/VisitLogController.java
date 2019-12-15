package controller;

import service.VisitLogService;
import model.VisitLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/")
public class VisitLogController {

    @Autowired
    private VisitLogService visitLogService;

    @RequestMapping(path = "/visits", method = RequestMethod.POST)
    public int addVisitLog(@RequestBody VisitLog visitLog){
        return visitLogService.addVisitLog(visitLog);

    }

    @RequestMapping(path = "/visits", method = RequestMethod.GET)
    public List<VisitLog> getAllVisitLogs(@RequestParam(defaultValue = "1")int page,
                                          @RequestParam(defaultValue = "100")int size){
        return visitLogService.getAllVisitLogs(page,size);
    }

    @RequestMapping(path = "visits/searchByID/{id}", method = RequestMethod.GET)
    public VisitLog searchByID(@PathVariable int id) {
        return visitLogService.searchByID(id);
    }

    @RequestMapping(path = "visits/searchByDate/{date}", method = RequestMethod.GET)
    public List<VisitLog> searchByDate(@PathVariable String date,
                                       @RequestParam(defaultValue = "1")int page,
                                       @RequestParam(defaultValue = "100")int size){
        return visitLogService.searchByDate(date,page,size);
    }

    @RequestMapping(path = "visits/searchByPatientID/{id}", method = RequestMethod.GET)
    public List<VisitLog> searchByPatientID(@PathVariable int id,
                                            @RequestParam(defaultValue = "1")int page,
                                            @RequestParam(defaultValue = "100")int size){
        return visitLogService.searchByPatientID(id,page,size);
    }

//    @RequestMapping(path = "visits/searchByDoctor/{doctor}", method = RequestMethod.GET)
//    public List<VisitLog> searchByDoctor(@PathVariable String doctor,
//                                         @RequestParam(defaultValue = "1")int page,
//                                         @RequestParam(defaultValue = "100")int size){
//        return visitLogService.searchByDoctor(doctor, page,size);
//    }

    @RequestMapping(path = "visits/delete/{id}", method = RequestMethod.DELETE)
    public void deleteVisitLog(@PathVariable int id) {
        visitLogService.deleteVisitLog(id);
    }



}
