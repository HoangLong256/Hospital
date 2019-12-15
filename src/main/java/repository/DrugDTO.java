package repository;

import model.Drug;
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
public class DrugDTO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addNewDrug( Drug newDrug){
        sessionFactory.getCurrentSession().save(newDrug);
    }

    public void deleteDrug(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Drug where id = :id");
        query.setInteger("id", id);
        Drug drug = (Drug) query.uniqueResult();
        sessionFactory.getCurrentSession().delete(drug);
    }

    public void updateDrug(Drug drug, int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Drug where id = :id");
        query.setInteger("id", id);
        Drug updatedDrug = (Drug) query.uniqueResult();
        updatedDrug.setName(drug.getName());
        updatedDrug.setUsage(drug.getUsage());
        sessionFactory.getCurrentSession().update(updatedDrug);
    }

    public List<Drug> getAllDrugs(int page, int size) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Drug order by id asc");
        query = setPagination(query, page,size);
        return query.list();
    }

    public Drug getDrugByID(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Drug where id = :id");
        query.setInteger("id", id);
        return (Drug) query.uniqueResult();
    }

    public List<Drug> getDrugByName(String name, int page, int size) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Drug where lower(name) like lower(:name)");
        query.setString("name", "%"+name+"%");
        query = setPagination(query,page,size);
        return query.list();
    }

    public Query setPagination(Query query, int page, int size){
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query;
    }
}
