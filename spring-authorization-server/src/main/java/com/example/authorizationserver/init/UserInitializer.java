package com.example.authorizationserver.init;

import com.example.authorizationserver.user.entity.Role;
import com.example.authorizationserver.user.entity.User;
import com.example.authorizationserver.user.repository.RoleRepository;
import com.example.authorizationserver.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Initializer for some userdata.
 */
@Component
public class UserInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Autowired
    public UserInitializer(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Role roleUser = roleRepository.findOneByName("USER");
        if (roleUser == null) {
            roleUser = new Role();
            roleUser.setName("USER");
            roleUser = roleRepository.save(roleUser);
        }

        Role roleAdmin = roleRepository.findOneByName("ADMIN");
        if (roleAdmin == null) {
            roleAdmin = new Role();
            roleAdmin.setName("USER");
            roleAdmin = roleRepository.save(roleAdmin);
        }

        if (userRepository.findOneByEmail("user@example.com") == null) {
            User user = new User();
            user.setFirstname("Udo");
            user.setLastname("User");
            user.setPassword("secret");
            user.setEmail("user@example.com");
            user.getRoles().add(roleUser);
            userRepository.save(user);
        }
        if (userRepository.findOneByEmail("admin@example.com") == null) {
            User user = new User();
            user.setFirstname("Andreas");
            user.setLastname("Admin");
            user.setPassword("supersecret");
            user.setEmail("admin@example.com");
            user.getRoles().add(roleUser);
            user.getRoles().add(roleAdmin);
            userRepository.save(user);
        }
    }
}
