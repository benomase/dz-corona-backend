package khirtech.coronadz.demo.utils.Errorhandler;

public class UserRegisterErrorHandler extends RuntimeException {
    public UserRegisterErrorHandler(String message) {
        super(message);
    }
}
