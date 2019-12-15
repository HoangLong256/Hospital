package controller;

import service.PatientService;
import model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by CoT on 7/29/18.
 */
@RestController
@CrossOrigin
@RequestMapping(path = "/")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping(path = "patients", method = RequestMethod.GET)
    public List<Patient> getAllPatients(@RequestParam(defaultValue = "1")int page,
                                        @RequestParam(defaultValue = "100")int size){
        return patientService.getAllPatients(page, size);
    }

    @RequestMapping(path = "patients", method = RequestMethod.POST)
    public void addNewPatient(@RequestBody Patient patient){
        patientService.addNewPatient(patient);
    }

    @RequestMapping(path="patients/delete/{id}", method = RequestMethod.DELETE)
    public void deletePatient(@PathVariable int id){
        patientService.deletePatient(id);
    }

    @RequestMapping(path="patients/update/{id}", method = RequestMethod.PUT)
    public void updatePatient(@RequestBody Patient patient, @PathVariable int id) {
        patientService.updatePatient(patient, id);
    }

    @RequestMapping(path = "patients/searchByID/{id}", method = RequestMethod.GET)
    public Patient searchByID(@PathVariable int id) {
        return patientService.getPatientByID(id);
    }

    @RequestMapping(path = "patients/searchByLastName/{lastName}", method = RequestMethod.GET)
    public List<Patient> searchByLastName(@PathVariable String lastName,
                                      @RequestParam(defaultValue = "1")int page,
                                      @RequestParam(defaultValue = "100")int size){
        return patientService.getPatientsByLastName(lastName,page,size);
    }

//    @RequestMapping(path = "patients/searchByBirthday/{birthday}", method = RequestMethod.GET)
//    public List<Patient> searchByBirthday(@PathVariable String birthday,
//                                          @RequestParam(defaultValue = "1")int page,
//                                          @RequestParam(defaultValue = "100")int size) {
//        return patientService.getPatientsByBirthday(birthday,page,size);
//    }

}


