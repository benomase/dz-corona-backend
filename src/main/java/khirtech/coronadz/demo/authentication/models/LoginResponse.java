package khirtech.coronadz.demo.authentication.models;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class LoginResponse  implements Serializable {
    private String numberPhone;
    private String id;
}
