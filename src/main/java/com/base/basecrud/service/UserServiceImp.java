package com.base.basecrud.service;

import com.base.basecrud.model.User;
import com.base.basecrud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    UserRepository userRepository;


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findByID(Long id) {
             User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID " + id));
            return user;
    }

    @Override
    public User upDateUser(Long id,String mail,String password) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID " + id));
        user.setMail(mail);
        user.setPassword(password);

        return user;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUserById(Long id) {
       User user = userRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID " + id));
        userRepository.delete(user);
    }


}
