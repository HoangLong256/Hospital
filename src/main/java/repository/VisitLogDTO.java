package repository;

import model.Hospital;
import model.Patient;
import model.VisitLog;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public class VisitLogDTO {

    @Autowired
    private SessionFactory sessionFactory;


    public int addVisitLog(VisitLog visitLog){
        int patientID = visitLog.getPatient().getId();
        if(patientID != 0){
            Patient patient = getPatientByID(patientID);
            visitLog.setPatient(patient);
        }

        int hospitalID = visitLog.getHospital().getId();
        if(hospitalID != 0){
            Hospital hospital = getHospitalByID(hospitalID);
            visitLog.setHospital(hospital);
        }
//        for (VisitHospital visitHospital : visitLog.getVisitHospitals()){
//            visitHospital.setVisitLog(visitLog);
//        }
//        if(visitLog.getLabTests()!=null){
//            for(LabTest labTest: visitLog.getLabTests()){
//                labTest.setVisitLog(visitLog);
//            }
//        }else {
//            System.out.println("Nothing");
//        }
        this.sessionFactory.getCurrentSession().save(visitLog);
        return visitLog.getId();
    }


    public int updatedVisit(VisitLog visitLog, int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from VisitLog where id = :id");
        query.setInteger("id", id);
        VisitLog updatedVisit = (VisitLog) query.uniqueResult();
        if(visitLog.getHospital().getId() != 0){
            updatedVisit.setHospital(getHospitalByID(visitLog.getHospital().getId()));
        }
        if(visitLog.getPatient().getId() != 0){
            updatedVisit.setPatient(getPatientByID(visitLog.getPatient().getId()));
        }
        updatedVisit.setVisitDate(visitLog.getVisitDate());
        updatedVisit.setVisitTime(visitLog.getVisitTime());
        updatedVisit.setDoctor(visitLog.getDoctor());
        updatedVisit.setInformation(visitLog.getInformation());
        sessionFactory.getCurrentSession().update(updatedVisit);
        return updatedVisit.getId();
    }


    public void deleteVisitLog(int visitID) {
        Query query = sessionFactory.getCurrentSession().createQuery("from VisitLog  where id = :visitID");
        query.setInteger("visitID", visitID);
        VisitLog visitLog = (VisitLog) query.uniqueResult();
        sessionFactory.getCurrentSession().delete(visitLog);
    }


    public List<VisitLog> getAllVisitLogs(int page, int size) {
        Query query = sessionFactory.getCurrentSession().createQuery("from VisitLog order by id asc");
        query = setPagination(query, page, size);
        return query.list();
    }

    public List<VisitLog> searchByDate(String visitDate, int page, int size) {
        Query query = sessionFactory.getCurrentSession().createQuery("from VisitLog where cast(visitDate as date) = cast(:visitDate as date)");
        query.setString("visitDate", visitDate);
        query =setPagination(query, page,size);
        return query.list();
    }

    public VisitLog searchByID(int visitID) {
        Query query = sessionFactory.getCurrentSession().createQuery("from VisitLog where id = :visitID");
        query.setInteger("visitID", visitID);
        return (VisitLog) query.uniqueResult();
    }


    public List<VisitLog> searchByPatientID(int patientID, int page, int size) {
        Query query = sessionFactory.getCurrentSession().createQuery("from VisitLog where patient.id = :patientID");
        query.setInteger("patientID", patientID);
        query = setPagination(query,page, size);
        return query.list();
    }

//    public List<VisitLog> searchByDoctor(String doctor, int page, int size) {
//        Query query = sessionFactory.getCurrentSession().createQuery("from VisitLog where lower(doctor) = lower(:doctor)");
//        query.setString("doctor", "%"+doctor+"%");
//        query = setPagination(query, page, size);
//        return query.list();
//    }


    public Patient getPatientByID(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Patient where id = :id");
        query.setInteger("id", id);
        return (Patient) query.uniqueResult();
    }

    public Hospital getHospitalByID(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Hospital where id = :id");
        query.setInteger("id", id);
        return (Hospital) query.uniqueResult();
    }

    public Query setPagination(Query query, int page, int size){
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query;
    }

}
