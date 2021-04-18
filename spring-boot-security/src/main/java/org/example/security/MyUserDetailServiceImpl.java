package org.example.security;

import com.google.common.collect.Sets;
import org.example.security.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;

@Component("myUserDetailService")
public class MyUserDetailServiceImpl implements UserDetailsService {

    /**
     * 获取用户信息
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User();
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getEnabled(),
                user.getAccountNonExpired(),
                user.getCredentialsNonExpired(),
                user.getAccountNonLocked(),
                this.obtainGrantedAuthorities(user)
        );
    }

    private Collection<? extends GrantedAuthority> obtainGrantedAuthorities(User user) {
        HashSet<GrantedAuthority> rtn = Sets.newHashSet();
        rtn.add(new SimpleGrantedAuthority("ROLE_USER"));
        rtn.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return rtn;
    }
}
