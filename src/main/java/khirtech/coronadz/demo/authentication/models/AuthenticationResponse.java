package khirtech.coronadz.demo.authentication.models;

import lombok.Data;

import java.io.Serializable;

@Data
public class AuthenticationResponse implements Serializable {

    private  String jwt;
    private int status;
    private LoginResponse user;

    public AuthenticationResponse(String jwt, int status,LoginResponse user) {
        this.jwt = jwt;
        this.status = status;
        this.user = user;
    }

}
