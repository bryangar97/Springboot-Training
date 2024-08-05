package com.deloitte.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .authorizeHttpRequests(authRegistry -> authRegistry
            .requestMatchers("/api/public/**").permitAll()
            .requestMatchers("/api/user/**").hasRole("USER")
            .requestMatchers("/api/admin/**").hasRole("ADMIN")
            .anyRequest().authenticated())
        .csrf(AbstractHttpConfigurer::disable)
        .formLogin(AbstractHttpConfigurer::disable)
        .httpBasic(Customizer.withDefaults())
        .build();
  }


  @Bean
  public UserDetailsService userDetailsService() {
    PasswordEncoder encoder = passwordEncoder();

    UserDetails userDetails = User.builder().username("user").password(encoder.encode("user")).roles("USER").build();
    UserDetails adminDetails = User.builder().username("admin").password(encoder.encode("admin")).roles("ADMIN").build();
    return new InMemoryUserDetailsManager(userDetails, adminDetails);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
