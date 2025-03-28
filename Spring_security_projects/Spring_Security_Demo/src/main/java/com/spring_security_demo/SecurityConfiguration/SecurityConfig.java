package com.spring_security_demo.SecurityConfiguration;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity  // role base authentication kosam e anotation ni add cheyali
public class SecurityConfig {


        @Bean
        @Order(SecurityProperties.BASIC_AUTH_ORDER)
        SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
            http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
            // code for stateless session
            http.sessionManagement((session)
                    -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
            // http.formLogin(withDefaults());
            http.httpBasic(withDefaults());
            return http.build();
        }

        @Bean
       public UserDetailsService userDetailsService(){

            UserDetails user1 = User.withUsername("user1")
                   .username("user")
                    .password("{noop}password")
                    .roles("USER")
                    .build();

            UserDetails user2 = User.withUsername("user2")
                   .username("admin")
                    .password("{noop}password")
                    .roles("ADMIN")
                    .build();


            return new InMemoryUserDetailsManager(user1 , user2);

        }


    }

