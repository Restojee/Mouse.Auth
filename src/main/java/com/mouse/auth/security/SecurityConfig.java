package com.mouse.auth.security;

import com.mouse.auth.users.services.DefaultUserDetailsService;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private DefaultUserDetailsService defaultUserDetailsService;

    @Bean
    @Order(2)
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
            //.authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
            // Form login handles the redirect to the login page from the
            // authorization server filter chain
            .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);

        http.formLogin(Customizer.withDefaults());

        http
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement();
            //.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        return http.build();
    }

    @Bean
    @Order(3)
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web
            .ignoring()
            .requestMatchers(
                "/swagger/**",
                "/v2/api-docs",
                "/swagger-ui/**",
                "/swagger-resources/**",
                "/*/swagger-resources/**",
                "/v3/api-docs/**"
            );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        val authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(this.passwordEncoder());
        authenticationProvider.setUserDetailsService(this.defaultUserDetailsService);
        return authenticationProvider;
    }
}