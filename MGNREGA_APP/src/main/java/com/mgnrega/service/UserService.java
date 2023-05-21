package com.mgnrega.service;

import com.mgnrega.model.CurrentUserSession;
import com.mgnrega.model.User;

public interface UserService {
	
	public CurrentUserSession loginToAccount(User user) ;
	public String logOutFromAccount(String key);

}
