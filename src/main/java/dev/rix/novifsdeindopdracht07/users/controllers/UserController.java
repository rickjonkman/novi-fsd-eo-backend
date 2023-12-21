package dev.rix.novifsdeindopdracht07.users.controllers;


import dev.rix.novifsdeindopdracht07.users.dto.UserDTO;
import dev.rix.novifsdeindopdracht07.users.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDto) {
        UserDTO savedUserDTO = userService.createUser(userDto);

        URI uri = URI.create(ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/" + savedUserDTO.username)
                .toUriString());

        return ResponseEntity.created(uri).build();
    }
}
