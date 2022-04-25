package com.course.secao26workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.course.secao26workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
