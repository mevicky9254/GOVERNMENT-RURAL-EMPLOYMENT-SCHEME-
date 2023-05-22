package com.mgnrega.service;

import java.util.List;

import com.mgnrega.exception.GMPException;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.exception.WorkerException;
import com.mgnrega.model.GramPanchayatMember;
import com.mgnrega.model.Project;
import com.mgnrega.model.Worker;

public interface BDOService {
	
	public Project createProject(Project project)throws ProjectException;
	
	public List<Project> viewListOfProjects()throws ProjectException;
	
	public GramPanchayatMember createGMP( GramPanchayatMember GMP)throws GMPException;
	
	public List<GramPanchayatMember> viewListOfGMPS()throws GMPException;
	
	public List<Project> allocateProjectToGMP(Integer gmpId,Integer projectId)throws GMPException,ProjectException;
	
	public List<Worker> viewListWorkers()throws WorkerException;

}
