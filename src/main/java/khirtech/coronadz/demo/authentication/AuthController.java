package khirtech.coronadz.demo.authentication;

import khirtech.coronadz.demo.authentication.models.AuthenticationLogin;
import khirtech.coronadz.demo.authentication.models.AuthenticationRegister;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {



    @PostMapping("/register")
    public void register(@RequestBody AuthenticationRegister register) {

    }

    @PostMapping("/login")
    public void login(@RequestBody AuthenticationLogin login){
        
    }

}
