package tech.designdesk.PokemonBuildTool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tech.designdesk.PokemonBuildTool.domain.User;
import tech.designdesk.PokemonBuildTool.util.CustomPasswordEncoder;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private CustomPasswordEncoder customPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User();
        user.setUsername(username);
        user.setPassword(customPasswordEncoder.getPasswordEncoder().encode("1234"));
        user.setId(1L);
        return user;
    }
}
