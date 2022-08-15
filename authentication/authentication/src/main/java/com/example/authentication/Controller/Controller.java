package com.example.authentication.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.authentication.Entity.User;
import com.example.authentication.Exception.TokenInvalidException;
import com.example.authentication.Payload.AuthResponse;
import com.example.authentication.Payload.LoginRequest;
import com.example.authentication.Security.JwtHandler;
import com.example.authentication.Service.CustomUserDetailsService;

@RestController

@CrossOrigin("*")
public class Controller {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private JwtHandler jwtHandler;
	private static String use;
	@PostMapping("/auth")
	public ResponseEntity<?> generateToken(@RequestBody LoginRequest loginRequest) throws Exception{
		use=loginRequest.getUsername();
		System.out.println(loginRequest);
		try {
			this.authenticationManager.authenticate
				(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		}
		catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
			
			
		}
		catch(BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}
		UserDetails userDetails=this.customUserDetailsService.loadUserByUsername(loginRequest.getUsername());
		String token=this.jwtHandler.generateToken(userDetails);
		System.out.println("JWT "+token);
		return ResponseEntity.ok(new AuthResponse(loginRequest.getUsername(),token));
		
	}	
	@GetMapping("/validate")
    public boolean validateAndReturnUser(@RequestHeader("Authorization") String token)  {
		
		
        if(jwtHandler.validateToken(token.substring(7)).equals(use)) {
        	return true;
        	
        }
        else{
        	return false;
  
        }
	}
	
	@GetMapping("/current-user")
	public User getCurrentUser(Principal principal) {
		return (User) this.customUserDetailsService.loadUserByUsername(principal.getName());
		
	}
	
	
	
	
	

}
