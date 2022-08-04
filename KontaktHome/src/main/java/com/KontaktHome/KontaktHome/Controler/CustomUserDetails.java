package com.KontaktHome.KontaktHome.Controler;

import com.KontaktHome.KontaktHome.Model.Account;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
public class CustomUserDetails implements UserDetails {

    private final Long id;

    private  String name;
    private String password;
    private Collection<? extends GrantedAuthority > authorities;

    public CustomUserDetails(Long finKod_id, String name, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = finKod_id;
        this.name = name;
        this.password = password;
        this.authorities = authorities;
    }

    public static CustomUserDetails creat(Account account) {

        List<GrantedAuthority> authorityList = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority("account"));
        return new CustomUserDetails(account.getId(),account.getName(),account.getPassword(),authorityList);
    }


    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}