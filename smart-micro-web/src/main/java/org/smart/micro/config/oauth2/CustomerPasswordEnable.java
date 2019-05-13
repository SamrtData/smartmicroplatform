package org.smart.micro.config.oauth2;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassName CustomerPasswordEnable
 * @Description TODO
 * @Author jiangsida
 * @VERSION 1.0
 */

public class CustomerPasswordEnable implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return  s.equals(charSequence);
    }
}
