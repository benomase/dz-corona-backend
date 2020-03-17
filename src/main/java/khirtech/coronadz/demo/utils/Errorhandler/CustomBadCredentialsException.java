package khirtech.coronadz.demo.utils.Errorhandler;

public class CustomBadCredentialsException extends RuntimeException {
    public CustomBadCredentialsException(String message) {
        super(message);
    }
}
