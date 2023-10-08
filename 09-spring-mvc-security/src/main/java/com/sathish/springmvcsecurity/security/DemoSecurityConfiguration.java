package com.sathish.springmvcsecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfiguration {


    // For JDBC Users

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    // Fot Manual Users

    /*

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails sathish = User.builder()
                .username("sathish")
                .password("{noop}5482")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}5482")
                .roles("EMPLOYEE","MANAGER")
                .build();
        UserDetails dev = User.builder()
                .username("dev")
                .password("{noop}5482")
                .roles("EMPLOYEE")
                .build();
        return new InMemoryUserDetailsManager(sathish,john,dev);
    }

    */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers(HttpMethod.GET,"/meetings").hasRole("MANAGER")
                                .requestMatchers(HttpMethod.GET,"/systems").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied")
                )
                .formLogin(form ->
                        form
                                .loginPage("/showMyLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                );

        return http.build();
    }
}
