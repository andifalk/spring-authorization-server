package com.example.authorizationserver.security;

import com.example.authorizationserver.user.entity.Role;
import com.example.authorizationserver.user.entity.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.UserAuthenticationConverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementation for {@link UserAuthenticationConverter}.
 */
public class CommonUserConverter implements UserAuthenticationConverter {

    @Override
    public Map<String, ?> convertUserAuthentication(Authentication userAuthentication) {
        Map<String,Object> tokenContent = new HashMap<>();

        CommonUser principal = (CommonUser) userAuthentication.getPrincipal();
        User user = principal.getUser();

        tokenContent.put("iss", "http://localhost:8090");
        tokenContent.put("aud", "testclient");
        tokenContent.put("sub", user.getId());
        tokenContent.put("given_name", user.getFirstname());
        tokenContent.put("family_name", user.getLastname());
        tokenContent.put("email", user.getEmail());
        tokenContent.put("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()));
        return tokenContent;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Authentication extractAuthentication(Map<String, ?> map) {

        User user = new User();
        user.setEmail((String) map.get("email"));
        user.setFirstname((String) map.get("given_name"));
        user.setLastname((String) map.get("family_name"));
        user.setPassword("n/a");
        user.setId((String) map.get("sub"));

        List<String> roles = (List<String>) map.get("roles");
        roles.forEach(roleName -> user.getRoles().add(new Role(roleName)));

        CommonUser principal = new CommonUser(user);

        return new UsernamePasswordAuthenticationToken(principal, "n/a", principal.getAuthorities());
    }
}
