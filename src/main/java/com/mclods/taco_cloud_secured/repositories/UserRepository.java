package com.mclods.taco_cloud_secured.repositories;

import com.mclods.taco_cloud_secured.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findUserByUsername(String username);
}
