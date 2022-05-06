package tech.designdesk.PokemonBuildTool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.designdesk.PokemonBuildTool.domain.Build;
import tech.designdesk.PokemonBuildTool.domain.User;
import tech.designdesk.PokemonBuildTool.repository.BuildRepository;

import java.util.Set;

@Service
public class BuildService {

    @Autowired
    private BuildRepository buildRepo;

    public Build save(User user) {
        Build build = new Build();
        build.setUser(user);

        return buildRepo.save(build);
    }

    public Set<Build> findByUser(User user) {
        return buildRepo.findByUser(user);
    }
}
