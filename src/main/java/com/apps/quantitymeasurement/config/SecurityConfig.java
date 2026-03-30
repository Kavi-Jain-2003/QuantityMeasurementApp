package com.apps.quantitymeasurement.config;

import org.springframework.context.annotation.Bean;


import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.apps.quantitymeasurement.model.User;
import com.apps.quantitymeasurement.repository.UserRepository;
import com.apps.quantitymeasurement.security.JwtFilter;
import com.apps.quantitymeasurement.security.JwtUtil;
import com.apps.quantitymeasurement.service.CustomUserDetailsService;

import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtFilter jwtFilter;
	private final JwtUtil jwtUtil;

	public SecurityConfig(JwtUtil jwtUtil) {
	    this.jwtUtil = jwtUtil;
	}


    @Autowired
    private CustomUserDetailsService userDetailsService;

    
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http,
                                                       PasswordEncoder passwordEncoder) throws Exception {

        AuthenticationManagerBuilder builder =
                http.getSharedObject(AuthenticationManagerBuilder.class);

        builder.userDetailsService(userDetailsService)
               .passwordEncoder(passwordEncoder);

        return builder.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // plain text
    }

    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
            		.requestMatchers(
            			    "/auth/login",
            			    "/auth/register",
            			    "/login/oauth2/**",
            			    "/oauth2/**"
            			).permitAll()


                .anyRequest().authenticated()
            )
            .oauth2Login(oauth -> oauth
            	    .successHandler((request, response, authentication) -> {

            	        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();

            	        String email = oAuth2User.getAttribute("email");
            	        String name = oAuth2User.getAttribute("name");

            	        if (!userRepository.existsByUsername(email)) {
            	            User user = new User();
            	            user.setUsername(email);
            	            user.setPassword("OAUTH_USER");
            	            user.setProvider("GOOGLE");
            	            user.setRole("USER");
            	            userRepository.save(user);
            	        }

            	        String token = jwtUtil.generateToken(email);

            	        response.setContentType("application/json");
            	        response.getWriter().write("{\"token\": \"" + token + "\"}");
            	    })
            	)

            .exceptionHandling(ex -> ex
                    .authenticationEntryPoint((request, response, authException) -> {
                        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                        response.setContentType("application/json");
                        response.getWriter().write("{\"error\": \"Unauthorized\"}");
                    })
             )
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable());

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
