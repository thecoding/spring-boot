package org.example.security.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Mirko
 * @Description
 * @createTime 2021年04月19日 22:26:00
 */
public class MyNoOpPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return charSequence.equals(s);
    }
}
