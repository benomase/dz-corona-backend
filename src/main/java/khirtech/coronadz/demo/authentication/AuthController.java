package khirtech.coronadz.demo.authentication;

import khirtech.coronadz.demo.authentication.models.AuthenticationLogin;
import khirtech.coronadz.demo.authentication.models.AuthenticationRegister;
import khirtech.coronadz.demo.user.UserModel;
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

    @PostMapping("/register")
    public ResponseEntity<UserModel> register(@RequestBody AuthenticationRegister register) {
        UserModel userModel = authService.register(register);
        return ResponseEntity.status(HttpStatus.OK).body(userModel);
    }

    @PostMapping("/login")
    public void login(@RequestBody AuthenticationLogin login){

    }

}
