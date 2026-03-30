package com.apps.quantitymeasurement.auth;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import com.apps.quantitymeasurement.model.User;
import com.apps.quantitymeasurement.repository.UserRepository;
import com.apps.quantitymeasurement.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtUtil jwtUtil;
	@PostMapping("/login")
	public String login(@RequestBody User user) {

	    System.out.println("LOGIN HIT: " + user.getUsername()); 

	    Authentication authentication = authManager.authenticate(
	            new UsernamePasswordAuthenticationToken(
	                    user.getUsername(),
	                    user.getPassword()
	            )
	    );

	    return jwtUtil.generateToken(user.getUsername());
	}
	@PostMapping("/register")
	public String register(@RequestBody User user) {

	    // check if user already exists
	    if (userRepository.existsByUsername(user.getUsername())) {
	        return "User already exists";
	    }

	    // save user
	    userRepository.save(user);

	    // generate token (optional but recommended)
	    return jwtUtil.generateToken(user.getUsername());
	}

	  @GetMapping("/secure")
	    public String secure() {
	        return "This is secured API ";
	        }
	 
}
