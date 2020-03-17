package khirtech.coronadz.demo.user;

import khirtech.coronadz.demo.utils.ServiceMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements ServiceMethods<UserModel> {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<UserModel> findOne(String id) {
        Optional<UserModel> result = this.userRepository.findById(id);
        return result;
    }

    @Override
    public List<UserModel> findAll() {
        List<UserModel> result = this.userRepository.findAll();
        return result;
    }

    @Override
    public Optional<UserModel> save(UserModel userModel) {
        UserModel result = this.userRepository.save(userModel);
        return Optional.of(result);
    }

    // TODO: 3/16/20 Update method not yet implementd
    
    @Override
    public Optional<UserModel> update() {
       return null;
    }


    /**
     * Find a user using his number phone
     * The Number Phone is a unique identifier
     * @param numberPhone
     */
    public Optional<UserModel> findUserByNumberPhone(String numberPhone) {
        Optional<UserModel> result  = this.userRepository.findByNumberPhone(numberPhone);
        return result;
    }



}
