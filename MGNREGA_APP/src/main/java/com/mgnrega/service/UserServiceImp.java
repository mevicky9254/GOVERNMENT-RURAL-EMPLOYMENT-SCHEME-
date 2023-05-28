                                                                                                                                                                                                                                                                     package com.mgnrega.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgnrega.exception.UserException;
import com.mgnrega.model.BlockDevelopmentOfficer;
import com.mgnrega.model.CurrentUserSession;
import com.mgnrega.model.GramPanchayatMember;
import com.mgnrega.model.User;
import com.mgnrega.repository.BDORepository;
import com.mgnrega.repository.CurrentUserSessionRepo;
import com.mgnrega.repository.GMPRepository;
import com.mgnrega.repository.UserRepository;

import net.bytebuddy.utility.RandomString;


@Service
public class UserServiceImp implements UserService{

	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private CurrentUserSessionRepo currentUserRepo;
	
	@Autowired
	private GMPRepository gmpRepo;
	
	@Autowired
	private BDORepository bdoRepo;
	
	
	
	
	@Override
	public CurrentUserSession loginToAccount(User user) throws UserException {
		
		
		if(user.getType().equalsIgnoreCase("GMP")) {
			
			 GramPanchayatMember existingGMP=gmpRepo.findByEmail(user.getUserId());
			
			if(existingGMP==null) {
				throw new UserException("User does not exists with userId "+user.getUserId());
			}
			
			
			Optional<CurrentUserSession> optional= currentUserRepo.findByUsername(existingGMP.getEmail());
			
			if(optional.isPresent()) {
				throw new UserException("GMP is already logged in with  "+user.getUserId());
			}
			
			if(existingGMP.getPassword().equalsIgnoreCase(user.getPassword())) {
				
				String sessionKey=RandomString.make(5);
				
				CurrentUserSession currentUser=new CurrentUserSession();
				currentUser.setUserId(existingGMP.getId());
				currentUser.setUsername(existingGMP.getEmail());
				currentUser.setUuid(sessionKey+"GMP");
				currentUser.setLocalDateTime(LocalDateTime.now());
				
				currentUserRepo.save(currentUser);
				
				return currentUser;	
				
			}else {
				throw new UserException("Invalid Password");
			}
			
			
		  }else if(user.getType().equalsIgnoreCase("BDO")) {
				
				 BlockDevelopmentOfficer existingBDO=bdoRepo.findByEmail(user.getUserId());
				
				if(existingBDO==null) {
					throw new UserException("User does not exists with userId "+user.getUserId());
				}
				
				
				Optional<CurrentUserSession> optional= currentUserRepo.findByUsername(existingBDO.getEmail());
				
				if(optional.isPresent()) {
					throw new UserException("BDO is already logged in with  "+user.getUserId());
				}
				
				if(existingBDO.getPassword().equalsIgnoreCase(user.getPassword())) {
					
					String sessionKey=RandomString.make(5);
					
					CurrentUserSession currentUser=new CurrentUserSession();
					currentUser.setUserId(existingBDO.getId());
					currentUser.setUsername(existingBDO.getEmail());
					currentUser.setUuid(sessionKey+"BDO");
					currentUser.setLocalDateTime(LocalDateTime.now());
					
					currentUserRepo.save(currentUser);
					
					return currentUser;	
				}else {
					throw new UserException("Invalid Password");
				}
				
		  }else {
			  
			  throw new UserException("Invalid User details");
		  }
		
		
		
	}
	
	
	

	@Override
	public String logOutFromAccount(String key) throws UserException {
		CurrentUserSession currentUserSession = currentUserRepo.findByUuid(key);
		if (currentUserSession.equals(null))
			throw new UserException("Log in first");

		currentUserRepo.delete(currentUserSession);
		return "Logged Out Successfully !";
	}
	
	
	
	
}
                                                                                                                                                                                                                                                                                                                                                                                                          