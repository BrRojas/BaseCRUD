package com.base.basecrud.service;

import com.base.basecrud.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);
    User findByID(Long id);//por ahora pongo un optional.
    User upDateUser(Long id,String mail,String password);
    List<User> findAllUsers();
    void deleteUserById(Long id);
}
