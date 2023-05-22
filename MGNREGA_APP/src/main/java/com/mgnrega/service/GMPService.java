package com.mgnrega.service;

import java.util.List;

import com.mgnrega.exception.GMPException;
import com.mgnrega.exception.ProjectException;
import com.mgnrega.exception.WorkerException;
import com.mgnrega.model.GramPanchayatMember;
import com.mgnrega.model.Worker;

public interface GMPService {
	
	public Worker addWorker(Worker worker)throws WorkerException;
	
	public List<Worker> viewListOfworkers()throws WorkerException;
	
	public Worker viewWorkerUsingAdhar(String adhar)throws WorkerException;
	
	public GramPanchayatMember updatePassword(Integer gmpId,String password)throws GMPException;
	
	public Worker deleteWorker(Integer workerId)throws WorkerException;
	

}
