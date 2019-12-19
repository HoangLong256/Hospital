package repository;

import model.Hospital;
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
public class HospitalDTO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addNewHospital( Hospital hospital){
        sessionFactory.getCurrentSession().save(hospital);
    }

    public void deleteHospital(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Hospital where id = :id");
        query.setInteger("id", id);
        Hospital hospital = (Hospital) query.uniqueResult();
        sessionFactory.getCurrentSession().delete(hospital);
    }

//    public void updateHospi(Hospital hospital, int id) {
//        Query query = sessionFactory.getCurrentSession().createQuery("from Hospital where id = :id");
//        query.setInteger("id", id);
//        Hospital updatedHospital = (Hospital) query.uniqueResult();
//        updatedHospital.setName(hospital.getName());
//        updatedHospital.setCode(hospital.getCode());
//        sessionFactory.getCurrentSession().update(updatedHospital);
//    }

    public List<Hospital> getAllHospital(int page, int size) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Hospital order by id asc");
        query = setPagination(query, page,size);
        return query.list();
    }

    public Hospital getHospitalByID(int id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Hospital where id = :id");
        query.setInteger("id", id);
        return (Hospital) query.uniqueResult();
    }

    public Hospital getHospitalByName (String name){
        Query query = sessionFactory.getCurrentSession().createQuery("from Hospital where name = :name");
        query.setString("name", name);
        return (Hospital) query.uniqueResult();
    }

    public List<Hospital> getHospitalByCountry(String country, int page, int size) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Hospital where lower(country) like lower(:country)");
        query.setString("country", "%"+country+"%");
        query = setPagination(query,page,size);
        return query.list();
    }

    public List<Hospital> getHospitalByCity(String city, int page, int size) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Hospital where lower(city) like lower(:city)");
        query.setString("city", "%"+city+"%");
        query = setPagination(query,page,size);
        return query.list();
    }

    public Query setPagination(Query query, int page, int size){
        query.setFirstResult((page - 1) * size);
        query.setMaxResults(size);
        return query;
    }
}
