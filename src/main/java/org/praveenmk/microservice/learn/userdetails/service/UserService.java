package org.praveenmk.microservice.learn.userdetails.service;

import org.praveenmk.microservice.learn.userdetails.model.UserDetails;

import java.util.List;

public interface UserService {

    List<UserDetails> getAllUserDetails();
    UserDetails getUserDetailsById(long id);
    UserDetails saveUserDetails(UserDetails userDetails);
    void deleteUserDetails(UserDetails userDetails);
}
