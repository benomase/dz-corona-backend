package khirtech.coronadz.demo.user;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "user")
public class UserModel {
    @Id
    private String id;
    private String userName;
    private String email;
    private int age;
    private long numberPhone;
}
