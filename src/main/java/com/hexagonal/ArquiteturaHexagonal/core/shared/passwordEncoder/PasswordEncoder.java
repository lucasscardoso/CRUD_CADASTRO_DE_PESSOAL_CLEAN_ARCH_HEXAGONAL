package com.hexagonal.ArquiteturaHexagonal.core.shared.passwordEncoder;

public interface PasswordEncoder {
    String encode(String password);
    boolean matches(String password, String encodedPassword);
}
