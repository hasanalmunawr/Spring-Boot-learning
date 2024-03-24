package hasanalmunawrDev.springBootsecurity.config;

import hasanalmunawrDev.springBootsecurity.util.JwtUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;


@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Fecth token from request
        var jwtTokenOptional = getTokenFromREquest(request);

        // Validate jwt token -> JWT utils
        jwtTokenOptional.ifPresent(jwtToken -> {
            if (JwtUtils.validateToken(jwtToken)) {
                // Get UserName from Jwt token
                var usernameOptional = JwtUtils.getUserNameFromToken(jwtToken);

               usernameOptional.ifPresent(username -> {
                   // Fetch user details with the help of username
                   var userDetails = userDetailsService.loadUserByUsername(username);

                   // Create Authentication token
                   var authentication = new
                           UsernamePasswordAuthenticationToken(userDetails, null , userDetails.getAuthorities());
                   authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                   // Set authentication token to security Context
                   SecurityContextHolder.getContext()
                           .setAuthentication(authentication);
               });
            }


        });
        // Pass request and response next filter
        filterChain.doFilter(request, response);
    }

    private Optional<String> getTokenFromREquest(HttpServletRequest request) {
        // Extract authentication Header
        var authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        // Beare <JWT Token>
        if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")) {
            return Optional.of(authHeader.substring(7));
        }
        return Optional.empty();
    }


}
