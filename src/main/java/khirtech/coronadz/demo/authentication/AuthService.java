package khirtech.coronadz.demo.authentication;

import khirtech.coronadz.demo.authentication.models.AuthenticationRegister;
import khirtech.coronadz.demo.user.UserModel;
import khirtech.coronadz.demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    /**
     * this method will call the user service to add one user to data base
     * we have mapped the Authentication model to the user model
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
        Optional<UserModel> result = this.userService.save(userModel);
        result.orElseThrow(() -> UserRegisterErrorHandler("Could not register User"));
        return result.get();
    }

}

