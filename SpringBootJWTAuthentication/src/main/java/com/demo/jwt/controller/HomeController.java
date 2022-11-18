package com.demo.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jwt.model.JwtRequest;
import com.demo.jwt.model.JwtResponse;
import com.demo.jwt.service.UserService;
import com.demo.jwt.utility.JWTUtility;

@RestController
public class HomeController {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
    @Autowired
    private UserService userService;
    
    @Autowired
    private JWTUtility jwtUtility;
	

	@GetMapping("/")
	public String home() {
		return "Welcome to Daily Code Buffer!!";
	}
	
	@PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),jwtRequest.getPassword())
            );
            
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());

        final String token =jwtUtility.generateToken(userDetails);

        return  new JwtResponse(token);
    }
}
