package com.apps.quantitymeasurement.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import com.apps.quantitymeasurement.model.User;
import com.apps.quantitymeasurement.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	@Autowired
	private UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) {

	    System.out.println("LOGIN USERNAME: " + username);   

	    User user = repo.findByUsername(username);

	    if (user == null) {
	        System.out.println("USER NOT FOUND ❌");
	        throw new UsernameNotFoundException("User not found");
	    }

	    System.out.println("DB USERNAME: " + user.getUsername());  
	    System.out.println("DB PASSWORD: " + user.getPassword());  

	    return new org.springframework.security.core.userdetails.User(
	            user.getUsername(),
	            user.getPassword(),
	            List.of(new SimpleGrantedAuthority(user.getRole()))
	    );
	}


}
