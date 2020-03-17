package khirtech.coronadz.demo.authentication;

import khirtech.coronadz.demo.authentication.models.AuthenticationLogin;
import khirtech.coronadz.demo.authentication.models.AuthenticationRegister;
import khirtech.coronadz.demo.authentication.models.AuthenticationResponse;
import khirtech.coronadz.demo.user.UserModel;
import khirtech.coronadz.demo.utils.ResponseBuilder;
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
    public ResponseEntity register(@RequestBody AuthenticationRegister register) {
        UserModel userModel = authService.register(register);
        ResponseBuilder<Object> responseBuilder = ResponseBuilder.builder()
                .response(userModel)
                .status(HttpStatus.OK.value())
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseBuilder);
    }


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationLogin authenticationLogin) {
        String username = authenticationLogin.getNumberPhone();
        String password = authenticationLogin.getPassword();
        AuthenticationResponse response = this.authService.login(username, password);
        return ResponseEntity.status(HttpStatus.OK.value()).body(response);
    }

    public void resetPassword(){

    }
    public void forgotPassword(){

    }

}
