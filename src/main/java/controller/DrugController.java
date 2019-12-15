package controller;

import service.DrugService;
import model.Drug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by CoT on 7/29/18.
 */
@RestController
@CrossOrigin
@RequestMapping(path = "/")
public class DrugController {

    @Autowired
    private DrugService drugService;

    @RequestMapping(path = "drugs", method = RequestMethod.GET)
    public List<Drug> getAllDrugs(@RequestParam(defaultValue = "1")int page,
                                  @RequestParam(defaultValue = "100")int size){
        return drugService.getAllDrugs(page,size);
    }

    @RequestMapping(path = "drugs", method = RequestMethod.POST)
    public void addNewDrug(@RequestBody Drug drug){
        drugService.addNewDrug(drug);
    }

    @RequestMapping(path = "drugs/searchByID/{id}", method = RequestMethod.GET)
    public Drug searchByID(@PathVariable int id) {
        return drugService.getDrugByID(id);
    }

    @RequestMapping(path = "drugs/searchByName", method = RequestMethod.GET)
    public List<Drug> searchByName(@RequestParam String name,
                                   @RequestParam(defaultValue = "1")int page,
                                   @RequestParam(defaultValue = "100")int size) {
        return drugService.getDrugByName(name, page, size);
    }


    @RequestMapping(path = "drugs/delete/{id}", method = RequestMethod.DELETE)
    public void deleteDrug(@PathVariable int id) {
        drugService.deleteDrug(id);
    }

    @RequestMapping(path = "drugs/update/{id}", method = RequestMethod.PUT)
    public void updateDrug(@RequestBody Drug drug, @PathVariable int id) {
        drugService.updateDrug(drug, id);
    }


}


