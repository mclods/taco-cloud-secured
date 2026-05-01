package com.mclods.taco_cloud_secured.services;

import com.mclods.taco_cloud_secured.entities.User;

import java.util.Optional;

public interface UserService {
    Optional<User> findUserByUsername(String username);

    User saveUser(User user);
}
