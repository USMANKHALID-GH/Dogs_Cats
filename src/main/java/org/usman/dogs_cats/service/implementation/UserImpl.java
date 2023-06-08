
package org.usman.dogs_cats.service.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.usman.dogs_cats.model.User;
import org.usman.dogs_cats.repository.UserRepository;
import org.usman.dogs_cats.service.UserService;

@Service
@Slf4j
public class UserImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) {
        log.info("........................"+username);
         return userRepository.findByUserEmail(username).
                 orElseThrow(()->new UsernameNotFoundException("User not found: "+username));

    }

    @Bean
    public UserDetailsService userDetailsService(){
        log.info("111111111111111111");
        return (userName)->userRepository.findByUserEmail(userName).
                orElseThrow(()->new UsernameNotFoundException("User not found"));
    }

    public void saveUser(User user)
    {
     user.setPassword(passwordEncoder.encode(user.getPassword()));
     userRepository.save(user);
    }
}
