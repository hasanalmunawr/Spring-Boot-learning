package hasanalmunawrDev.springBootsecurity.service;

import hasanalmunawrDev.springBootsecurity.Auth;
import hasanalmunawrDev.springBootsecurity.repostory.AuthRepository;
import hasanalmunawrDev.springBootsecurity.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    protected AuthRepository authRepository;
    @Override
    public String login(String username, String password) {
        var authToken = new UsernamePasswordAuthenticationToken(username, password);

        var authenticate = authenticationManager.authenticate(authToken);
        ((UserDetails)(authenticate.getPrincipal())).getUsername();
        // Generate token
        return JwtUtils.generateToken(username);
    }

    @Override
    public String signUp(String name, String username, String password) {
        // Check whether user already exists or not
         if (authRepository.existsByUsername(username)) {
             throw new RuntimeException("username already exists");
         }
         // Encode password
        var encode = passwordEncoder.encode(password);
        // Authoritis
        var authoritis = new ArrayList<GrantedAuthority>();
        authoritis.add(new SimpleGrantedAuthority("ROLE_USER"));

        Auth newAuth = Auth.builder()
                .name(name)
                .username(username)
                .password(encode)
                .authorities(authoritis)
                .build();
        authRepository.save(newAuth);

        // Generate token
        return JwtUtils.generateToken(username);
    }
}
