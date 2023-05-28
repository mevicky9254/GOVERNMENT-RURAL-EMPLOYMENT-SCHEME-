package com.mgnrega.service;

import com.mgnrega.exception.UserException;
import com.mgnrega.model.CurrentUserSession;
import com.mgnrega.model.User;

public interface UserService {
	
	public CurrentUserSession loginToAccount(User user) throws UserException ;
	public String logOutFromAccount(String key) throws UserException;

}
