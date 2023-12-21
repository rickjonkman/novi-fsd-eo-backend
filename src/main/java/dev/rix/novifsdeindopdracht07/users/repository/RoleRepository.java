package dev.rix.novifsdeindopdracht07.users.repository;


import dev.rix.novifsdeindopdracht07.users.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
}
