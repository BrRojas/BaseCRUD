package com.base.basecrud.service;

import com.base.basecrud.model.User;
import com.base.basecrud.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImpTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImp userServiceImp;



    @Test
    void createUser() {
        User user = new User(null,"Braian","1234",null);
        User savedUser = new User(1L,"Braian","1234",null);

        when(userRepository.save(user)).thenReturn(savedUser);

        User result = userServiceImp.createUser(user);

        assertEquals(1L,result.getId());
        assertEquals("Braian",result.getMail());
        assertEquals("1234",result.getPassword());
        verify(userRepository).save(user);


    }

    @Test
    void findByID() {
        Long id = 1L;
        User user = new User(id,"Braian","1234",null);

        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        User result = userServiceImp.findByID(id);


        assertEquals("Braian",result.getMail());
        assertEquals("1234",result.getPassword());
        verify(userRepository).findById(id);




    }

    @Test
    void upDateUser() {
        Long id = 1L;
        User existingUser = new User(id, "Braian", "1234", null);
        User updatedUser = new User(id, "Brandom", "4321", null);

        when(userRepository.findById(id)).thenReturn(Optional.of(existingUser));

        User result = userServiceImp.upDateUser(id, "Brandom", "4321");

        assertEquals("Brandom", result.getMail());
        assertEquals("4321", result.getPassword());
        verify(userRepository).findById(id);
    }


    @Test
    void findAllUsers() {

        List<User> users = List.of(
                new User(1L,"Braian","1234",null),
                new User(2L,"Bastian", "1234",null)
        );


        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userServiceImp.findAllUsers();

        assertEquals(2, result.size());
        assertEquals("Braian", result.get(0).getMail());
        assertEquals("Bastian", result.get(1).getMail());
        assertEquals("1234", result.get(0).getPassword());
        assertEquals("1234", result.get(1).getPassword());
        verify(userRepository).findAll();

    }

    @Test
    void deleteUserById() {
        Long id = 1L;
        User user = new User(id,"Braian","1234",null);

        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        userServiceImp.deleteUserById(id);

        verify(userRepository).delete(user);

    }
}