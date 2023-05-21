package com.mgnrega.service;

import java.util.List;

import com.mgnrega.exception.ProjectException;
import com.mgnrega.exception.WorkerException;
import com.mgnrega.model.Worker;

public interface GMPService {
	
	public Worker addWorker(Worker worker)throws WorkerException;
	
	public List<Worker> viewListOfworkers()throws WorkerException;
	
	public Worker viewWorkerUsingAdhar(String adhar)throws WorkerException;
	
	public Worker viewWorkerNameAndDays(int projectId)throws WorkerException,ProjectException;
	
	public List<Worker> viewListOfworkersWithNameAndWages()throws WorkerException;
	
	public Worker deleteWorker(Integer workerId)throws WorkerException;
	

}
