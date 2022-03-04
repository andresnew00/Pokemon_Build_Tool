package tech.designdesk.PokemonBuildTool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.designdesk.PokemonBuildTool.domain.User;
import tech.designdesk.PokemonBuildTool.repository.UserRepository;
import tech.designdesk.PokemonBuildTool.util.CustomPasswordEncoder;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustomPasswordEncoder customPasswordEncoder;
    
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userOpt = userRepository.findByUsername(username);

        return userOpt.orElseThrow(() -> new UsernameNotFoundException("Invalid credentials"));
    }
}
