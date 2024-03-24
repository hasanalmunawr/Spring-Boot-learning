package hasanalmunawrDev.RestfulAPI.service;

import hasanalmunawrDev.RestfulAPI.entity.User;
import hasanalmunawrDev.RestfulAPI.model.RegisterUserRequest;
import hasanalmunawrDev.RestfulAPI.model.UpdateUserRequest;
import hasanalmunawrDev.RestfulAPI.model.UserResponse;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    @Transactional
    void register(RegisterUserRequest request);

    UserResponse get(User user);

    UserResponse update(User user, UpdateUserRequest request);
}
