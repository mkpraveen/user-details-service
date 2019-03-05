package org.praveenmk.microservice.learn.userdetails.controller;

import org.praveenmk.microservice.learn.userdetails.model.UserDetails;
import org.praveenmk.microservice.learn.userdetails.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserDetailsController {

    @Autowired
    private UserServiceImpl userDetailsService;

    @RequestMapping(value = "/jpausers", method = RequestMethod.GET)
    public List<UserDetails> getAllUserDetails() {
        return userDetailsService.getAllUserDetails();
    }

    @RequestMapping(value = "/jpausers/{userId}", method = RequestMethod.GET)
    public UserDetails getUserDetailsById(@PathVariable(value = "userId") long id) {
        return userDetailsService.getUserDetailsById(id);
    }


}
