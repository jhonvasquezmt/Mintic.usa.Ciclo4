package com.usa.retociclo4.service;

import com.usa.retociclo4.model.User;
import com.usa.retociclo4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author JhonV
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public List<User> getAll(){
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }

    public boolean existEmail(String email){
        return userRepository.existEmail(email);
    }

    public User save(User user){
        if (user.getId()==null){
            if (userRepository.existEmail(user.getEmail())==false){
                return userRepository.save(user);
            } else {
                return user;
            }
        } else{
            return user;
            }

        }
    public User autenticarUser(String email,String password){
        Optional<User> user = userRepository.autenticarUser(email, password);
        if (user.isEmpty()){
            return new User(email, password, "NO DEFINIDO");
        } else {
    return  user.get();
        }
    }

    }


