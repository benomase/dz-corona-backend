package khirtech.coronadz.demo.authentication.models;

import khirtech.coronadz.demo.user.Address;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationRegister {
    private String firstName;
    private String lastName;
    private String numberPhone;
    private int age;
    private String email;
    private String password;
    private String profilePicture;
    private Address address;
}
