package com.example.authorizationserver.user.api;

import com.example.authorizationserver.user.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by afa on 2/1/17.
 */
public class UserInfoResource extends ResourceSupport {

    private final User user;

    public UserInfoResource(User user) {
        this.user = user;
    }

    @JsonProperty("sub")
    public String getSubject() {
        return user.getId();
    }

    @JsonProperty("given_name")
    public String getFirstname() {
        return user.getFirstname();
    }

    @JsonProperty("family_name")
    public String getLastname() {
        return user.getLastname();
    }

    @JsonProperty("email")
    public String getEmail() {
        return user.getEmail();
    }
}
