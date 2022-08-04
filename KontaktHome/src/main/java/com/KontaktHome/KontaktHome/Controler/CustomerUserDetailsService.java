package com.KontaktHome.KontaktHome.Controler;

import com.KontaktHome.KontaktHome.Model.Account;
import com.KontaktHome.KontaktHome.Repositoty.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerUserDetailsService implements UserDetailsService {


    private AccountRepository userRepository;
    public CustomerUserDetailsService(AccountRepository userRepository) {

        this.userRepository = userRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Account account = userRepository.findByUsername(name);
        return CustomUserDetails.creat(account);
    }
    public UserDetails loadUserById(Long id) {

        Account account = userRepository.findById(id).get();
        return CustomUserDetails.creat(account);
    }


}

