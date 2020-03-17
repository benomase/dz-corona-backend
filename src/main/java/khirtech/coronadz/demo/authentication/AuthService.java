package khirtech.coronadz.demo.authentication;

import khirtech.coronadz.demo.authentication.models.AuthenticationRegister;
import khirtech.coronadz.demo.authentication.models.AuthenticationResponse;
import khirtech.coronadz.demo.authentication.models.LoginResponse;
import khirtech.coronadz.demo.security.JwtUtil;
import khirtech.coronadz.demo.security.UserDetailsCustom;
import khirtech.coronadz.demo.user.UserModel;
import khirtech.coronadz.demo.user.UserService;
import khirtech.coronadz.demo.utils.Errorhandler.CustomBadCredentialsException;
import khirtech.coronadz.demo.utils.Errorhandler.UserNotFoundException;
import khirtech.coronadz.demo.utils.Errorhandler.UserRegisterErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class AuthService {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsCustom userDetailsService;
    private final JwtUtil jwtTokenUtil;


    @Autowired
    public AuthService(AuthenticationManager authenticationManager,
                       UserDetailsCustom userDetailsService,
                       JwtUtil jwtTokenUtil,
                       UserService userService) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userService = userService;
    }

    /**
     * this method will call the user service to add one user to data base
     * we have mapped the Authentication model to the user model
     *
     * @param model
     * @return
     */
    public UserModel register(AuthenticationRegister model) {
        UserModel userModel = UserModel.builder()
                .firstName(model.getFirstName())
                .numberPhone(model.getNumberPhone())
                .age(model.getAge())
                .password(model.getPassword())
                .email(model.getEmail())
                .lastName(model.getLastName())
                .latitude(model.getLatitude())
                .longitude(model.getLongitude())
                .build();

        // TODO: 3/17/20  verify the user exist or no first if exist  not add it throw an ex

        Optional<UserModel> result = this.userService.save(userModel);
        result.orElseThrow(() -> new UserRegisterErrorHandler("Could not register User"));
        return result.get();
    }


    /**
     * Authentication username and password based
     *
     * @param
     * @param
     * @return
     */
    public AuthenticationResponse login(String numberPhone, String password) {
        String jwt = null;
        LoginResponse.LoginResponseBuilder loginResponseBuilder = LoginResponse.builder();

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(numberPhone, password));
            final UserDetails userDetails = userDetailsService.loadUserByUsername(numberPhone);
            jwt = jwtTokenUtil.generateToken(userDetails);
            UserModel userResult = this.userService.findUserByNumberPhone(numberPhone).get();
            loginResponseBuilder
                    .id(userResult.getId())
                    .numberPhone(userResult.getNumberPhone());

        } catch (BadCredentialsException e) {
            throw new CustomBadCredentialsException("Incorrect username or password");
        }

        return new AuthenticationResponse(jwt, 200, loginResponseBuilder.build());
    }


}

