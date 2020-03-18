package khirtech.coronadz.demo.user;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collection = "user")
public class UserModel {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String numberPhone;
    private int age;
    private String email;
    private String password;
    private String profilePicture;

    private Address address;

}
