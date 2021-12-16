package com.usa.retociclo4.repository.crud;

import com.usa.retociclo4.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 *
 * @author JhonV
 */
public interface UserCrudRepository extends MongoRepository <User,Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);
    Optional<User> findById (int id);

}
