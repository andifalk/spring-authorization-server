package com.example.authorizationserver.security;

import com.example.authorizationserver.user.entity.Role;
import com.example.authorizationserver.user.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * User details implementation.
 */
public class CommonUser implements UserDetails {

    CommonUser(User user) {
        this.user = user;
    }

    private User user;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        if (user != null) {
            user.getRoles()
                    .stream()
                    .map(Role::getName)
                    .forEach(roleName -> authorities.add(new SimpleGrantedAuthority(roleName)));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.getUser() != null ? this.getUser().getPassword() : null;
    }

    @Override
    public String getUsername() {
        return this.getUser() != null ? this.getUser().getUserId() : null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User getUser() {
        return user;
    }
}
