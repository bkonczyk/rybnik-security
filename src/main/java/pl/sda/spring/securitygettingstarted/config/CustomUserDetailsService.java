package pl.sda.spring.securitygettingstarted.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import pl.sda.spring.securitygettingstarted.user.User;
import pl.sda.spring.securitygettingstarted.user.UserService;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userService.findByUsername(username);
        return new UserDetailsAdapter(user);
    }
}
