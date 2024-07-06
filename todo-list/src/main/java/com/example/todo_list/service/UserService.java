package com.example.todo_list.service;

import com.example.todo_list.repository.entity.UserEntity;

public interface UserService {

    UserEntity createUserIfNotExists(String userName);

    UserEntity createNewUser(String userName);

    void verifyUserExistence(String userName);
}
