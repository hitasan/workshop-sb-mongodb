package com.course.secao26workshopmongo.dto;

import java.io.Serializable;

import com.course.secao26workshopmongo.domain.User;

public class UserDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos da classe
	private String id;
	private String name;
	private String email;
	
	
	// Contrutores
	public UserDTO() {
	}
	
	public UserDTO(User obj) {
		this.id = obj.getId();
		this.name = obj.getName();
		this.email = obj.getEmail();
	}

	
	// Getters / Setters
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }

	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }
}
