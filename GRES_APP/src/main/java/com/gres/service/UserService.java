package com.gres.service;

import com.gres.exception.UserException;
import com.gres.model.CurrentUserSession;
import com.gres.model.User;

public interface UserService {
	
	public CurrentUserSession loginToAccount(User user) throws UserException ;
	public String logOutFromAccount(String key) throws UserException;

}
