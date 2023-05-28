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
public class BDOServiceImp implements BDOService{

	
	@Autowired
	public ProjectRepository pRepo;
	
	@Autowired
	public GMPRepository gmpRepo;
	
	@Autowired
	public WorkerRepository workerRepo;
	
	@Autowired
	public CurrentUserSessionRepo uRepo;
	
	
	
	@Override
	public Project createProject(Project project,String key) throws ProjectException, UserException {
		
		CurrentUserSession user=uRepo.findByUuid(key);
		
		if(user==null) {
			throw new UserException(" Please login first !");
		}
		
		
	    Optional<Project> optional = pRepo.findById(project.getId());
	    if (optional.isPresent()) {
	        Project presentProject = optional.get();
	        throw new ProjectException("Project already exists with the project Name: "
	                + presentProject.getProjectName() + " and projectId: " + presentProject.getId());
	    }

	    List<Worker> workers = project.getWorkers();
	    if (workers != null) {
	        for (Worker w : workers) {
	            w.setProjects(project);
	        }
	    }

	    GramPanchayatMember gpm = project.getGramPanchayatMember();
	    if (gpm != null) {
	        gpm.getProjects().add(project);
	        project.setGramPanchayatMember(gpm);
	    }

	    return pRepo.save(project);
	}

	
	
	

	@Override
	public List<Project> viewListOfProjects(String key) throws ProjectException ,UserException{
		
     CurrentUserSession user=uRepo.findByUuid(key);
		
		if(user==null) {
			throw new UserException(" Please login first !");
		}
		
		return pRepo.findAll();
	}

	
	

	@Override
	public Project deleteProject(Integer projectId,String key) throws ProjectException , UserException{
		
		
      CurrentUserSession user=uRepo.findByUuid(key);
 		
		if(user==null) {
			throw new UserException(" Please login first !");
		}
		
		  Optional<Project>proOptional=pRepo.findById( projectId);
			
			
			Project project=proOptional.get();
			
			if(proOptional.isEmpty()) {
				
				 throw new ProjectException("Project does not exists with the ProjectID :"+project.getId()+" ! Enter a valid Project Id");
				
			}
			
			
			 pRepo.delete(project);
			
		
		    return project;
	}
	
	
	
	
	@Override
	public GramPanchayatMember createGMP(GramPanchayatMember GMP,String key) throws GMPException, UserException {
		
        CurrentUserSession user=uRepo.findByUuid(key);
		
		if(user==null) {
			throw new UserException(" Please login first !");
		}
		
		
	    Optional<GramPanchayatMember> optional = gmpRepo.findById(GMP.getId());

	    if (optional.isPresent()) {
	        throw new GMPException("GMP already exists with the Name: " + GMP.getName() + " and GMPId: " + GMP.getId());
	    }

	    List<Project> projects = GMP.getProjects();
	    if (projects != null) {
	        for (Project project : projects) {
	            project.setGramPanchayatMember(GMP);
	        }
	    }

	    List<Worker> workers = GMP.getWorkers();
	    if (workers != null) {
	        for (Worker worker : workers) {
	            worker.setGramPanchayatMember(GMP);
	        }
	    }
	    
	  
	    
	    return gmpRepo.save(GMP);
	}


	
	@Override
	public List<GramPanchayatMember> viewListOfGMPS(String key) throws GMPException, UserException {
		
        CurrentUserSession user=uRepo.findByUuid(key);
		
		if(user==null) {
			throw new UserException(" Please login first !");
		}
		
		return gmpRepo.findAll();
	}
	
	
	@Override
	public GramPanchayatMember deleteGMP(Integer gmpId,String key) throws GMPException, UserException {
		
      CurrentUserSession user=uRepo.findByUuid(key);
		
		if(user==null) {
			throw new UserException(" Please login first !");
		}
		
		
     Optional< GramPanchayatMember>gmpOptional=gmpRepo.findById(gmpId);
		
		
		GramPanchayatMember gmp=gmpOptional.get();
		
		if(gmpOptional.isEmpty()) {
			
			 throw new GMPException("GMP does not exists with the GMPID :"+gmp.getId()+" ! Enter a valid GMP Id");
			
		}
		
		gmpRepo.delete(gmp);
		
		return gmp;
		
	}
	
	

	@Override
	public GramPanchayatMember allocateProjectToGMP(Integer gmpId, Integer projectId,String key) throws UserException, GMPException, ProjectException {
		
		
       CurrentUserSession user=uRepo.findByUuid(key);
		
		if(user==null) {
			throw new UserException(" Please login first !");
		}
		
		
		Optional< GramPanchayatMember>gmpOptional=gmpRepo.findById(gmpId);
		
		
		GramPanchayatMember gmp=gmpOptional.get();
		
		if(gmpOptional.isEmpty()) {
			
			 throw new GMPException("GMP does not exists with the GMPID :"+gmp.getId()+" ! Enter a valid GMP Id");
			
		}
		
		
		
      Optional<Project>proOptional=pRepo.findById( projectId);
		
		
		Project project=proOptional.get();
		
		if(proOptional.isEmpty()) {
			
			 throw new GMPException("Project does not exists with the ProjectID :"+project.getId()+" ! Enter a valid Project Id");
			
		}
		
		
		
	    List<Project> projectList=gmp.getProjects();
	    
	    projectList.add(project);
	    
	    for(Project p: projectList) {
	    	p.setGramPanchayatMember(gmp);
	    }
	    
		
	    return gmpRepo.save(gmp);
		
		
		
	}

	

	@Override
	public List<Worker> viewListWorkers(String key) throws WorkerException ,UserException {
		
		
      CurrentUserSession user=uRepo.findByUuid(key);
		
		if(user==null) {
			throw new UserException(" Please login first !");
		}
		
		return workerRepo.findAll();
	}










	

}
