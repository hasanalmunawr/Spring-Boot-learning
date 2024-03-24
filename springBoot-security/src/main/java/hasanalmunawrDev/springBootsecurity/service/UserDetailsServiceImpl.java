package hasanalmunawrDev.springBootsecurity.service;

import hasanalmunawrDev.springBootsecurity.Auth;
import hasanalmunawrDev.springBootsecurity.repostory.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AuthRepository authRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Auth auth = authRepository.findByUsername(username).orElseThrow(() ->
            new UsernameNotFoundException("Username not found"));

        return new User(auth.getUsername(), auth.getPassword(), auth.getAuthorities());
    }
}
