package pl.sda.spring.securitygettingstarted.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class User {

    @Id
    @Column(unique = true)
    private String username;
    private String password;
    private String role;
}
