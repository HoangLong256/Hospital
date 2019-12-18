package controller;

import service.PrescribedDrugService;
import model.PrescribedDrug;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by CoT on 7/29/18.
 */
@RestController
@CrossOrigin
@RequestMapping(path = "/")
public class PrescribedDrugController {

    @Autowired
    private PrescribedDrugService prescribedDrugService;

    @RequestMapping(path = "prescribedDrug", method = RequestMethod.GET)
    public List<PrescribedDrug> getAllDrugs(@RequestParam(defaultValue = "1")int page,
                                            @RequestParam(defaultValue = "100")int size){
        return prescribedDrugService.getAllPrescribedDrug(page, size);
    }

    @RequestMapping(path = "prescribedDrug/searchByID/{id}", method = RequestMethod.GET)
    public PrescribedDrug searchByID(@PathVariable int id) {
        return prescribedDrugService.getPrescribedDrugByID(id);
    }

//    @RequestMapping(path = "prescribedDrug", method = RequestMethod.POST)
//    public void addNewDrug(@RequestBody PrescribedDrug prescribedDrug){
//        prescribedDrugService.addPrescribedDrug(prescribedDrug);
//    }

    @RequestMapping(path = "prescribedDrug/update/{id}", method = RequestMethod.PUT)
    public void updatePrescribedDrug(@RequestBody PrescribedDrug drug, @PathVariable int id) {
        prescribedDrugService.updatePrescribedDrug(drug, id);
    }

}


