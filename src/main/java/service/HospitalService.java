package service;

import model.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.HospitalDTO;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class HospitalService {

    @Autowired
    HospitalDTO hospitalDTO;

    public void addNewHospital(Hospital hospital) {
        hospitalDTO.addNewHospital(hospital);
    }

    public List<Hospital> getAllHospital(int page, int size) {
        return hospitalDTO.getAllHospital(page,size);

    }

    public Hospital getHospitalByID(int id){
        return hospitalDTO.getHospitalByID(id);
    }

    public List<Hospital> getHospitalByCountry(String country, int page, int size){
        return hospitalDTO.getHospitalByCountry(country, page, size);
    }

    public List<Hospital> getHospitalByCity(String city, int page, int size){
        return hospitalDTO.getHospitalByCity(city, page, size);
    }

    public void deleteHospital(int id) {
        hospitalDTO.deleteHospital(id);
    }

    public void getByName(String name){ hospitalDTO.getHospitalByName( name);}
}
