package khirtech.coronadz.demo.infection;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(collection = "infection")
public class Infection {

    @Id
    private String id;
    private long creationDate;
    private GeoLocation geoLocation;
    private String sexe;
    private String types;
    private boolean verified;
    private String creatorID;

    /**
     * The Front will use the file of Gps to get the information
     */

}
