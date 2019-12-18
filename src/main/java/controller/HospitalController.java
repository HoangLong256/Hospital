package controller;

import model.Hospital;
import service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by CoT on 7/29/18.
 */
@RestController
@CrossOrigin
@RequestMapping(path = "/")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @RequestMapping(path = "hospitals", method = RequestMethod.GET)
    public List<Hospital> getAllHospitals(@RequestParam(defaultValue = "1")int page,
                                         @RequestParam(defaultValue = "100")int size){
        return hospitalService.getAllHospital(page,size);
    }

    @RequestMapping(path = "hospitals", method = RequestMethod.POST)
    public void addNewHospital(@RequestBody Hospital hospital){
        hospitalService.addNewHospital(hospital);
    }

    @RequestMapping(path = "hospitals/searchByID/{id}", method = RequestMethod.GET)
    public Hospital searchByID(@PathVariable int id) {
        return hospitalService.getHospitalByID(id);
    }

    @RequestMapping(path = "hospitals/searchByCountry/{country}", method = RequestMethod.GET)
    public List<Hospital> searchByCountry(@PathVariable String country,
                                       @RequestParam(defaultValue = "1")int page,
                                       @RequestParam(defaultValue = "100")int size) {
        return hospitalService.getHospitalByCountry(country, page, size);
    }

    @RequestMapping(path = "hospitals/searchByCity/{city}", method = RequestMethod.GET)
    public List<Hospital> searchByCity(@PathVariable String city,
                                          @RequestParam(defaultValue = "1")int page,
                                          @RequestParam(defaultValue = "100")int size) {
        return hospitalService.getHospitalByCity(city, page, size);
    }


    @RequestMapping(path = "hospitals/delete/{id}", method = RequestMethod.DELETE)
    public void deleteDisease(@PathVariable int id) {
        hospitalService.deleteHospital(id);
    }




}


