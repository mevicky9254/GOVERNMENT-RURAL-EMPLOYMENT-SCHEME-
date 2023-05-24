package com.mgnrega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mgnrega.exception.WorkerException;
import com.mgnrega.model.Worker;
import com.mgnrega.service.GMPService;

@CrossOrigin(origins="*")
@RestController
public class UserController {

	@Autowired
	public GMPService gmpService;
	
	
	@PostMapping("gmp/Worker")
	public ResponseEntity<Worker> addWorker(@RequestBody Worker worker) throws WorkerException{
		
		return new ResponseEntity<>(gmpService.addWorker(worker), HttpStatus.CREATED);
		
	}
	
}
