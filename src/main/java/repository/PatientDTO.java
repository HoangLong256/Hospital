package repository;

import model.Hospital;
import model.Patient;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Path;
import java.util.List;

/**
 * Created by CoT on 10/14/17.
 */
@Transactional
@Repository
public class PatientDTO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addNewPatient( Patient newPatient){
        int hospitalID = newPatient.getHospital().getId();
        if(hospitalID != 0){
            Hospital hospital = getHospitalByID(hospitalID);
            newPatient.setHospital(hospital);
        }
        sessionFactory.getCurrentSession().save(newPatient);
    }

    public void deletePatient(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Patient where id = :id");
        query.setInteger("id", id);
        Patient patient = (Patient) query.uniqueResult();
        sessionFactory.getCurrentSession().delete(patient);
    }



    public void updatePatient(Patient patient, int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Patient where id = :id");
        query.setInteger("id", id);
        Patient updatedPatient = (Patient) query.uniqueResult();
        updatedPatient.setLastName(patient.getLastName());
        updatedPatient.setFirstName(patient.getFirstName());
        updatedPatient.setGender(patient.getGender());
        updatedPatient.setStreetAddress(patient.getStreetAddress());
        updatedPatient.setMaritalStatus(patient.getMaritalStatus());
        updatedPatient.setSuburb(patient.getSuburb());
        updatedPatient.setCountry(patient.getCountry());
        updatedPatient.setHomePhone(patient.getHomePhone());
        updatedPatient.setBirthday(patient.getBirthday());
        updatedPatient.setTitle(patient.getTitle());
        updatedPatient.setHomePhone(patient.getHomePhone());
        updatedPatient.setMobilePhone(patient.getMobilePhone());
        updatedPatient.setOfficePhone(patient.getOfficePhone());
        updatedPatient.setFaxNumber(patient.getFaxNumber());
        updatedPatient.setContactNumber(patient.getContactNumber());
        updatedPatient.setPostCode(patient.getPostCode());
        updatedPatient.setOccupation(patient.getOccupation());
        updatedPatient.setNextToKin(patient.getNextToKin());
        sessionFactory.getCurrentSession().update(updatedPatient);
    }

    public List<Patient> getAllPatients(int page, int size){
        Query query = sessionFactory.getCurrentSession().createQuery("from Patient order by id asc");
        query = setPagination(query, page, size);
        return query.list();
    }

    public List<Patient> getPatientsByHospitalID(int page, int size, int hospitalID){
        Query query = sessionFactory.getCurrentSession().createQuery("from Patient where hospital.id = :hospitalID");
        query.setInteger("hospitalID",hospitalID);
        return query.list();
    }
    public Patient getPatientByID(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Patient where id = :id");
        query.setInteger("id", id);
        return (Patient) query.uniqueResult();
    }

    public List<Patient> getPatientsByLastName(String lastName, int page, int size) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Patient where lower(lastName) like lower(:lastName)");
        query.setString("lastName", "%"+lastName+"%");
        query = setPagination(query, page, size);
        return query.list();
    }

//    public List<Patient> getPatientsByBirthday(String birthday, int page, int size) {
//        Query query = sessionFactory.getCurrentSession().createQuery("from Patient where cast(birthday as date) = cast(:birthday as date)");
//        query.setString("birthday", birthday);
//        query = setPagination(query, page, size);
//        return query.list();
//    }

    public Query setPagination(Query query, int page, int size){
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query;
    }

    public Hospital getHospitalByID(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Hospital where id = :id");
        query.setInteger("id", id);
        return (Hospital) query.uniqueResult();
    }

}
