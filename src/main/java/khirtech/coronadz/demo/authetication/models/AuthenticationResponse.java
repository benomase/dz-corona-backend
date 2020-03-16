package khirtech.coronadz.demo.authetication.models;

public class AuthenticationResponse {

    private  String jwt;
    private int status;
    private LoginResponse user;

    public AuthenticationResponse(String jwt, int status,LoginResponse user) {
        this.jwt = jwt;
        this.status = status;
        this.user = user;
    }

}
