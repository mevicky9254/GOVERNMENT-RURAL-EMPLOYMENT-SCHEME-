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
	public ResponseEntity<Worker> addWorker(@RequestBody Worker worker) throws WorkerException{
		
		return new ResponseEntity<>(gmpService.addWorker(worker), HttpStatus.CREATED);
		
	}
	
	
	@PostMapping("gmp/allocateProject")
	public ResponseEntity<Worker> allocateProjectToWorker(@RequestParam("GMP_ID") Integer gmpId,
			                                              @RequestParam("Worker_ID") Integer workerId,
			                                              @RequestParam("Project_ID") Integer projectId) throws WorkerException, ProjectException{
		
		return new ResponseEntity<>(gmpService.allocateProjectToWorker(gmpId, workerId, projectId), HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("gmp/workerList")
	public ResponseEntity<List<Worker>> viewListOfworkers() throws WorkerException{
		
		return new ResponseEntity<>(gmpService.viewListOfworkers(), HttpStatus.CREATED);
		
	}
	
	@GetMapping("gmp/worker")
	public ResponseEntity<Worker> viewWorkerUsingAdhar(@RequestParam("Adhar")String adhar) throws WorkerException{
		
		return new ResponseEntity<>(gmpService.viewWorkerUsingAdhar(adhar), HttpStatus.OK);
		
	}
	
	@GetMapping("gmp/projects")
	public ResponseEntity<List<Project>> viewProjects(@RequestParam("GMP_ID")Integer gmp_Id) throws  GMPException{
		
		return new ResponseEntity<>(gmpService.getProjectList(gmp_Id), HttpStatus.OK);
		
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
