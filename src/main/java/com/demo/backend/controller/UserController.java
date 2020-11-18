package com.demo.backend.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.demo.backend.model.User;
import com.demo.backend.util.FileReadTxt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class UserController {
	
	@Autowired
	private FileReadTxt fileRead;

	@PostMapping("/user")
	public ResponseEntity<User> login(@RequestParam("user") String username, @RequestParam("password") String pwd) {
		User user = new User();
		try {
			
			if (fileRead.validateUser(username, pwd)) {
				String token = getJWTToken(username);
				user.setToken(token);
				
			} else {
				return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);	
	}

	private String getJWTToken(String username) {
		
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("softtekJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		return token;
	}
}
