package pl.sda.spring.securitygettingstarted;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

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
//                .antMatchers("/secured/**").authenticated()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.cors().disable();
//        http.headers().frameOptions().disable();
//
//        http.httpBasic()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/hello").permitAll()
//                .antMatchers("/api/users/create").permitAll()
//                .antMatchers("/admin").hasRole("ADMIN")
//                .antMatchers("/h2-console/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().permitAll()
//                .and()
//                .logout().permitAll();
//    }
}
