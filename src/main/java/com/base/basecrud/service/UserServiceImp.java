package com.base.basecrud.service;

import com.base.basecrud.model.User;

import java.util.List;
import java.util.Optional;

public class UserServiceImp implements UserService{


    @Override
    public User createUser() {
        return null;
    }

    @Override
    public Optional<User> findByID() {
        return Optional.empty();
    }

    @Override
    public Optional<User> upDateUser() {
        return Optional.empty();
    }

    @Override
    public List<User> findAllUsers() {
        return List.of();
    }

    @Override
    public Optional<User> deleteUserById() {
        return Optional.empty();
    }
}
