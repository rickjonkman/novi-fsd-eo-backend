package dev.rix.novifsdeindopdracht07.users.controllers;


import dev.rix.novifsdeindopdracht07.users.dto.RoleDTO;
import dev.rix.novifsdeindopdracht07.users.services.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @GetMapping("/roles")
    public ResponseEntity<List<RoleDTO>> getRoles() {
        List<RoleDTO> foundRoles = roleService.getRoles();
        return ResponseEntity.ok(foundRoles);
    }
}
