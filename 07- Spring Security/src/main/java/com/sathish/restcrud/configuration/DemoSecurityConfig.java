package com.sathish.restcrud.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();
        UserDetails sathish = User.builder()
                .username("sathish")
                .password("{noop}test345")
                .roles("EMPLOYEE")
                .build();
        UserDetails siva = User.builder()
                .username("siva")
                .password("{noop}test456")
                .roles("MANAGER")
                .build();
        return new InMemoryUserDetailsManager(john,sathish,siva);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/")
                        .hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/employees").hasRole("MANAGER"));
        http.httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
