package airbnb16.airbnb16.controller;

import airbnb16.airbnb16.entity.PropertyUser;
import airbnb16.airbnb16.payload.Login;
import airbnb16.airbnb16.payload.Signup;
import airbnb16.airbnb16.payload.TokenResponse;
import airbnb16.airbnb16.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
    @RequestMapping("/api/v1/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<?> createPost(@RequestBody Signup signup){
        if(userService.createUser(signup)!=null){
            return new ResponseEntity<>("Sign-up successfully", HttpStatus.CREATED);

        }
        return new ResponseEntity<>("Something went wring",HttpStatus.INTERNAL_SERVER_ERROR);


    }
    @PostMapping("/sign-in")
    public ResponseEntity<?> loginUser(@RequestBody Login login){
        String token = userService.loginUser(login);
        if(token!=null){
            TokenResponse tokenResponse = new TokenResponse();
            tokenResponse.setToken(token);
            return new ResponseEntity<>(tokenResponse,HttpStatus.OK);
        }
        return new ResponseEntity<>("Something went wring",HttpStatus.UNAUTHORIZED);

    }

    @GetMapping("/profile")
    public ResponseEntity<?> getProfile(@AuthenticationPrincipal PropertyUser  user){
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
