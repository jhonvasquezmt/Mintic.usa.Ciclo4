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


    /*public User save(User user){
        if (user.getId()==null){
            if (userRepository.existEmail(user.getEmail())==false){
                return userRepository.save(user);
            } else {
                return user;
            }
        } else{
            return user;
            }

        }*/
    public User save(User user) {
        if (user.getId() == null) {
            return user;
        }else {
            Optional<User> u = userRepository.getUser(user.getId());
            if (u.isEmpty()) {
                if (existEmail(user.getEmail())==false){
                    return userRepository.save(user);
                }else{
                    return user;
                }
            }else{
                return user;
            }
        }
    }
    public User update(User newUser){

        if(newUser.getId()!=null){
            Optional<User>dbUser=userRepository.getUser(newUser.getId());
            if(!dbUser.isEmpty()){
                if(newUser.getIdentification()!=null){
                    dbUser.get().setIdentification(newUser.getIdentification());
                }
                if(newUser.getName()!=null){
                    dbUser.get().setName(newUser.getName());
                }
                if(newUser.getAddress()!=null){
                    dbUser.get().setAddress(newUser.getAddress());
                }
                if(newUser.getCellPhone()!=null){
                    dbUser.get().setCellPhone(newUser.getCellPhone());
                }
                if(newUser.getEmail()!=null){
                    dbUser.get().setEmail(newUser.getEmail());
                }
                if(newUser.getPassword()!=null){
                    dbUser.get().setPassword(newUser.getPassword());
                }
                if(newUser.getZone()!=null){
                    dbUser.get().setZone(newUser.getZone());
                }
                if(newUser.getType()!=null){
                    dbUser.get().setType(newUser.getType());
                }
                return userRepository.save(dbUser.get());

            }
        }
        return newUser;
    }



    public User autenticarUser(String email,String password){
        Optional<User> user = userRepository.autenticarUser(email, password);
        if (user.isEmpty()){
            return new User();
        } else {
    return  user.get();
        }
    }
    public boolean deleteUser(int id){
        Optional<User> user=getUser(id);
        if(!user.isEmpty()){
            userRepository.delete(user.get());
            return true;
        }
        return false;

    }
    }


