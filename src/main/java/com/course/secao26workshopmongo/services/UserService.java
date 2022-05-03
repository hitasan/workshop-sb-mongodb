package com.course.secao26workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.secao26workshopmongo.domain.User;
import com.course.secao26workshopmongo.dto.UserDTO;
import com.course.secao26workshopmongo.repository.UserRepository;
import com.course.secao26workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository ur; 
	
	public List<User> findAll() {
		return ur.findAll();	// Solicitando os dados para o repository
	}


	public User findById(String id) {
		Optional<User> obj = ur.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}


	public User insert(User obj) {
		return ur.insert(obj);
	}
	
	
	public void delete(String id) {
		findById(id);
		ur.deleteById(id);
	}
	
	
	// -------------------------------
	public User fromDTO(UserDTO objDTO) {
		return new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
	}
}
