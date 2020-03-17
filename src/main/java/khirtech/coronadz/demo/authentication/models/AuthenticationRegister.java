package khirtech.coronadz.demo.authentication.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationRegister {

    private String firstName;
    private String lastName;
    private int age;
    private String numberPhone;
    private double latitude;
    private double longitude;
    private String email;
    private String password;
    private String profilePicture;
    private int common;
    private int wilaya;

}
