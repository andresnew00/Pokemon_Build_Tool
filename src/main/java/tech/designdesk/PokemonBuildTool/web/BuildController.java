package tech.designdesk.PokemonBuildTool.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import tech.designdesk.PokemonBuildTool.domain.Build;
import tech.designdesk.PokemonBuildTool.domain.User;
import tech.designdesk.PokemonBuildTool.service.BuildService;

import java.util.Optional;
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
    public ResponseEntity<?> getBuilds(@AuthenticationPrincipal User user) {
        Set<Build> buildByUser = buildService.findByUser(user);
        return ResponseEntity.ok(buildByUser);
    }

    @GetMapping("{buildId}")
    public ResponseEntity<?> getBuild(@PathVariable Long buildId, @AuthenticationPrincipal User user) {
        Optional<Build> buildOpt = buildService.findById(buildId);
        return ResponseEntity.ok(buildOpt.orElse(new Build()));
    }
}
