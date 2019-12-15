package controller;

import service.LesionHistoryService;
import model.LesionHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.LesionService;

import java.util.List;

/**
 * Created by CoT on 7/29/18.
 */
@RestController
@CrossOrigin
@RequestMapping(path = "/")
public class LesionHistoryController {

    @Autowired
    private LesionHistoryService lesionHistoryService;

    @RequestMapping(path = "lesionHistory", method = RequestMethod.GET)
    public List<LesionHistory> getAllLesionHistory(@RequestParam(defaultValue = "1")int page,
                                  @RequestParam(defaultValue = "100")int size){
        return lesionHistoryService.getAllLesionsHistory(page,size);
    }

    @RequestMapping(path = "lesionHistory", method = RequestMethod.POST)
    public void addNewLesionHistory(@RequestBody LesionHistory lesionHistory){
        lesionHistoryService.addNewLesionHistory(lesionHistory);
    }

    @RequestMapping(path = "lesionHistory/searchByID/{id}", method = RequestMethod.GET)
    public LesionHistory searchByID(@PathVariable int id) {
        return lesionHistoryService.getLesionHistoryByID(id);
    }

}


