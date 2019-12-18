package service;

import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserDTO;

import javax.transaction.Transactional;

@Transactional
@Service
public class UserService {

    @Autowired
    UserDTO userDTO;

    public void addNewUser(Employee employee) {
        userDTO.addNewUser(employee);
    }

    public Employee getUser(String username, String password){
        return userDTO.getUser(username, password);
    }

}
