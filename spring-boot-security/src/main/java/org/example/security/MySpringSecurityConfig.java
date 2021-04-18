package org.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class MySpringSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    @Qualifier("myUserDetailService")
    UserDetailsService userDetailsService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
//        http.formLogin().loginPage("/toLogin")
//                        .loginProcessingUrl("login");

        http.authorizeRequests()
                .anyRequest().authenticated(); //任意的请求都必须认证才能访问

    }
}
