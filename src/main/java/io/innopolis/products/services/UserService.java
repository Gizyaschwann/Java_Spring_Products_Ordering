package io.innopolis.products.services;
import org.springframework.security.core.userdetails.UserDetailsService;

import io.innopolis.products.dto.UserRegistrationDto;
import io.innopolis.products.models.User;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto user);

    User findByUsername(String username);
}