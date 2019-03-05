package org.praveenmk.microservice.learn.userdetails.controller;

import org.praveenmk.microservice.learn.userdetails.exception.UserServiceException;
import org.praveenmk.microservice.learn.userdetails.model.ServiceResponse;
import org.praveenmk.microservice.learn.userdetails.model.UserDetails;
import org.praveenmk.microservice.learn.userdetails.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public UserDetails getUserDetailsById(@PathVariable(value = "userId") long id) throws Exception{
        if (null != userDetailsService.getUserDetailsById(id)) {
            return userDetailsService.getUserDetailsById(id);
        } else {
            throw new UserServiceException("User Details not found for ID : " + id);
        }
    }

    @RequestMapping(value = "/jpausers/save", method = RequestMethod.POST)
    public UserDetails saveUserDetails(@RequestBody UserDetails userDetails) throws Exception {
        UserDetails newUser = userDetailsService.saveUserDetails(userDetails);
        if(null != newUser) {
            return newUser;
        } else {
            throw new UserServiceException("User Details not found for ID : " + newUser.getUserId());
        }
    }

    @RequestMapping(value = "/jpausers/update", method = RequestMethod.PATCH)
    public UserDetails updateUserDetails(@RequestBody UserDetails userDetails) throws Exception {
        UserDetails newUser = userDetailsService.getUserDetailsById(userDetails.getUserId());
        if(null != newUser && newUser.getUserId() > 0) {
            return userDetailsService.saveUserDetails(userDetails);
        } else {
            throw new UserServiceException("User Details not found for ID : " + newUser.getUserId());
        }
    }

    @RequestMapping(value = "/jpausers/delete/{userId}")
    public ServiceResponse deleteUserDetails(@PathVariable(value = "userId") long userId) throws  Exception{
        UserDetails deleteUser = userDetailsService.getUserDetailsById(userId);
        if(null != deleteUser && deleteUser.getUserId() > 0) {
            userDetailsService.deleteUserDetails(deleteUser);
            return new ServiceResponse(deleteUser.getUserId(),
                    "Successfully deleted User with User ID :" + deleteUser.getUserId());
        } else {
            throw new UserServiceException("User Details not found for ID : " + userId);
        }
    }
}
