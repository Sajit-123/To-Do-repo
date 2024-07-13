package com.ToDoManager.ToDoManagerApp.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.ToDoManager.ToDoManagerApp.services.UserDetailService;

@Configuration
@EnableWebSecurity
public class LoginConfig{

    @Autowired
    private UserDetailService userDetailService;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.authorizeHttpRequests(registry -> {
            
            registry.requestMatchers("/","/register","/h2-console/**","/ToDoPage/**").permitAll();
            registry.anyRequest().authenticated()
            ;
        }).formLogin(formLogin -> formLogin.loginPage("/login").permitAll()
        .failureUrl("/login?error=true")
        .defaultSuccessUrl("/ToDoPage")
        .usernameParameter("email")
        .passwordParameter("password"))
        .headers(headers -> headers.frameOptions(FrameOptionsConfig::disable))
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**")); 
        
        return httpSecurity.build();
        
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return userDetailService;
    }
    
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailService);
        provider.setPasswordEncoder(bCryptPasswordEncoder());
        return provider;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }



}
