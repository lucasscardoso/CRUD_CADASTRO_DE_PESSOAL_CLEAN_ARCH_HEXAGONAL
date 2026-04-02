package com.hexagonal.ArquiteturaHexagonal.externals.security;

import com.hexagonal.ArquiteturaHexagonal.externals.entity.UserEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component("securityUtils")
public class SecurityUtils {

    public boolean isOwner(Long idFromRoute) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (auth == null || !auth.isAuthenticated() || auth instanceof AnonymousAuthenticationToken) {
            return false;
        }

        Object principal = auth.getPrincipal();

        if (principal instanceof UserEntity user) {
            return user.getId().equals(idFromRoute);
        }

        return false;
    }
}

