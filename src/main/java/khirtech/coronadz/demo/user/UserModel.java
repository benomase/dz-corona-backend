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
    private int age;
    private String numberPhone;
    private double latitude;
    private double longitude;
    private String email;
    private String password;
    private String profilePicture;
}
