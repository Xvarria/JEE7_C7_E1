package com.empresa.model.db;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import com.empresa.model.external.UserCommand;

@Stateful
public class UserServiceImpl implements UserService {

	@EJB
	UserDAO userDAO;
	
	@Override
	public List<UserCommand> getAllUsuarios() {
		List<User> users = this.userDAO.getAllUsuarios();
		List<UserCommand> result = new ArrayList<UserCommand>();
		for (User user : users){
			result.add(User.castToUserCommand(user));
			
		}
		return result;
	}

	@Override
	public void persist(UserCommand userCommand) {
		this.userDAO.persist(User.castToUser(userCommand));
	}

}
