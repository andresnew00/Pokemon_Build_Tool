package tech.designdesk.PokemonBuildTool.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import tech.designdesk.PokemonBuildTool.domain.Build;
import tech.designdesk.PokemonBuildTool.domain.User;

import java.util.Set;

public interface BuildRepository extends JpaRepository<Build, Long> {
    Set<Build> findByUser(User user);
}
