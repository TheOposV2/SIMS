package com.project.SIMS.services;

import com.project.SIMS.model.UserPrincipal;
import com.project.SIMS.model.Users;
import com.project.SIMS.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// logic of logging in process
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //creating user object
        Users user = repo.findByUsername(username);

        //checking if exist
        if(user == null){
            System.out.println("User Not Fount");
            throw new UsernameNotFoundException("User Not Fount");
        }else {
            System.out.println("user found");
        }

        //returning valid user
        return new UserPrincipal(user);
    }
}
