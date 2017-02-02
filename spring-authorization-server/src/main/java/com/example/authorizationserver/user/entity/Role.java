package com.example.authorizationserver.user.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Role entity.
 */
@RedisHash("roles")
public class Role {

    @NotNull
    @Id
    private String id;

    @Indexed
    @NotNull
    @Size(min = 1, max = 50)
    private String name;

    public Role() {
        super();
    }

    public Role(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
