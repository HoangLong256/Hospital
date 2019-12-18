package controller;

import service.PrescriptionService;
import model.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by CoT on 7/29/18.
 */
@RestController
@CrossOrigin
@RequestMapping(path = "/")
public class PrescriptionController {

    @Autowired
    private PrescriptionService prescriptionService;

    @RequestMapping(path = "prescription", method = RequestMethod.GET)
    public List<Prescription> getAllPrescription(@RequestParam(defaultValue = "1")int page,
                                                 @RequestParam(defaultValue = "100")int size){
        return prescriptionService.getAllPrescription(page,size);
    }

    @RequestMapping(path = "prescription", method = RequestMethod.POST)
    public void addPrescription(@RequestBody Prescription prescription){
        prescriptionService.addPrescription(prescription);
    }

    @RequestMapping(path = "prescription/searchByID/{id}", method = RequestMethod.GET)
    public Prescription searchByID(@PathVariable int id) {
        return prescriptionService.getPrescriptionByID(id);
    }

    @RequestMapping(path = "prescription/searchByPatientID/{id}", method = RequestMethod.GET)
    public List<Prescription> searchByPatientID(@PathVariable int id,
                                                @RequestParam(defaultValue = "1")int page,
                                                @RequestParam(defaultValue = "100")int size) {
        return prescriptionService.getPrescriptionByPatientID(id,page,size);
    }

//    @RequestMapping(path = "prescription/delete/{id}", method = RequestMethod.DELETE)
//    public void deletePrescription(@PathVariable int id) {
//        prescriptionService.deletePrescription(id);
//    }


}


