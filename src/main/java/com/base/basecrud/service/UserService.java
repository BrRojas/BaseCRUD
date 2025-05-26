package com.base.basecrud.service;

import com.base.basecrud.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser();
    Optional<User> findByID();//por ahora pongo un optional.
    Optional<User> upDateUser();
    List<User> findAllUsers();
    Optional<User> deleteUserById();
}
