package repository;

import model.LesionHistory;
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
public class LesionHistoryDTO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addNewLesionHistory( LesionHistory lesionHistory){
        sessionFactory.getCurrentSession().save(lesionHistory);
    }

    public List<LesionHistory> getAllLesionsHistory(int page, int size) {
        Query query = sessionFactory.getCurrentSession().createQuery("from LesionHistory");
        query = setPagination(query, page, size);
        return query.list();
    }

    public LesionHistory getLesionHistoryByID(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from LesionHistory where id = :id");
        query.setInteger("id", id);
        return (LesionHistory) query.uniqueResult();
    }

    public Query setPagination(Query query, int page, int size){

        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query;
    }
}
