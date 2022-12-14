package pl.sda.spring.securitygettingstarted.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public void createUser(CreateUserRequest request) {
        User user = User.of(
                request.getUsername(),
                passwordEncoder.encode(request.getPassword()),
                "ROLE_USER"
        );
        repository.save(user);
    }

    public User findByUsername(String username) {
        return repository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username not found")
                );
    }
}
