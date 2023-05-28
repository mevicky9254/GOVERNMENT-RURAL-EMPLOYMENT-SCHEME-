package com.mgnrega.service;

import java.util.List;

import com.mgnrega.exception.GMPException;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.exception.UserException;
import com.mgnrega.exception.WorkerException;
import com.mgnrega.model.GramPanchayatMember;
import com.mgnrega.model.Project;
import com.mgnrega.model.Worker;

public interface GMPService {
	
	public Worker addWorker(Worker worker,String key)throws WorkerException, UserException;
	
	public List<Worker> viewListOfworkers(String key)throws WorkerException, UserException;
	
	public Worker viewWorkerUsingAdhar(String adhar, String key)throws WorkerException, UserException;
	
	public Worker allocateProjectToWorker(Integer gmpId,Integer workerId,Integer projectId, String key)throws UserException, WorkerException,ProjectException;
	
	public GramPanchayatMember updatePassword(Integer gmpId,String password, String key)throws GMPException, UserException;
	
	public Worker deleteWorker(Integer workerId, String key)throws WorkerException, UserException;
	
	public List<Project> getProjectList(Integer gmpId, String key)throws  GMPException, UserException;
	

}
