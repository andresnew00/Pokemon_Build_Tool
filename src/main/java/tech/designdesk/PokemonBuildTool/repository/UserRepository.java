package tech.designdesk.PokemonBuildTool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.designdesk.PokemonBuildTool.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
