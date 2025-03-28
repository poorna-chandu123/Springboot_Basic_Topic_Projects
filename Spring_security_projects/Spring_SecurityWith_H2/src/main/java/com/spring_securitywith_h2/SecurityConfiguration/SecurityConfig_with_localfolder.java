 package com.spring_securitywith_h2.SecurityConfiguration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity  // Role-based security
public class SecurityConfig_with_localfolder {

    @Autowired
    private DataSource dataSource;

    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) ->
                requests.requestMatchers("/h2-console/**").permitAll()
                        .anyRequest().authenticated());

        http.sessionManagement(session -> 
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.httpBasic(withDefaults());
        http.headers(headers -> 
                headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));

        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Bean
    public JdbcUserDetailsManager userDetailsService() {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public CommandLineRunner insertDefaultUsers(DataSource dataSource) {
        return args -> {
            JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

            // Ensure table exists by verifying database metadata
            try (Connection conn = dataSource.getConnection()) {
                DatabaseMetaData metaData = conn.getMetaData();
                ResultSet tables = metaData.getTables(null, null, "USERS", null);

                if (!tables.next()) {
                    System.out.println("USERS table does not exist — schema.sql may not have executed.");
                    return;
                }
            }  

            if (!jdbcUserDetailsManager.userExists("user")) {
                UserDetails user1 = User.withUsername("user")
                     //   .password("{noop}password")  // Nopasswordencoder
                		.password(passwordEncoder().encode("password"))
                        .roles("USER")
                        .build();

                UserDetails user2 = User.withUsername("admin")
                       // .password("{noop}passwordadmin")
                		.password(passwordEncoder().encode("passwordadmin"))
                        .roles("ADMIN")
                        .build();

                jdbcUserDetailsManager.createUser(user1);
                jdbcUserDetailsManager.createUser(user2);

                System.out.println("Users inserted successfully!");
            }
        };
    }

    
    
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
    
    
    
    }
    


