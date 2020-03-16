package khirtech.coronadz.demo.security;

import khirtech.coronadz.demo.user.UserModel;
import khirtech.coronadz.demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
public class UserDetailsCustom implements UserDetailsService {

    @Autowired
    private UserService userService;

    /**
     * We use the phoneNumber attr as username and for insure the authentication
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserModel> result = userService.findUserByNumberPhone(s);
        result.orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        // return the user model and the Authorized array of the user 
        // TODO: 3/16/20 implement the user Roles
        User user = new User(result.get().getNumberPhone(),result.get().getPassword(),new ArrayList<>());
        return user;
    }
}
