package pl.sda.spring.securitygettingstarted.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.cors().disable();
        http.headers().frameOptions().disable();

        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/hello").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/api/users").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
