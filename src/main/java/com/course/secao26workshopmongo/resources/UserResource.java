package com.course.secao26workshopmongo.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.course.secao26workshopmongo.domain.User;
import com.course.secao26workshopmongo.dto.UserDTO;
import com.course.secao26workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService us;
	
	@RequestMapping(method = RequestMethod.GET)	//@GetMapping funciona do mesmo modo
	public ResponseEntity<List<UserDTO>> findAll() {

		List<User> list = us.findAll();	// Solicitando os dados para o service
		List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());	// Converto a list para stream para manipular com o map (como se fosse um ascan mas instanciando um novo UserDTO), converte novamente para list no fim

		return ResponseEntity.ok().body(listDTO); 
	}
}
