package com.mgnrega.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mgnrega.exception.ProjectException;
import com.mgnrega.exception.WorkerException;
import com.mgnrega.model.Worker;


@Service
public class GMPServiceImp implements GMPService{

	@Override
	public Worker addWorker(Worker worker) throws WorkerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Worker> viewListOfworkers() throws WorkerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Worker viewWorkerUsingAdhar(String adhar) throws WorkerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Worker viewWorkerNameAndDays(int projectId) throws WorkerException, ProjectException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Worker> viewListOfworkersWithNameAndWages() throws WorkerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Worker deleteWorker(Integer workerId) throws WorkerException {
		// TODO Auto-generated method stub
		return null;
	}

}
