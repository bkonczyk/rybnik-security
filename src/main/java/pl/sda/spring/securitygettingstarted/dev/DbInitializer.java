package pl.sda.spring.securitygettingstarted.dev;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.sda.spring.securitygettingstarted.user.User;
import pl.sda.spring.securitygettingstarted.user.UserRepository;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
@Profile("dev")
public class DbInitializer {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct()
    void initializeUsers() {
        repository.save(User.of("admin", passwordEncoder.encode("admin"), "ROLE_ADMIN"));
        repository.save(User.of("andrzej", passwordEncoder.encode("andrzej"), "ROLE_USER"));
    }
}
