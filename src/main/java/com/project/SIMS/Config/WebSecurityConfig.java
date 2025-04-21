package com.project.SIMS.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable()) //http enabling
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/css/**", "/js/**").permitAll()
                        .anyRequest().authenticated()) // rules what can be viewed without and whit logging in
                .formLogin(form -> form
                        .defaultSuccessUrl("/product", true)
                        .permitAll()) // where to go after logging
                .formLogin(Customizer.withDefaults()) // default spring page
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()) // logout rules
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)) //how session is being contained eg. session
                .build(); // create initialization

    }
    // rewrite of AuthenticationManager which is what perform authentication process.
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class) //call to builder of AuthenticationManager
                .authenticationProvider(authenticationProvider()) // passing AuthenticationProvider
                .build();

    }

    // rewrite of AuthenticationProvider where we create how authentication process will look like.
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(); // constructor of build in Data Access Object Authentication Provider
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance()); // setting encoding for password
        provider.setUserDetailsService(userDetailsService); // passing object with credentials
        return provider; // return of AuthenticationProvider object
    }



}
