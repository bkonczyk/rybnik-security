package pl.sda.spring.securitygettingstarted.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    @ResponseStatus(CREATED)
    void createUser(@RequestBody CreateUserRequest request) {
        service.createUser(request);
    }
}
