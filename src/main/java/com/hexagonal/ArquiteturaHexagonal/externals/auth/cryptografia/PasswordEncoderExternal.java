package com.hexagonal.ArquiteturaHexagonal.externals.auth.cryptografia;

import com.hexagonal.ArquiteturaHexagonal.core.shared.passwordEncoder.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderExternal implements PasswordEncoder {

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public String encode(String password) {
        return encoder.encode(password);
    }

    @Override
    public boolean matches(String password, String encodedPassword) {
        return matches(password,encodedPassword);
    }
}
