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
import com.mgnrega.exception.ProjectException;
import com.mgnrega.exception.UserException;
import com.mgnrega.exception.WorkerException;
import com.mgnrega.model.GramPanchayatMember;
import com.mgnrega.model.Project;
import com.mgnrega.model.Worker;
import com.mgnrega.service.GMPService;

@CrossOrigin(origins="*")
@RestController
public class GMPController {
	
	
	@Autowired
	public GMPService gmpService;

	
	@PostMapping("gmp/createWorker")
	public ResponseEntity<Worker> addWorker(@RequestBody Worker worker, @RequestParam("SessionKey") String key) throws WorkerException, UserException{
		
		return new ResponseEntity<>(gmpService.addWorker(worker, key), HttpStatus.CREATED);
		
	}
	
	
	@PostMapping("gmp/allocateProject")
	public ResponseEntity<Worker> allocateProjectToWorker(@RequestParam("GMP_ID") Integer gmpId,
			                                              @RequestParam("Worker_ID") Integer workerId,
			                                              @RequestParam("Project_ID") Integer projectId,
			                                              @RequestParam("SessionKey") String key
			                                              ) throws WorkerException, ProjectException, UserException{
		
		return new ResponseEntity<>(gmpService.allocateProjectToWorker(gmpId, workerId, projectId,key), HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("gmp/workerList")
	public ResponseEntity<List<Worker>> viewListOfworkers(@RequestParam("SessionKey") String key) throws WorkerException, UserException{
		
		return new ResponseEntity<>(gmpService.viewListOfworkers(key), HttpStatus.CREATED);
		
	}
	
	
	@GetMapping("gmp/worker")
	public ResponseEntity<Worker> viewWorkerUsingAdhar(@RequestParam("Adhar")String adhar, @RequestParam("SessionKey") String key) throws WorkerException, UserException{
		
		return new ResponseEntity<>(gmpService.viewWorkerUsingAdhar(adhar,key), HttpStatus.OK);
		
	}
	
	@GetMapping("gmp/projects")
	public ResponseEntity<List<Project>> viewProjects(@RequestParam("GMP_ID")Integer gmp_Id,@RequestParam("SessionKey") String key) throws  GMPException, UserException{
		
		return new ResponseEntity<>(gmpService.getProjectList(gmp_Id, key), HttpStatus.OK);
		
	}
	
	
	@PutMapping("gmp/updatePassword")
	public ResponseEntity<GramPanchayatMember> updatePassword(@RequestParam("GMP_ID")Integer gmpId,
			                                                  @RequestParam("New_Password")String password,
			                                                  @RequestParam("SessionKey") String key) throws GMPException, UserException{
		
		return new ResponseEntity<>(gmpService.updatePassword(gmpId, password,key), HttpStatus.OK);
		
	}
	
	

	@DeleteMapping("gmp/worker")
	public ResponseEntity<Worker>deleteWorker(@RequestParam("Worker_ID")Integer workerId, @RequestParam("SessionKey") String key)throws WorkerException, UserException{
		
		return new ResponseEntity<>(gmpService.deleteWorker(workerId, key), HttpStatus.OK);
		
	}
	
	
	

}
