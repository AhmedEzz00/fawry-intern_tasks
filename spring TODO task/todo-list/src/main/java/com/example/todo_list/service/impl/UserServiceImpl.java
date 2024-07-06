package com.example.todo_list.service.impl;

import com.example.todo_list.error.exceptions.NotFoundException;
import com.example.todo_list.repository.UsersRepository;
import com.example.todo_list.repository.entity.UserEntity;
import com.example.todo_list.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UsersRepository usersRepository;

    @Autowired

    public UserServiceImpl(UsersRepository usersRepository){
        this.usersRepository= usersRepository;
    }

    @Override
    public UserEntity createUserIfNotExists(String userName) {
        return usersRepository.findByName(userName)
                .orElseGet(() -> createNewUser(userName));
    }

    @Override
    public UserEntity createNewUser(String userName) {
        return usersRepository.save(new UserEntity(userName));
    }

    @Override
    public void verifyUserExistence(String userName){
        Optional<UserEntity> optionalUser=usersRepository.findByName(userName);
        if(!optionalUser.isPresent()){
            throw new NotFoundException("user with name: "+userName+" doesn't exist");
        }
    }
}
