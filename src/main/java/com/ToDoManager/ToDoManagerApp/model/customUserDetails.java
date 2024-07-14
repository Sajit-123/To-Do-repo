package com.ToDoManager.ToDoManagerApp.model;


import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;

public class customUserDetails extends Users implements UserDetails{

    
    public customUserDetails(Users user){
            super(user);
        }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
    }


    @Override
    public String getEmail(){
        return super.getEmail();
    }

    @Override
    public String getUsername() {
        return super.getFirstName();
    }
    @Override
    public String getPassword() {  
        return super.getPassword();
    }
    @Override
    public int getId() {  
        return super.getId();
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


