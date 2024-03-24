package hasanalmunawrDev.RestfulAPI.service.impl;

import hasanalmunawrDev.RestfulAPI.entity.User;
import hasanalmunawrDev.RestfulAPI.model.RegisterUserRequest;
import hasanalmunawrDev.RestfulAPI.model.UpdateUserRequest;
import hasanalmunawrDev.RestfulAPI.model.UserResponse;
import hasanalmunawrDev.RestfulAPI.repository.UserRepository;
import hasanalmunawrDev.RestfulAPI.security.BCrypt;
import hasanalmunawrDev.RestfulAPI.service.UserService;
import hasanalmunawrDev.RestfulAPI.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Transactional
    public void register(RegisterUserRequest request) {
        validationService.validate(request);
        if (userRepository.existsById(request.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already registered");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(BCrypt.hashpw(request.getPassword(),BCrypt.gensalt()));
        user.setName(request.getName());

        userRepository.save(user);
    }

    public UserResponse get(User user){
        return UserResponse.builder().username(user.getUsername())
                .name(user.getName()).build();

    }

    @Transactional
    @Override
    public UserResponse update(User user, UpdateUserRequest request) {
        validationService.validate(request);

        if(Objects.nonNull(request.getName())) {
            user.setName(request.getName());
        }
        if (Objects.nonNull(request.getPassword())) {
            user.setPassword(request.getPassword());
        }

        userRepository.save(user);

        return UserResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .build();
    }
}
