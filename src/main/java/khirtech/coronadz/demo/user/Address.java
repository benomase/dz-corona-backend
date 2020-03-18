package khirtech.coronadz.demo.user;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@Document(collation = "address")
public class Address {

    private int wilaya;
    private int common;
    private GpsPosition gpsPosition;
    
    @Data
    private class GpsPosition {
        private double latitude;
        private double longitude;
    }
}

