//package com.jwt.spring_security_html.config;
//
//import com.jwt.spring_security_html.service.BackUserServiceImpl;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
////@Configuration
////@EnableWebSecurity
//public class WebConfig {
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new BackUserServiceImpl();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(encoder());
//        provider.setUserDetailsService(userDetailsService());
//        return provider;
//    }
//
//    @Bean
//    public SecurityFilterChain config(HttpSecurity http) throws Exception {
//        return http.csrf(c -> c.disable())
//                    .authorizeHttpRequests(auth -> {
//                        auth.requestMatchers("/test").authenticated();
////                        auth.requestMatchers("/**").permitAll();
////                        auth.requestMatchers("/home").hasAnyRole("ADMIN", "USER");
////                        auth.requestMatchers("/home").authenticated();
//                        auth.requestMatchers("/album/all").permitAll();
//                        auth.requestMatchers("/album/test").permitAll();
////                        auth.requestMatchers("/").permitAll();
//                    })
//                    .formLogin(Customizer.withDefaults())
//                    .build();
//    }
//
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
