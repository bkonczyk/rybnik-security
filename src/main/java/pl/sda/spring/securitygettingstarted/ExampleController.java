package pl.sda.spring.securitygettingstarted;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class ExampleController {

    @GetMapping
    String hello() {
        return "This is accessible by all";
    }

    @GetMapping("/secured")
    String secured() {
        return "This is for authenticated only";
    }

    @GetMapping("/admin")
    String admin() {
        return "This is for admins only";
    }
}
