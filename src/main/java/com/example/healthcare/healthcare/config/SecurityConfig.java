package com.example.healthcare.healthcare.config;

import com.example.healthcare.healthcare.jwt.JwtFilter;
import org.hibernate.query.sqm.internal.NoParamSqmCopyContext;
import org.slf4j.helpers.NOP_FallbackServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
////
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    JwtFilter jwtFilter;
////
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         http.csrf(customizer -> customizer.disable());
               http .authorizeHttpRequests(request -> request.requestMatchers("api/user/login","/api/user/signup")
                       .permitAll().anyRequest().authenticated());
               http.formLogin(Customizer.withDefaults());
               http.httpBasic(Customizer.withDefaults());
               http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                       .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
               return http.build();
    }
////
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }
//
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((requests) -> {
//            ((AuthorizeHttpRequestsConfigurer.AuthorizedUrl)requests.anyRequest()).authenticated();
//        });
//        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        http.formLogin(Customizer.withDefaults());
//        http.httpBasic(Customizer.withDefaults());
//        return (SecurityFilterChain)http.build();
//    }

//    @Bean
//    public UserDetailsService userDetailsService(){
//
//        UserDetails user1= User.withUsername("user1")
//                .password("{noop}password1").roles("USER").build();
//
//        UserDetails admin= User.withUsername("admin")
//                .password("{noop}admin").roles("ADMIN").build();
//
//        return new InMemoryUserDetailsManager(user1,admin);
//    }
//



}
