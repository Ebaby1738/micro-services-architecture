package com.discoverymodule.discoverymodule.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.reactive.config.EnableWebFlux;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/customer/")).hasAnyRole(Role.CUSTOMER.name(), Role.ADMIN.name())
                        .requestMatchers(new AntPathRequestMatcher("/rider/**")).hasAnyRole(Role.DELIVERY_MAN.name(), Role.ADMIN.name())
                        .requestMatchers(new AntPathRequestMatcher("api/v1/admin/**")).hasAnyRole(Role.ADMIN.name())
                        .anyRequest().authenticated())
                .addFilterBefore(lojiTrackFilter, UsernamePasswordAuthenticationFilter.class)
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        return httpSecurity.build();
    }




    }
}
