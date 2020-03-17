package khirtech.coronadz.demo.utils;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseBuilder<T>{
    private int status;
    private T response;
}