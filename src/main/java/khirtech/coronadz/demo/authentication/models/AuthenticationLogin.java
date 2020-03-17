package khirtech.coronadz.demo.authentication.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthenticationLogin {

    private String numberPhone;
    private String password;

}
