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
			
			 GramPanchayatMember exixtingGMP=gmpRepo.findByIdEmail(user.getUserId());
			
			if(exixtingGMP==null) {
				throw new UserException("User does not exists with userId "+user.getUserId());
			}
			
			
			Optional<CurrentUserSession> optional= currentUserRepo.findById(exixtingGMP.getId());
			
			if(optional.isPresent()) {
				throw new UserException("GMP is already logged in with  "+user.getUserId());
			}
			
			if(exixtingGMP.getPassword().equalsIgnoreCase(user.getPassword())) {
				
				String sessionKey=RandomString.make(6);
				
				CurrentUserSession currentUser=new CurrentUserSession();
				currentUser.setUserId(exixtingGMP.getId());
				currentUser.setUuid(sessionKey);
				currentUser.setLocalDateTime(LocalDateTime.now());
				
				currentUserRepo.save(currentUser);
				
				return currentUser;	
				
			}else {
				throw new UserException("Invalid Password");
			}
			
			
		  }else if(user.getType().equalsIgnoreCase("BDO")) {
				
				 BlockDevelopmentOfficer exixtingBDO=bdoRepo.findByEmail(user.getUserId());
				
				if(exixtingBDO==null) {
					throw new UserException("User does not exists with userId "+user.getUserId());
				}
				
				
				Optional<CurrentUserSession> optional= currentUserRepo.findById(exixtingBDO.getId());
				
				if(optional.isPresent()) {
					throw new UserException("BDO is already logged in with  "+user.getUserId());
				}
				
				if(exixtingBDO.getPassword().equalsIgnoreCase(user.getPassword())) {
					
					String sessionKey=RandomString.make(6);
					
					CurrentUserSession currentUser=new CurrentUserSession();
					currentUser.setUserId(exixtingBDO.getId());
					currentUser.setUuid(sessionKey);
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
                                                                                                                                                                                                                                                                                                                                                                                                          