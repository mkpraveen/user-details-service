package org.praveenmk.microservice.learn.userdetails.service;

import org.praveenmk.microservice.learn.userdetails.model.UserDetails;
import org.praveenmk.microservice.learn.userdetails.repository.UserDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userDetailsService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDetailsRepository userRepository;

    @Override
    public List<UserDetails> getAllUserDetails() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails getUserDetailsById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public UserDetails saveUserDetails(UserDetails userDetails) {
        return userRepository.save(userDetails);
    }

    @Override
    public void deleteUserDetails(UserDetails userDetails) {
        userRepository.delete(userDetails);

    }
}
