package dev.rix.novifsdeindopdracht07.users.services;


import dev.rix.novifsdeindopdracht07.users.dto.UserDTO;
import dev.rix.novifsdeindopdracht07.users.model.Role;
import dev.rix.novifsdeindopdracht07.users.model.User;
import dev.rix.novifsdeindopdracht07.users.repository.RoleRepository;
import dev.rix.novifsdeindopdracht07.users.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder encoder;

    public UserService(UserRepository userRepo, PasswordEncoder encoder, RoleRepository roleRepo) {
        this.userRepo = userRepo;
        this.encoder = encoder;
        this.roleRepo = roleRepo;
    }

    public UserDTO createUser(UserDTO userDTO) {
        User newUser = new User();
        newUser.setUsername(userDTO.username);
        newUser.setPassword(encoder.encode(userDTO.password));

        Set<Role> userRoles = newUser.getRoles();
        for (String rolename : userDTO.roles) {
            Optional<Role> or = roleRepo.findById("ROLE_" + rolename);
            or.ifPresent(userRoles::add);
        }
        userRepo.save(newUser);
        return transferUserToDTO(newUser);
    }

    public UserDTO transferUserToDTO(User u) {
        UserDTO userDTO = new UserDTO();
        userDTO.username = u.getUsername();
        userDTO.password = u.getPassword();
        userDTO.roles = transferListToArray(transferRoleObjectToRoleString(u.getRoles()));
        return userDTO;
    }

    public List<String> transferRoleObjectToRoleString(Set<Role> listOfRoles) {
        List<String> roleNamesList = new ArrayList<>();

        for (Role rolename : listOfRoles) {
            roleNamesList.add(rolename.getRolename());
        }

        return roleNamesList;
    }

    public String[] transferListToArray(List<String> listOfStrings) {
        String[] stringArray = new String[listOfStrings.size()];
        return listOfStrings.toArray(stringArray);
    }
}
