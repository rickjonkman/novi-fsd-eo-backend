package dev.rix.novifsdeindopdracht07.users.services;


import dev.rix.novifsdeindopdracht07.users.dto.RoleDTO;
import dev.rix.novifsdeindopdracht07.users.model.Role;
import dev.rix.novifsdeindopdracht07.users.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepo;

    public RoleService(RoleRepository roleRepo) {
        this.roleRepo = roleRepo;
    }

    public List<RoleDTO> getRoles() {

        List<RoleDTO> roleDtos = new ArrayList<>();

        for (Role r : roleRepo.findAll()) {
            RoleDTO rdto = new RoleDTO();
            rdto.rolename = r.getRolename();
            roleDtos.add(rdto);
        }

        return roleDtos;

    }
}
