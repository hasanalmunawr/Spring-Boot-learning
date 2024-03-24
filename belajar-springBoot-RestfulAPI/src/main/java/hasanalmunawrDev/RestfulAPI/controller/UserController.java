package hasanalmunawrDev.RestfulAPI.controller;

import hasanalmunawrDev.RestfulAPI.entity.User;
import hasanalmunawrDev.RestfulAPI.model.RegisterUserRequest;
import hasanalmunawrDev.RestfulAPI.model.UpdateUserRequest;
import hasanalmunawrDev.RestfulAPI.model.UserResponse;
import hasanalmunawrDev.RestfulAPI.model.WebResponse;
import hasanalmunawrDev.RestfulAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(
            path = "/api/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<String> register(@RequestBody RegisterUserRequest request) {
        userService.register(request);
        return WebResponse.<String>builder().data("OK").build();
    }

    @GetMapping(
            path = "/api/users/current",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> get(User user) {
        UserResponse userResponse = userService.get(user);
        return WebResponse.<UserResponse>builder().data(userResponse).build();
    }

    @PatchMapping(
            path = "/api/users/current",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public WebResponse<UserResponse> update(User user, @RequestBody UpdateUserRequest updateRequest) {
        UserResponse update = userService.update(user, updateRequest);
        return WebResponse.<UserResponse>builder().data(update).build();
    }


}
