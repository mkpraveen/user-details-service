package org.praveenmk.microservice.learn.userdetails.repository;

import org.praveenmk.microservice.learn.userdetails.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("userRepository")
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
}
