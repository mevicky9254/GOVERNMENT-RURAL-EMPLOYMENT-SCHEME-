package com.gres.service;

import java.util.List;

import com.gres.exception.GMPException;
import com.gres.exception.ProjectException;
import com.gres.exception.UserException;
import com.gres.exception.WorkerException;
import com.gres.model.GramPanchayatMember;
import com.gres.model.Project;
import com.gres.model.Worker;

public interface GMPService {
	
	public Worker addWorker(Worker worker,String key)throws WorkerException, UserException;
	
	public List<Worker> viewListOfworkers(String key)throws WorkerException, UserException;
	
	public Worker viewWorkerUsingAdhar(String adhar, String key)throws WorkerException, UserException;
	
	public Worker allocateProjectToWorker(Integer workerId,Integer projectId, String key)throws UserException, WorkerException,ProjectException;
	
	public GramPanchayatMember updatePassword(String password, String key)throws GMPException, UserException;
	
	public Worker deleteWorker(Integer workerId, String key)throws WorkerException, UserException;
	
	public List<Project> getProjectList(String key)throws  GMPException, UserException;
	

}
