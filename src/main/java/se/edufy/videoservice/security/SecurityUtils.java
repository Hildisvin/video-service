package se.edufy.videoservice.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;

public final class SecurityUtils {

    private SecurityUtils() {
    }

    public static Long currentChannelId() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !(auth.getPrincipal() instanceof Jwt jwt)) {
            throw new IllegalStateException("No JWT authentication present");
        }

        String claim = jwt.getClaimAsString("channel_id");
        if (claim == null) {
            throw new IllegalStateException("No channel_id claim in token");
        }

        return Long.valueOf(claim);
    }
}
