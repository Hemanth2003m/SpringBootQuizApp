package com.hems.quizapp.service;

import com.hems.quizapp.model.Register;
import com.hems.quizapp.dao.RegisterRepo;
import com.hems.quizapp.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyRegisterDetailsService implements UserDetailsService {
    @Autowired
    private RegisterRepo repo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Register user = repo.findByUsername(username);
        if(user == null){
            System.out.println("User 4o4");
            throw new UsernameNotFoundException("User 4o4");
        }

        return new UserPrincipal(user);
    }
}