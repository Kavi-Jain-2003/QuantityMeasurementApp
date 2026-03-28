package com.apps.quantitymeasurement.auth;

import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

import com.apps.quantitymeasurement.security.JwtUtil;

@RestController
@RequestMapping("/auth")

public class OAuthController {
	private final JwtUtil jwtUtil;
	public OAuthController(JwtUtil jwtUtil)
	{
		this.jwtUtil=jwtUtil;
	}
	@GetMapping("/oauth-success")
	public String success(Authentication authentication)
	{
		String username=authentication.getName();
		return jwtUtil.generateToken(username);
	}

}
