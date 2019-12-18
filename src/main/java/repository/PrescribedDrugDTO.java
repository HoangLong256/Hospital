package repository;

import model.PrescribedDrug;
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
public class PrescribedDrugDTO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    public void addPrescribedDrug( PrescribedDrug prescribedDrug){
//        sessionFactory.getCurrentSession().save(prescribedDrug);
//    }

    public List<PrescribedDrug> getAllPrescribedDrug(int page, int size) {
        Query query = sessionFactory.getCurrentSession().createQuery("from PrescribedDrug");
        query = setPagination(query, page, size);
        return query.list();
    }

    public PrescribedDrug getPrescribedDrugByID(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from PrescribedDrug where id = :id");
        query.setInteger("id", id);
        return (PrescribedDrug) query.uniqueResult();
    }

    public void updatePrescribedDrug(PrescribedDrug prescribedDrug, int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from PrescribedDrug where id = :id");
        query.setInteger("id", id);
        PrescribedDrug updatedDrug = (PrescribedDrug) query.uniqueResult();
        updatedDrug.setDose(prescribedDrug.getDose());
        updatedDrug.setInstruction(prescribedDrug.getInstruction());
        updatedDrug.setQuantity(prescribedDrug.getQuantity());
        sessionFactory.getCurrentSession().update(updatedDrug);
    }

    public Query setPagination(Query query, int page, int size){

        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query;
    }


}
