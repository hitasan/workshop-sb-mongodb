package com.course.secao26workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.secao26workshopmongo.domain.Post;
import com.course.secao26workshopmongo.repository.PostRepository;
import com.course.secao26workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repos; 
	

	public Post findById(String id) {
		Optional<Post> obj = repos.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle(String text) {
		//return repos.findByTitleContainingIgnoreCase(text);
		return repos.searchTitle(text);
	}
}