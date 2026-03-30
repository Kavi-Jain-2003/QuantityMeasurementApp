package com.apps.quantitymeasurement.auth;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<?> login(@RequestBody User user) {

	    System.out.println("LOGIN HIT: " + user.getUsername());

	    try {
	        Authentication authentication = authManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        user.getUsername(),
	                        user.getPassword()
	                )
	        );

	        String token = jwtUtil.generateToken(user.getUsername());

	        return ResponseEntity.ok(
	                Map.of(
	                        "status", 200,
	                        "token", token
	                )
	        );

	    } catch (BadCredentialsException e) {

	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
	                Map.of(
	                        "status", 401,
	                        "message", "Invalid username or password"
	                )
	        );
	    }
	}

	@PostMapping("/register")
	public String register(@RequestBody User user) {

	    // check if user already exists
	    if (userRepository.existsByUsername(user.getUsername())) {
	        return "User already exists";
	    }

	    // save user
	    userRepository.save(user);
	    return "user registered successfully";
	}

	  @GetMapping("/secure")
	    public String secure() {
	        return "This is secured API ";
	        }
	 
}
