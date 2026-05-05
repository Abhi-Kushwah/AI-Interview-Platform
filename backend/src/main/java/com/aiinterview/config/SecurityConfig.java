// package com.aiinterview.config;

// import com.aiinterview.security.JwtFilter;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

// @Configuration
// public class SecurityConfig {

//     private final JwtFilter jwtFilter;

//     public SecurityConfig(JwtFilter jwtFilter) {
//         this.jwtFilter = jwtFilter;
//     }

//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//         http
//                 .csrf(csrf -> csrf.disable())
//                 .authorizeHttpRequests(auth -> auth
//                         .requestMatchers("/login", "/api/resume/**", "/resume/**").permitAll()
//                         .anyRequest().authenticated())
//                 .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                 .formLogin(form -> form.disable())
//                 .httpBasic(basic -> basic.disable())
//                 .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

//         return http.build();
//     }
// }




package com.aiinterview.config;

import com.aiinterview.security.JwtFilter;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())

            .sessionManagement(session -> 
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            )

            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login").permitAll()
                .requestMatchers("/api/**").authenticated()
                .anyRequest().permitAll()
            )

            .addFilterBefore(jwtFilter,
                org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}