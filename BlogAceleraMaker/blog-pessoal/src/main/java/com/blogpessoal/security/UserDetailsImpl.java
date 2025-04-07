package com.blogpessoal.security;

import com.blogpessoal.model.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserDetailsImpl implements UserDetails {

    private static final long serialVersionUID = 1L;

    private final String username;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(Usuario usuario) {
        this.username = usuario.getEmail();
        this.password = usuario.getSenha();
        this.authorities = Collections.emptyList(); // Sem roles, por enquanto
    }

    public UserDetailsImpl(Usuario usuario, Collection<? extends GrantedAuthority> authorities) {
        this.username = usuario.getEmail();
        this.password = usuario.getSenha();
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
