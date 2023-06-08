package org.usman.dogs_cats.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.usman.dogs_cats.service.implementation.UserImpl;


@EnableWebSecurity
@Configuration
@Slf4j
public class SecurityConfiguration {

    @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       return http.csrf().disable()

               .authorizeHttpRequests().anyRequest().permitAll()
               .and().build();

   }

   @Bean
   public BCryptPasswordEncoder passwordEncoder(){
       log.info("password-------------------------------");
         return  new BCryptPasswordEncoder();
   }


//   @Bean
//   public UserDetailsService  userDetailsService(){
//        log.info("config-------------------------------");
//        return  new UserImpl();
//   }
}
