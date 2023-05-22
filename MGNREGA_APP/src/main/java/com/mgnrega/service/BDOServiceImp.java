package com.mgnrega.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgnrega.exception.GMPException;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.exception.WorkerException;
import com.mgnrega.model.GramPanchayatMember;
import com.mgnrega.model.Project;
import com.mgnrega.model.Worker;
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
	
	
	@Override
	public Project createProject(Project project) throws ProjectException {
		
	Optional<Project>pOptional=	pRepo.findById(project.getId());
	
	  Project presentProject=pOptional.get();
	 if(!pOptional.isEmpty()) {
		 throw new ProjectException("Project already exists with the project Name :"+presentProject.getProjectName()+" and projectId : "+presentProject.getId());
	 }
	 return pRepo.save(project);
	 
	}
	
	
	

	@Override
	public List<Project> viewListOfProjects() throws ProjectException {
		
		return pRepo.findAll();
	}

	
	
	
	@Override
	public GramPanchayatMember createGMP(GramPanchayatMember GMP) throws GMPException {
		
	Optional<GramPanchayatMember>optional=	gmpRepo.findById(GMP.getId());
	
	GramPanchayatMember presentGmp=optional.get();
	
	
	
	
	if(!optional.isEmpty()) {
		
		 throw new GMPException("GMP already exists with the Name :"+GMP.getName()+" and GMPId : "+GMP.getId());
		
	}
	
	return gmpRepo.save(GMP);

		
	}

	
	@Override
	public List<GramPanchayatMember> viewListOfGMPS() throws GMPException {
		
		return gmpRepo.findAll();
	}
	
	

	@Override
	public List<Project> allocateProjectToGMP(Integer gmpId, Integer projectId) throws GMPException, ProjectException {
		
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
	    
	    
		
	    return gmpRepo.save(gmp).getProjects();
		
		
		
	}

	

	@Override
	public List<Worker> viewListWorkers() throws WorkerException {
		
		return workerRepo.findAll();
	}

}
