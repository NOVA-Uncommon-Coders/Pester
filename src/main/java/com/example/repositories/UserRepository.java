package com.example.repositories;

import com.example.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Created by Eric on 4/12/17.
 */
public interface UserRepository extends CrudRepository<User, UUID> {
}
