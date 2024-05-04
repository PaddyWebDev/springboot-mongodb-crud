
package com.app.mongodbcrud.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.app.mongodbcrud.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}