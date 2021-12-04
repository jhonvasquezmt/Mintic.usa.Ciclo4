package com.usa.retociclo4.repository.crud;

import org.springframework.data.repository.CrudRepository;
import com.usa.retociclo4.model.User;

import java.util.Optional;

/**
 *
 * @author JhonV
 */
public interface UserCrudRepository extends CrudRepository <User,Integer> {

    Optional<User> findByEmail(String email);
    Optional<User> findByEmailAndPassword(String email,String password);

}
