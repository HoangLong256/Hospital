package repository;

import model.PrescribedDrug;
import model.Prescription;
import model.VisitLog;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by CoT on 10/14/17.
 */
@Transactional
@Repository
public class PrescriptionDTO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addPrescription( Prescription prescription){

        int visitID = prescription.getVisitLog().getId();
        if(visitID  != 0){
            VisitLog visitLog = findVisitLogByID(visitID);
            prescription.setVisitLog(visitLog);
        }
        for (PrescribedDrug prescribedDrug: prescription.getPrescribedDrugs()){
            prescribedDrug.setPrescription(prescription);
        }
        sessionFactory.getCurrentSession().save(prescription);
    }

    public List<Prescription> getAllPrescription(int page, int size) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Prescription order by id asc");
        query = setPagination(query, page, size);
        return query.list();
    }

    public List<Prescription> getPrescriptionByPatientID(int id, int page, int size){
        Query query = sessionFactory.getCurrentSession().createQuery("from Prescription as p where p.visitLog.patient.id = :id");
        query.setInteger("id", id);
        query = setPagination(query, page, size);
        return query.list();
    }

    public Prescription getPrescriptionByID(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Prescription where id = :id");
        query.setInteger("id", id);
        return (Prescription) query.uniqueResult();
    }

//    public void deletePrescription(int id) {
//        Query query = sessionFactory.getCurrentSession().createQuery("from Prescription  where id = :id");
//        query.setInteger("id", id);
//        Prescription prescription = (Prescription) query.uniqueResult();
//        sessionFactory.getCurrentSession().delete(prescription);
//    }

    public VisitLog findVisitLogByID(int id){
        Query query = sessionFactory.getCurrentSession().createQuery("from VisitLog where id = :visitID");
        query.setInteger("visitID", id);
        return (VisitLog) query.uniqueResult();
    }

    public Query setPagination(Query query, int page, int size){
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query;
    }

}
