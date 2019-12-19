package repository;

import model.Lesion;
import model.Patient;
import model.VisitLog;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by CoT on 10/14/17.
 */
@Transactional
@Repository
public class LesionDTO   {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addNewLesion( Lesion lesion){
        int visitID = lesion.getVisitLog().getId();
        if(visitID  != 0){
            VisitLog visitLog = findVisitLogByID(visitID);
            lesion.setVisitLog(visitLog);
        }

        int patientID = lesion.getPatient().getId();
        if(patientID  != 0){
            Patient patient = getPatientByID(patientID);
            lesion.setPatient(patient);
        }
        sessionFactory.getCurrentSession().save(lesion);
    }

//    public void deleteDrug(int id) {
//        Query query = sessionFactory.getCurrentSession().createQuery("from Drug where id = :id");
//        query.setInteger("id", id);
//        Drug drug = (Drug) query.uniqueResult();
//        sessionFactory.getCurrentSession().delete(drug);
//    }

    public void updateLesion(Lesion lesion, int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Lesion where id = :id");
        query.setInteger("id", id);
        Lesion updatedLesion = (Lesion) query.uniqueResult();
        updatedLesion.setDate(lesion.getDate());
        updatedLesion.setSize(lesion.getSize());
        updatedLesion.setTime(lesion.getTime());
        updatedLesion.setLocation(lesion.getLocation());
        updatedLesion.setPatient(getPatientByID(lesion.getPatient().getId()));
        updatedLesion.setStatus(lesion.getStatus());
        sessionFactory.getCurrentSession().update(updatedLesion);
    }

    public List<Lesion> getAllLesion(int page, int size) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Lesion order by id asc");
        query = setPagination(query, page,size);
        return query.list();
    }

    public Lesion getLesionByID(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Lesion where id = :id");
        query.setInteger("id", id);
        return (Lesion) query.uniqueResult();
    }
//
//    public List<Drug> getDrugByName(String name, int page, int size) {
//        Query query = sessionFactory.getCurrentSession().createQuery("from Drug where lower(name) like lower(:name)");
//        query.setString("name", "%"+name+"%");
//        query = setPagination(query,page,size);
//        return query.list();
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

    public Patient getPatientByID(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Patient where id = :id");
        query.setInteger("id", id);
        return (Patient) query.uniqueResult();
    }
}
