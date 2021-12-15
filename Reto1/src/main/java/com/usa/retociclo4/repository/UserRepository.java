package com.usa.retociclo4.repository;

import com.usa.retociclo4.model.User;
import com.usa.retociclo4.repository.crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author JhonV
 */
@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll(){
        return userCrudRepository.findAll();
    }
    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }
    public User save(User user){
        return userCrudRepository.save(user);
    }
    public boolean existEmail(String email){Optional<User> user = userCrudRepository.findByEmail(email);return !user.isEmpty();}
    public Optional<User> autenticarUser(String email, String password){return userCrudRepository.findByEmailAndPassword(email,password);}
    public void delete(User user){ userCrudRepository.delete(user);}

}
