package com.gres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gres.exception.UserException;
import com.gres.model.CurrentUserSession;
import com.gres.model.User;
import com.gres.service.UserService;

@CrossOrigin(origins="*")
@RestController
public class UserController {

	@Autowired
	public UserService userService;
	
	

	@PostMapping("/login")
	public ResponseEntity<CurrentUserSession> logInCustomer(@RequestBody User user) throws UserException {

		CurrentUserSession result = userService.loginToAccount(user);

		return new ResponseEntity<>(result, HttpStatus.OK);

	}
	
	@PostMapping("/logout")
	public ResponseEntity<String> logOutCustomer(@RequestParam(required = false) String key) throws UserException {

		String result = userService.logOutFromAccount(key);

		return new ResponseEntity<String>(result, HttpStatus.NO_CONTENT);

	}
	
}
