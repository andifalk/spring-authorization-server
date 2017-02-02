package com.example.authorizationserver.user.repository;

import com.example.authorizationserver.user.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link User users}.
 */
public interface UserRepository extends CrudRepository<User, String> {

    User findOneByEmail(String email);
}
