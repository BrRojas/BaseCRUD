package com.base.basecrud.controller;

import com.base.basecrud.model.User;
import com.base.basecrud.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImp userServiceImp;

    @PostMapping
    public User createUser(@RequestBody User user){
        return userServiceImp.createUser(user);
        }

    @PutMapping("/{id}")
    public User upDateUser(@PathVariable Long id, @RequestBody String mail, String password){
    return userServiceImp.upDateUser(id, mail,password);
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable Long id){
        return userServiceImp.findByID(id);
    }


    @GetMapping
    public List<User> getAllUser(){
        return userServiceImp.findAllUsers();
    }


    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id){
        userServiceImp.deleteUserById(id);
    }


}
