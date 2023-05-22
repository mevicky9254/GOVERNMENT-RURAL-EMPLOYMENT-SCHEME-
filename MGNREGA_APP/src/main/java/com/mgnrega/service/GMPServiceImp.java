package com.mgnrega.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgnrega.exception.GMPException;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.exception.WorkerException;
import com.mgnrega.model.Project;
import com.mgnrega.model.Worker;
import com.mgnrega.repository.GMPRepository;
import com.mgnrega.repository.ProjectRepository;
import com.mgnrega.repository.WorkerRepository;


@Service
public class GMPServiceImp implements GMPService{

	@Autowired
	public ProjectRepository pRepo;
	
	@Autowired
	public GMPRepository gmpRepo;
	
	@Autowired
	public WorkerRepository workerRepo;
	
	
	@Override
	public Worker addWorker(Worker worker) throws WorkerException {
		
		
	Optional<Worker> workerOptional=workerRepo.findById(worker.getId());
	
	
	if(!workerOptional.isEmpty()) {
		
		throw new WorkerException("Worker is already present in the record with workerId : "+worker.getId()+" and name : "+worker.getName());
		
	}
	
	
	 return workerRepo.save(worker);
	
		
	}
	
	
	

	@Override
	public List<Worker> viewListOfworkers() throws WorkerException {
		
		return workerRepo.findAll();
	}

	
	
	
	@Override
	public Worker viewWorkerUsingAdhar(String adhar) throws WorkerException {
		
		Worker worker=workerRepo.findByAdhar(adhar);
		
		if(worker==null) {
			throw new WorkerException("Worker is not present in the record with adhar : "+worker.getAdhar()+" ! Enter the valid adhar or register the new Worker");
		}
		
		return worker;
	}

	
	
	@Override
	public Worker viewWorkerNameAndDays(int projectId) throws WorkerException, ProjectException {
		
		 Optional<Project>proOptional=pRepo.findById( projectId);
			
			
			Project project=proOptional.get();
			
			if(proOptional.isEmpty()) {
				
				 throw new ProjectException("Project does not exists with the ProjectID :"+project.getId()+" ! Enter a valid Project Id");
				
			}
			
			
			project.getWorkers();
			
		
		
		
	}

	@Override
	public List<Worker> viewListOfworkersWithNameAndWages() throws WorkerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Worker deleteWorker(Integer workerId) throws WorkerException {
		// TODO Auto-generated method stub
		return null;
	}

}
