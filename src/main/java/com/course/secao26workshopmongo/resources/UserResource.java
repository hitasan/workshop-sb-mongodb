package com.course.secao26workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.course.secao26workshopmongo.domain.User;
import com.course.secao26workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService us;
	
	@RequestMapping(method = RequestMethod.GET)	//@GetMapping funciona do mesmo modo
	public ResponseEntity<List<User>> findAll() {

		// TESTE DA API SEM ACESSO AO DB
		//User maria = new User("1", "Maria Brown", "maria@gmail.com");
		//User alex = new User("2", "Alex Green", "alex@gmail.com");
		//List<User> list = new ArrayList<>();
		//list.addAll(Arrays.asList(maria, alex));

		List<User> list = us.findAll();	// Solicitando os dados para o service

		return ResponseEntity.ok().body(list); 
	}
}
