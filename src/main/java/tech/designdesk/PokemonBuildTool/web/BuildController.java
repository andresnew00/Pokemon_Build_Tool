package tech.designdesk.PokemonBuildTool.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.designdesk.PokemonBuildTool.domain.Build;
import tech.designdesk.PokemonBuildTool.domain.User;
import tech.designdesk.PokemonBuildTool.service.BuildService;

import java.util.Set;

@RestController
@RequestMapping("api/builds")
public class BuildController {

    @Autowired
    private BuildService buildService;

    @PostMapping("")
    public ResponseEntity<?> createBuild(@AuthenticationPrincipal User user) {
        Build newBuild = buildService.save(user);

        return ResponseEntity.ok(newBuild);
    }

    @GetMapping("")
    public ResponseEntity<?> getBuild(@AuthenticationPrincipal User user) {
        Set<Build> buildByUser = buildService.findByUser(user);
        return ResponseEntity.ok(buildByUser);
    }
}
