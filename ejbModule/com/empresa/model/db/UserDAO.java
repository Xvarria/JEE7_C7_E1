package com.empresa.model.db;

import java.util.List;

import javax.ejb.Local;

@Local
public interface UserDAO {

	public List<User> getAllUsuarios();
	
	public void persist(User user);
}
