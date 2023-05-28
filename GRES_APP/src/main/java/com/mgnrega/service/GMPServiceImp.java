package com.mgnrega.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgnrega.exception.GMPException;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.exception.UserException;
import com.mgnrega.exception.WorkerException;
import com.mgnrega.model.CurrentUserSession;
import com.mgnrega.model.GramPanchayatMember;
import com.mgnrega.model.Project;
import com.mgnrega.model.Worker;
import com.mgnrega.repository.CurrentUserSessionRepo;
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
	
	@Autowired
	public CurrentUserSessionRepo uRepo;
	
	
	
	
	@Override
	public Worker addWorker(Worker worker, String key) throws WorkerException, UserException {
		
     CurrentUserSession user=uRepo.findByUuid(key);
		
		if(user==null) {
			throw new UserException(" Please login first !");
		}
		
		
	Optional<Worker> workerOptional=workerRepo.findById(worker.getId());
	
	
	if(!workerOptional.isEmpty()) {
		
		throw new WorkerException("Worker is already present in the record with workerId : "+worker.getId()+" and name : "+worker.getName());
		
	}
	
	
	 return workerRepo.save(worker);
	
		
	}
	
	
	

	@Override
	public List<Worker> viewListOfworkers(String key) throws WorkerException, UserException {
		
     CurrentUserSession user=uRepo.findByUuid(key);
		
		if(user==null) {
			throw new UserException(" Please login first !");
		}
		
		return workerRepo.findAll();
	}

	
	
	
	
	@Override
	public Worker viewWorkerUsingAdhar(String adhar, String key) throws WorkerException, UserException {
		
      CurrentUserSession user=uRepo.findByUuid(key);
		
		if(user==null) {
			throw new UserException(" Please login first !");
		}
		
		
		Worker worker=workerRepo.findByAdhar(adhar);
		
		if(worker==null) {
			throw new WorkerException("Worker is not present in the record with adhar : "+worker.getAdhar()+" ! Enter the valid adhar or register the new Worker");
		}
		
		return worker;
	}

	
	
	

	
	@Override
	public Worker allocateProjectToWorker(Integer gmpId,Integer workerId, Integer projectId, String key)
			                                          throws WorkerException, ProjectException, UserException {
	
		
      CurrentUserSession user=uRepo.findByUuid(key);
		
		if(user==null) {
			throw new UserException(" Please login first !");
		}
		
		
		
		Optional<Worker> optionalWorker=workerRepo.findById(workerId);
		
		if(optionalWorker==null) {
			throw new WorkerException("Worker does not exists with workerId "+workerId);
		}
		
		Worker worker=optionalWorker.get();
		
		
				
       Optional<GramPanchayatMember> optionalGmp=gmpRepo.findById(gmpId);
       
       GramPanchayatMember gmp=optionalGmp.get();
       
       List<Project> projects=gmp.getProjects();
       
       boolean flag=false;
       
       for(Project project:projects) {
    	   if(project.getId()==projectId) {
    		   
    		   worker.setProjects(project);
    		   workerRepo.save(worker);
    		   flag=true;
    		   break;
    	   }
       }
       
       
       
       if(flag==false) {
    	   throw new ProjectException("Project does not exist in GramPanchyat Members's List");
       }
		
		return worker;
			
	}
	




	@Override
	public GramPanchayatMember updatePassword(Integer gmpId, String password, String key) throws GMPException, UserException {
		  
     CurrentUserSession user=uRepo.findByUuid(key);
		
		if(user==null) {
			throw new UserException(" Please login first !");
		}
		
		
		
      Optional< GramPanchayatMember>gmpOptional=gmpRepo.findById(gmpId);
		
		
		GramPanchayatMember gmp=gmpOptional.get();
		
		if(gmpOptional.isEmpty()) {
			
			 throw new GMPException("GMP does not exists with the GMPID :"+gmp.getId()+" ! Enter a valid GMP Id");
			
		}
		
		gmp.setPassword(password);
		
		return gmpRepo.save(gmp);
		
		
	}




	@Override
	public List<Project> getProjectList(Integer gmpId, String key) throws GMPException, UserException {
		
		
       CurrentUserSession user=uRepo.findByUuid(key);
		
		if(user==null) {
			throw new UserException(" Please login first !");
		}
		
		
		 Optional< GramPanchayatMember>gmpOptional=gmpRepo.findById(gmpId);
			
			
			GramPanchayatMember gmp=gmpOptional.get();
			
			if(gmpOptional.isEmpty()) {
				
				 throw new GMPException("GMP does not exists with the GMPID :"+gmp.getId()+" ! Enter a valid GMP Id");
				
			}
			
			return gmp.getProjects();
	}


	@Override
	public Worker deleteWorker(Integer workerId, String key) throws WorkerException, UserException {
		
      CurrentUserSession user=uRepo.findByUuid(key);
		
		if(user==null) {
			throw new UserException(" Please login first !");
		}
		
		
		Optional<Worker> workerOptional=workerRepo.findById(workerId);
		
		
		if(workerOptional.isEmpty()) {
			
			throw new WorkerException("Worker is not present in the record with workerId : "+workerId);
			
		}
		
		workerRepo.deleteById(workerId);
		
		Worker worker=workerOptional.get();
		
		return worker;
		
	}




}
