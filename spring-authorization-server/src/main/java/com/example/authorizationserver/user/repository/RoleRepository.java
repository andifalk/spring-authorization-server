package com.example.authorizationserver.user.repository;

import com.example.authorizationserver.user.entity.Role;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository for {@link Role roles}.
 */
public interface RoleRepository extends CrudRepository<Role,String> {

    Role findOneByName(String name);
}
