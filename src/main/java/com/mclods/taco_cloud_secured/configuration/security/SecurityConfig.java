package com.mclods.taco_cloud_secured.configuration.security;

import com.mclods.taco_cloud_secured.entities.User;
import com.mclods.taco_cloud_secured.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Optional;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Using In Memory User Store
//    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
//        List<UserDetails> userDetailsList = new ArrayList<>();
//
//        userDetailsList.add(new User(
//                "buzz",
//                passwordEncoder.encode("password"),
//                List.of(new SimpleGrantedAuthority("ROLE_USER"))
//        ));
//        userDetailsList.add(new User(
//                "woody",
//                passwordEncoder.encode("password"),
//                List.of(new SimpleGrantedAuthority("ROLE_USER"))
//        ));
//
//        return new InMemoryUserDetailsManager(userDetailsList);
//    }

    // Using JPA User Store
    @Bean
    public UserDetailsService userDetailsService(UserService userService) {
        return username -> {
            Optional<User> user = userService.findUserByUsername(username);

            if(user.isPresent()) {
                return user.get();
            }

            throw new UsernameNotFoundException("User: " + username + " not found!");
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/design", "/orders").hasRole("USER")
                        .requestMatchers("/", "/**").permitAll()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/design", true)
                );

        return http.build();
    }
}
