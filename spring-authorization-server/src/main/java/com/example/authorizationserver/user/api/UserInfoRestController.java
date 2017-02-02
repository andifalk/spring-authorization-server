package com.example.authorizationserver.user.api;

import com.example.authorizationserver.security.CommonUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * User Info endpoint.
 */
@RestController
public class UserInfoRestController {

    @RequestMapping(path = "/userinfo", method = RequestMethod.GET)
    public ResponseEntity<?> getCurrentUser(@AuthenticationPrincipal CommonUser commonUser) {
        if (commonUser != null) {
            return ResponseEntity.ok(new UserInfoResource(commonUser.getUser()));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
