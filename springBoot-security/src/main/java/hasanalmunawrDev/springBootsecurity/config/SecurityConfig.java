package hasanalmunawrDev.springBootsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private JWTAuthenticationFilter jwtAuthentication;


    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        // Disable CORS
        http.cors(AbstractHttpConfigurer::disable);

        // Disable CSRF
        http.csrf(AbstractHttpConfigurer::disable);

        // Http Request Filter
        http.authorizeHttpRequests(
                requestMatcher ->
                requestMatcher.requestMatchers("/api/auth/login/**").permitAll()
                        .requestMatchers("/api/auth/sign-up/**").permitAll()
                        .anyRequest().authenticated()
        );

        // Authentication Entry Point -> Exception
        http.exceptionHandling(
                exceptionHandlingConfigurer ->  exceptionHandlingConfigurer
                        .authenticationEntryPoint(authenticationEntryPoint)
        );

        // Set sessions policy = STATELESS
        http.sessionManagement(
                securitySessionManagementConfigurer -> securitySessionManagementConfigurer
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        // Add Jwt Authentication Filter
        http.addFilterBefore(jwtAuthentication, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}
