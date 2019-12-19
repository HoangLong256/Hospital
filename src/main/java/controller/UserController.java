package controller;

import model.Employee;
import service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by CoT on 7/29/18.
 */
@RestController
@CrossOrigin
@RequestMapping(path = "/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(path = "users", method = RequestMethod.POST)
    public void addUser(@RequestBody Employee employee){
        userService.addNewUser(employee);
    }

    @RequestMapping(path = "users/login", method = RequestMethod.GET)
    public Employee login(@RequestParam String username,
                          @RequestParam String password) {
        return userService.getUser(username, password);
    }

    @RequestMapping(path = "users/advancedLogin", method = RequestMethod.GET)
    public Employee advancedLogin (@RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam String server){
        return userService.advancedLogin(username,password,server);
    }



}


