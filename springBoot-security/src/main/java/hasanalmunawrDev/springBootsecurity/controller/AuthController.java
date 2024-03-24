package hasanalmunawrDev.springBootsecurity.controller;

import hasanalmunawrDev.springBootsecurity.model.AuthRequestDto;
import hasanalmunawrDev.springBootsecurity.model.AuthResponseDto;
import hasanalmunawrDev.springBootsecurity.model.AuthStatus;
import hasanalmunawrDev.springBootsecurity.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping(path = "/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody AuthRequestDto requestDto) {
        var jwtToken = authService.login(requestDto.getUsername(), requestDto.getPassword());

        var authResponseDto =
                new AuthResponseDto(jwtToken, AuthStatus.LOGIN_SUCCESS);

        return ResponseEntity.status(HttpStatus.OK).body(authResponseDto);
    }

    @PostMapping(path = "/sign-up")
    public ResponseEntity<AuthResponseDto> signUp(@RequestBody AuthRequestDto requestDto) {
        var jwtToken = authService.signUp(requestDto.getName(), requestDto.getUsername(), requestDto.getPassword());

        var authResponseDto =
                new AuthResponseDto(jwtToken.toString(), AuthStatus.LOGIN_SUCCESS);

        return ResponseEntity.status(HttpStatus.OK).body(authResponseDto);
    }


}
