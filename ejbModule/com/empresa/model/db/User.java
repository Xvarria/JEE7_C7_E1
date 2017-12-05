package com.empresa.model.db;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.empresa.model.external.UserCommand;

@Entity
@Table(schema = "APP", name = "CLIENTE")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -366283986788235006L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String correo;
	private String password;

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + id;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}
	
	public static UserCommand castToUserCommand(User user){
		UserCommand userCommand = new UserCommand();
		userCommand.setId(user.getId());
		userCommand.setNombre(user.getNombre());
		userCommand.setPassword(user.getPassword());
		userCommand.setCorreo(user.getCorreo());
		return userCommand;
	}
	
	public static User castToUser(UserCommand userCommand){
		User user = new User();
		user.setId(userCommand.getId());
		user.setNombre(userCommand.getNombre());
		user.setPassword(userCommand.getPassword());
		user.setCorreo(userCommand.getCorreo());
		return user;
	}
}
