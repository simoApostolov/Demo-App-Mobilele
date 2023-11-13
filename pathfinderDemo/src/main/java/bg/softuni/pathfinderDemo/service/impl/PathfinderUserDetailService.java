package bg.softuni.pathfinderDemo.service.impl;

import bg.softuni.pathfinderDemo.model.entity.User;
import bg.softuni.pathfinderDemo.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PathfinderUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    public PathfinderUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        var userEntity = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with email "+ email + "was not found!"));
        return map(userEntity);
    }

    private UserDetails map (User user) {
        Set<GrantedAuthority> grantedAuthoritySet =
                user.getRoles()
                        .stream()
                        .map(r -> new SimpleGrantedAuthority("ROLE_" + r.getName().name())).collect(Collectors.toSet());

                return new org.springframework.security.core.userdetails.User(
                        user.getEmail(),
                        user.getPassword(),
                        grantedAuthoritySet
                );
    }
}
