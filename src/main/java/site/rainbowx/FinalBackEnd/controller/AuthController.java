package site.rainbowx.FinalBackEnd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;


import site.rainbowx.FinalBackEnd.dto.auth.LoginResponse;
import site.rainbowx.FinalBackEnd.dto.auth.LoginUserDto;
import site.rainbowx.FinalBackEnd.dto.auth.RegisterUserDto;
import site.rainbowx.FinalBackEnd.dto.user.UserInfoDto;
import site.rainbowx.FinalBackEnd.entity.User;
import site.rainbowx.FinalBackEnd.exception.AuthorizationException;
import site.rainbowx.FinalBackEnd.service.AuthenticationService;
import site.rainbowx.FinalBackEnd.service.JwtService;
import site.rainbowx.FinalBackEnd.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtService jwtService;
    private final UserServiceImpl userService;
    private final UserDetailsService userDetailsService;
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthController(JwtService jwtService, AuthenticationService authenticationService, UserDetailsService userDetailsService, UserServiceImpl userService) {
        this.jwtService = jwtService;
        this.userService = userService;
        this.userDetailsService = userDetailsService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public UserInfoDto register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return UserInfoDto.fromUser(registeredUser);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        return new LoginResponse()
                .setToken(jwtToken)
                .setExpiresIn(jwtService.getExpirationTime());
    }

    @GetMapping("/me")
    public UserInfoDto getCurrentUser(@RequestHeader(value = "Authorization", defaultValue = "") String jwt_token) {
        try {
            String username = jwtService.extractUsername(jwt_token);
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            boolean is_valid = jwtService.isTokenValid(jwt_token, userDetails);
            User user = userService.getUserInfo(username);
            if (is_valid) {
                return UserInfoDto.fromUser(user);
            }
        }
        catch (Exception e) {
            throw new AuthorizationException("Authorization is not valid", e);
        }
        throw new AuthorizationException("Authorization is not valid");
    }
}
