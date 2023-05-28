package com.gres.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice  //Binds the multiple exception handler into a single component
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyError> generalException(Exception e, WebRequest wr){
		
		MyError me=new MyError();
		
		me.setTimeStamp(LocalDateTime.now());
		me.setMessage(e.getMessage());
		me.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<MyError>(me,HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(ProjectException.class)
	public ResponseEntity<MyError> projectException(ProjectException e, WebRequest wr){
		
		MyError me=new MyError();
		
		me.setTimeStamp(LocalDateTime.now());
		me.setMessage(e.getMessage());
		me.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<MyError>(me,HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	@ExceptionHandler(WorkerException.class)
	public ResponseEntity<MyError> workerException(WorkerException e, WebRequest wr){
		
		MyError me=new MyError();
		
		me.setTimeStamp(LocalDateTime.now());
		me.setMessage(e.getMessage());
		me.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<MyError>(me,HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(BDOException.class)
	public ResponseEntity<MyError> BDOException(BDOException e, WebRequest wr){
		
		MyError me=new MyError();
		
		me.setTimeStamp(LocalDateTime.now());
		me.setMessage(e.getMessage());
		me.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<MyError>(me,HttpStatus.BAD_REQUEST);
	}
	
	
	
	@ExceptionHandler(GMPException.class)
	public ResponseEntity<MyError> GMPException(GMPException e, WebRequest wr){
		
		MyError me=new MyError();
		
		me.setTimeStamp(LocalDateTime.now());
		me.setMessage(e.getMessage());
		me.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<MyError>(me,HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyError>NoHandlerFoundException(NoHandlerFoundException e, WebRequest wr){
		
		MyError me=new MyError();
		
		me.setTimeStamp(LocalDateTime.now());
		me.setMessage(e.getMessage());
		me.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<MyError>(me,HttpStatus.BAD_REQUEST);
	}
	
	
	

	
	
}
