package dev.rix.novifsdeindopdracht07.users.repository;


import dev.rix.novifsdeindopdracht07.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
