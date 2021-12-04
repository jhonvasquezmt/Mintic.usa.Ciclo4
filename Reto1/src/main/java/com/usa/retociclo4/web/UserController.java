package com.usa.retociclo4.web;

import com.usa.retociclo4.model.User;
import com.usa.retociclo4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author JhonV
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping("/{email}/{password}")
    public User autentUser(@PathVariable("email") String email,@PathVariable("password") String password){
        return userService.autenticarUser(email, password);
    }
    @GetMapping("/{email}")
    public boolean email(@PathVariable("email") String email){
        return userService.existEmail(email);
    }

}
