package controller;

import service.LesionService;
import model.Lesion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by CoT on 7/29/18.
 */
@RestController
@CrossOrigin
@RequestMapping(path = "/")
public class LesionController {

    @Autowired
    private LesionService lesionService;

    @RequestMapping(path = "lesions", method = RequestMethod.GET)
    public List<Lesion> getAllLesion(@RequestParam(defaultValue = "1")int page,
                                  @RequestParam(defaultValue = "100")int size){
        return lesionService.getAllLesions(page,size);
    }

    @RequestMapping(path = "lesions", method = RequestMethod.POST)
    public void addNewLesion(@RequestBody Lesion lesion){
        lesionService.addNewLesion(lesion);
    }

    @RequestMapping(path = "lesions/searchByID/{id}", method = RequestMethod.GET)
    public Lesion searchByID(@PathVariable int id) {
        return lesionService.getLesionByID(id);
    }

//    @RequestMapping(path = "drugs/searchByName", method = RequestMethod.GET)
//    public List<Drug> searchByName(@RequestParam String name,
//                                   @RequestParam(defaultValue = "1")int page,
//                                   @RequestParam(defaultValue = "100")int size) {
//        return drugService.getDrugByName(name, page, size);
//    }
//
//
//    @RequestMapping(path = "drugs/delete/{id}", method = RequestMethod.DELETE)
//    public void deleteDrug(@PathVariable int id) {
//        drugService.deleteDrug(id);
//    }

    @RequestMapping(path = "lesions/update/{id}", method = RequestMethod.PUT)
    public void updateLesion(@RequestBody Lesion lesion, @PathVariable int id) {
        lesionService.updateLesion(lesion, id);
    }


}


