package com.mgnrega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mgnrega.exception.GMPException;
import com.mgnrega.exception.WorkerException;
import com.mgnrega.model.GramPanchayatMember;
import com.mgnrega.model.Worker;
import com.mgnrega.service.GMPService;

@CrossOrigin(origins="*")
@RestController
public class GMPController {
	
	
	@Autowired
	public GMPService gmpService;
	
//    public Worker addWorker(Worker worker)throws WorkerException;
//	
//	public List<Worker> viewListOfworkers()throws WorkerException;
//	
//	public Worker viewWorkerUsingAdhar(String adhar)throws WorkerException;
//	
//	public GramPanchayatMember updatePassword(Integer gmpId,String password)throws GMPException;
//	
//	public Worker deleteWorker(Integer workerId)throws WorkerException;
	
	
	@PostMapping("gmp/createWorker")
	public ResponseEntity<Worker> addWorker(@RequestBody Worker worker) throws WorkerException{
		
		return new ResponseEntity<>(gmpService.addWorker(worker), HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("gmp/workerList")
	public ResponseEntity<List<Worker>> viewListOfworkers() throws WorkerException{
		
		return new ResponseEntity<>(gmpService.viewListOfworkers(), HttpStatus.CREATED);
		
	}
	
	@GetMapping("gmp/worker")
	public ResponseEntity<Worker> viewWorkerUsingAdhar(@RequestParam("Adhar")String adhar) throws WorkerException{
		
		return new ResponseEntity<>(gmpService.viewWorkerUsingAdhar(adhar), HttpStatus.OK);
		
	}
	
	
	@PutMapping("gmp/updatePassword")
	public ResponseEntity<GramPanchayatMember> updatePassword(@RequestParam("GMP_ID")Integer gmpId,@RequestParam("New_Password")String password) throws GMPException{
		
		return new ResponseEntity<>(gmpService.updatePassword(gmpId, password), HttpStatus.OK);
		
	}
	
	

	@DeleteMapping("gmp/worker")
	public ResponseEntity<Worker>deleteWorker(@RequestParam("Worker_ID")Integer workerId)throws WorkerException{
		
		return new ResponseEntity<>(gmpService.deleteWorker(workerId), HttpStatus.OK);
		
	}
	
	
	

}
