package com.nguyencongsy.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nguyencongsy.models.request.JwtRequest;
import com.nguyencongsy.models.request.JwtResponse;
import com.nguyencongsy.models.request.UserDTO;
import com.nguyencongsy.models.request.UserRoleViewLogin;
import com.nguyencongsy.services.implement.UserService;
import com.nguyencongsy.utils.CookieUtil;
import com.nguyencongsy.utils.JwtTokenUtil;

import io.jsonwebtoken.ExpiredJwtException;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
	private static final String jwtTokenCookieName = "JWT-TOKEN";
	@Value("${jwt.secret}")
	private static String secret = "Land";
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userDetailsService;

//	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
//	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest,HttpServletResponse httpServletResponse) throws Exception {
//
//		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//
//		final UserDetails userDetails = userDetailsService
//				.loadUserByUsername(authenticationRequest.getUsername());
//
//		final String token = jwtTokenUtil.generateToken(userDetails);
//		CookieUtil.create(httpServletResponse, jwtTokenCookieName, token, false, -1, "localhost");
//
//		return ResponseEntity.ok(new JwtResponse(token));
//	}
	 @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody JwtRequest authenticationRequest,HttpServletResponse httpServletResponse)throws Exception{
 		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
 		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
 		UserRoleViewLogin user_role = userDetailsService.findByUserId(authenticationRequest.getUsername());
        String token = jwtTokenUtil.generateToken(secret, userDetails.getUsername(),user_role.getRoles());
        CookieUtil.create(httpServletResponse, jwtTokenCookieName, token, false, -1, "localhost");

        return ResponseEntity.ok(new JwtResponse(token,userDetails.getUsername(),user_role.getRoles()));
    }
	 
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}
	
	@RequestMapping(value = "/logout_user", method = RequestMethod.POST)
    public ResponseEntity<?> logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{
		final String requestTokenHeader = httpServletRequest.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			try {
				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}
		}
		jwtTokenUtil.invalidateRelatedTokens(httpServletRequest);
        CookieUtil.clear(httpServletResponse, jwtTokenCookieName);
        return ResponseEntity.ok("ok");
    }
	
	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
	
}