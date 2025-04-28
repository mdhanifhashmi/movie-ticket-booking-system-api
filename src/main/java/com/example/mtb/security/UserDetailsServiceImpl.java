package com.example.mtb.security;

import com.example.mtb.entity.UserDetail;
import com.example.mtb.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        //UserDetail userDetail = userRepository.findByEmail(username);
        /*we are fetching the user from database in this case it is in repo
        * Important point: UserDetails and UserDetail are different UserDetail is from spring security and
        * userDetail is fro entity package
        * */
        UserDetail userDetail = userRepository.findByEmail(username);
        if (userDetail == null){
            throw new UsernameNotFoundException("User with this username does not exist");
        }

        /*
        User is spring
         */
        return User.builder()
                .username(userDetail.getEmail())
                .password(userDetail.getPassword())
                .authorities(userDetail.getUserRole().name())
                .build();
    }
}
