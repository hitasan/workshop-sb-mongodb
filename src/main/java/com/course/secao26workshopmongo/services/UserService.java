package com.course.secao26workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.secao26workshopmongo.domain.User;
import com.course.secao26workshopmongo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository ur; 
	
	// Metodo para listagem de tudo dessa entidade User
	public List<User> findAll() {
		return ur.findAll();	// Solicitando os dados para o repository
	}
}
