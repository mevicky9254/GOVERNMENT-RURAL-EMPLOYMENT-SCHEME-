package com.mgnrega.service;

import java.util.List;

import com.mgnrega.exception.GMPException;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.exception.UserException;
import com.mgnrega.exception.WorkerException;
import com.mgnrega.model.GramPanchayatMember;
import com.mgnrega.model.Project;
import com.mgnrega.model.Worker;

public interface BDOService {
	
	public Project createProject(Project project, String key)throws ProjectException, UserException;
	
	public List<Project> viewListOfProjects(String key)throws ProjectException, UserException;
	
	public Project deleteProject(Integer pro_Id,String key)throws ProjectException, UserException;
	
	public GramPanchayatMember createGMP( GramPanchayatMember GMP, String key)throws GMPException, UserException;
	
	public List<GramPanchayatMember> viewListOfGMPS(String key)throws GMPException, UserException;
	
	public GramPanchayatMember deleteGMP(Integer gmp_Id, String key)throws  GMPException, UserException;
	
	public GramPanchayatMember allocateProjectToGMP(Integer gmpId,Integer projectId,String key)throws GMPException,ProjectException, UserException;
	
	public List<Worker> viewListWorkers(String key)throws WorkerException, UserException;

}
