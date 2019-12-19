package repository;

import model.Employee;
import model.Hospital;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by CoT on 10/14/17.
 */
@Transactional
@Repository
public class UserDTO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addNewUser(Employee newEmployee){
        int hospitalID = newEmployee.getHospital().getId();
        if(hospitalID != 0){
            Hospital hospital = getHospitalByID(hospitalID);
            newEmployee.setHospital(hospital);
        }
        sessionFactory.getCurrentSession().save(newEmployee);

    }

    public Employee getUser(String username, String password) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Employee where lower(username) = lower(:username) and password = :password");
        query.setString("password", password);
        query.setString("username", username);
        return (Employee) query.uniqueResult();
    }

    public Employee advancedLogin(String username, String password, String server ){
        Query query = sessionFactory.getCurrentSession().createQuery("from Employee where lower(username) = lower(:username) and password = : password and lower(server) = lower(:server)");
        query.setString("password", password);
        query.setString("username", username);
        query.setString("server", server);
        return (Employee) query.uniqueResult();
    }

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
