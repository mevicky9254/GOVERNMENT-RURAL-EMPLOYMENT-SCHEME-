package com.gres.service;

import java.util.List;

import com.gres.exception.BDOException;
import com.gres.exception.GMPException;
import com.gres.exception.ProjectException;
import com.gres.exception.UserException;
import com.gres.exception.WorkerException;
import com.gres.model.BlockDevelopmentOfficer;
import com.gres.model.GramPanchayatMember;
import com.gres.model.Project;
import com.gres.model.Worker;

public interface BDOService {
	
	public BlockDevelopmentOfficer  registerBDO(BlockDevelopmentOfficer BDO)throws BDOException;
	
	public Project createProject(Project project, String key)throws ProjectException, UserException;
	
	public List<Project> viewListOfProjects(String key)throws ProjectException, UserException;
	
	public Project deleteProject(Integer pro_Id,String key)throws ProjectException, UserException;
	
	public GramPanchayatMember createGMP( GramPanchayatMember GMP, String key)throws GMPException, UserException;
	
	public List<GramPanchayatMember> viewListOfGMPS(String key)throws GMPException, UserException;
	
	public GramPanchayatMember deleteGMP(Integer gmp_Id, String key)throws  GMPException, UserException;
	
	public GramPanchayatMember allocateProjectToGMP(Integer gmpId,Integer projectId,String key)throws GMPException,ProjectException, UserException;
	
	public List<Worker> viewListWorkers(String key)throws WorkerException, UserException;

}
