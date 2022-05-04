package com.course.secao26workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.course.secao26workshopmongo.domain.Post;
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

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = us.findById(id);
		
		return ResponseEntity.ok().body( new UserDTO(obj) ); 
	}

	@RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
		User obj = us.findById(id);
		
		return ResponseEntity.ok().body( obj.getPosts() ); 
	}


	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDTO) {
		User obj = us.fromDTO(objDTO);
		obj = us.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		return ResponseEntity.created(uri).build(); 
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody UserDTO objDTO, @PathVariable String id) {
		User obj = us.fromDTO(objDTO);
		obj.setId(id);
		obj = us.update(obj);
		return ResponseEntity.noContent().build();	// 204 - codigo de uma operação sem conteudo
	}
	
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		us.delete(id);
		return ResponseEntity.noContent().build();	// 204 - codigo de uma operação sem conteudo
	}
}
