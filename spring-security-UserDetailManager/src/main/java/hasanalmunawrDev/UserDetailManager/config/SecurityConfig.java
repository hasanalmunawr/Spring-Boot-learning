package hasanalmunawrDev.UserDetailManager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@EnableMethodSecurity
@Configuration
public class SecurityConfig {


//    @Bean
//    SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
//        return security.authorizeHttpRequests(aut -> {
//            aut.requestMatchers(AntPathRequestMatcher.antMatcher())
//                    aut.anyRequest().authenticated();
//        })
//                .headers(headers -> headers.frameOptions(Customizer.withDefaults()).disable())
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults())
//                .build();
//    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests( auth -> {
                    auth.requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll();
                    auth.anyRequest().authenticated();
                })
                // ignore cross-site-request-forgery(CSRF) , though you should never disable it, but for to access some tools we need to disable it
                .csrf(csrf -> csrf.ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")))
                // important to display h2-console in frame in browser.
                .headers(headers -> headers.frameOptions(withDefaults()).disable())
                .formLogin(withDefaults())
                .httpBasic(withDefaults()) // if formLogin is not available, then we can use it.
                .build();
    }


}
