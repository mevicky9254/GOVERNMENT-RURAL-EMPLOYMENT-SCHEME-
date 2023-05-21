package com.mgnrega.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mgnrega.exception.GMPException;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.exception.WorkerException;
import com.mgnrega.model.GramPanchayatMember;
import com.mgnrega.model.Project;
import com.mgnrega.model.Worker;


@Service
public class BDOServiceImp implements BDOService{

	@Override
	public Project createProject(Project project) throws ProjectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> viewListOfProjects() throws ProjectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GramPanchayatMember createGMP(GramPanchayatMember GMP) throws GMPException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GramPanchayatMember> viewListOfGMPS() throws GMPException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void allocateProjectToGMP(Integer gmpId, Integer projectId) throws GMPException, ProjectException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Worker> viewListWorkers() throws WorkerException {
		// TODO Auto-generated method stub
		return null;
	}

}
