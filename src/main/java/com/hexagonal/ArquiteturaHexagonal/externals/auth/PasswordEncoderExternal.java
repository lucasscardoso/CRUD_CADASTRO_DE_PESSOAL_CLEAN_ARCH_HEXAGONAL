package com.hexagonal.ArquiteturaHexagonal.externals.auth;

import com.hexagonal.ArquiteturaHexagonal.core.shared.passwordEncoder.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderExternal implements PasswordEncoder {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public String encode(String password) {
        return encoder.encode(password);
    }
}
