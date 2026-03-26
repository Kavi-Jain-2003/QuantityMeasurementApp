package com.apps.quantitymeasurement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apps.quantitymeasurement.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);

}
